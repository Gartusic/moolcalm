package com.moolcalm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	//회원가입 화면 보여줌
	@GetMapping("register")
	public void register() {	
		log.info("register");
	}
	
	// 마이페이지 이동
	@GetMapping("member_info")
	public void myPage() {	
		log.info("member_info");
	}
	
	//세션로그인테스트
	@GetMapping("sessionLogin")
	public void sessionLoginGet() {
		log.info("로그인 화면으로 이동");
	}
	//세션로그인실행테스트
	@PostMapping("sessionLogin")
	public String sessionLoginPost(InfoVO member, HttpSession session) {	
		log.info("로그인서비스처리");
		
		//변수 선언
		InfoVO info=service.login(member);
		//service.login에 member라는 매개변수(infoVO의 내용)를 저장하는 info라는 변수
		session.setAttribute("ssn", info); //세션의 ssn라는 변수에 info를 저장
		if(session.getAttribute("ssn")!=null) { // ssn가 null이 아니면
			return "redirect:/"; // main화면으로 이동
		}else {
			return "redirect:/member/sessionLogin"; //null이면 다시 로그인화면으로 이동
		}
		
	}// session로그인 끝
	
	//로그아웃
	@PostMapping("logout")
	public void logoutPost(HttpSession session) {
		log.info("로그아웃 서비스 처리");
		session.removeAttribute("ssn");
		// 또는, session.invalidate(); -> 모든 속성 제거
	}
	
}
