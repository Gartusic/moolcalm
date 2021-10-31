package com.moolcalm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moolcalm.domain.CollectionVO;
import com.moolcalm.domain.InfoVO;
import com.moolcalm.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

	@Autowired
	ProductService service;

	// 전체 목록 띄우기
	// GET Mapping을 사용하면 된당
	// URL : http://localhost:8080/board/list 를 실행하면 아래 내용이 표출
	@RequestMapping(value = "p_list", method = RequestMethod.GET)
	public void list(Model model) {
		log.info("list");
		// "배열명", select된 결과물
		model.addAttribute("list", service.getList());
	}

	@GetMapping("/p_detail")
	public void read(String p_setname, Model model) {
		log.info("read" + p_setname);
		// 셀렉트 여러개 해야될때는 이런식으로 모델 계속 추가하면 됩니다.?
		model.addAttribute("read", service.read(p_setname));
		model.addAttribute("readList", service.readList(p_setname));
		model.addAttribute("readProductCount", service.readProductCount(p_setname));
	}

	// 구매 기능
//	@PostMapping("/buy")
//	public String buy(InfoVO email, ProductVO p_name, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		System.out.println(email);
//		if (session.getAttribute("ssn") != null) { // ssn가 null이 아니면
//			email = (InfoVO) session.getAttribute("ssn");
//			log.info("구매 정보: " + session + "," + email.getEmail() + "," + p_name.getP_name());
//			service.buy(email, p_name);
//			return "redirect:/products/p_list"; // main화면으로 이동
//		} else {
//			return "redirect:/member/sessionLogin"; // null이면 다시 로그인화면으로 이동
//		}
//	}
	
	@PostMapping("/buy")
	public String buy(String p_name, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException{
		// session은 기본적으로 HttpSevletRequest에서 돌아다니므로 거기서 가져와서 쓰는방법이 가장 안전함
		HttpSession session = request.getSession();
		// 이렇게 하면 됨 거의
		System.out.println(session.getAttribute("ssn"));
		// 비번은 굳이 세션에 저장 안시키는게 좋아용
		
		//알림창 띄울 준비,,
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter Alert = response.getWriter();
        
        // 로그인이 되어 있을 때
		if(session.getAttribute("ssn") != null) {
			// 타입 지정후
			CollectionVO col = new CollectionVO();
			
			// 스트링으로 가져오면 되니
			String email = ((InfoVO) session.getAttribute("ssn")).getEmail();
				
			// 넣어주고
			col.setEmail(email);
			col.setP_name(p_name);
            
			// 상품이 중복되지 않으면
			if(service.product_check(col)!= 1) {
			
				log.info("구매 성공");
				// 빠샤, 구매하기
				service.buy(col);
				
				Alert.println("<script>alert('구매 성공!')</script>");              
	              Alert.flush(); // 초기화
				// 그리고 물품을 사면 그 물품의 갯수도 줄어야겠죠?
				// 여기다가 넣을수 있으면 좋겠네요 파이팅!
				
				// 성공적으로 끝났을 터이니 리스트로
				return "/products/p_list"; // 알림과 리다이렉트는 충돌되기때문에 같이 쓰면 안됩니당 ㅇㅅㅇ
			} else {
				log.info("중복되는 상품 발견");
				// 알림창 띄우기
	            Alert.println("<script>alert('이미 구매하신 상품입니다.')</script>");              
	              Alert.flush(); // 초기화

	              model.addAttribute("list", service.getList());
				return "products/p_list";
				// Alert는 @ResponseBody 추가 후 실행 가능함
				/*String errmsg = "";
				errmsg = "<script>alert('보관함에 중복되는 상품이 있습니다.');location.href='redirect:/products/p_detail'</script>";
				return errmsg;*/
				// 지금은 postMapping이라서 안먹히나?싶다. 왜안되는지 모르겟음;
			}
			

		}
		log.info("로그인 먼저 하세요");
		// 아니면 걍 로그인 창으로 보내면 되겠죠?
		return "redirect:/member/sessionLogin";
		
	}
	
	// RestController는 기존의 Controller를 더 연습하고 하면 좀 재밌을거에용
	// 나중에 보고 나면 신세계입니다 ㅎㅎ
	// 하게 된다면 기초 알려드릴게용
	// get, post, put, delete 다 달라서용

}
