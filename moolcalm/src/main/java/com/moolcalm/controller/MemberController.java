package com.moolcalm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.moolcalm.domain.InfoVO;
import com.moolcalm.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {
	private MemberService service;

	@GetMapping("list")
	public void list(Model model) {
		log.info("list");
		//                  배열이름, select된 결과물.
		model.addAttribute("list", service.getList());
		//return "list";
	}
	@GetMapping("read")           //mvc model아님
	public void read(InfoVO email, Model model) {	
		log.info("read="+email);
		model.addAttribute("read", service.get(email));
	}
	
	//글쓰기 화면으로 이동하기 위해 만듦
	@GetMapping("register")
	public void register() {	
		log.info("register");
	}
	//글쓰기 화면에서 글쓰기 버튼을 클릭했을 때 제목, 내용, 작성자를 처리하기 위해 존재.
	@PostMapping("register")
	
	//리턴타입 메소드명             (타입 변수명)
	//void add            (int a)
	public String registerPost(InfoVO password, RedirectAttributes rttr) {	
		log.info("register = " + password);
		service.register(password); //글쓰기 한 후
		rttr.addAttribute("password", service.get(password));
		return "redirect:/board/read"; //board/read.jsp화면이동.
	}
	//수정화면으로 이동(modify.jsp)을 위해 작성
	@GetMapping("modify")
	public void modifyGet(InfoVO password, Model model) {
		log.info("modify");
		model.addAttribute("modify", service.get(password));
	}
	// 글수정 화면에서 글수정 버튼을 클릭했을 때 제목, 내용을 처리하기 위해.
	@PostMapping("modify")
	public String modifyPost(InfoVO password, RedirectAttributes rttr, Model model) {
		log.info("modifyPost"+password);
		model.addAttribute("result", service.modify(password));
		rttr.addAttribute("password", service.get(password));
		return "redirect:/board/read";
	}
	@GetMapping("remove")
	public String remove(InfoVO email) {
		log.info("remove"+email);
		service.remove(email);
		return "redirect:/board/list";
		}
}
