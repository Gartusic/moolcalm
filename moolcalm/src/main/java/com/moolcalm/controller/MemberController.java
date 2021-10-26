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

	//ȸ������ ȭ�� ������
	@GetMapping("register")
	public void register() {	
		log.info("register");
	}
	
	// ���������� �̵�
	@GetMapping("member_info")
	public void myPage() {	
		log.info("member_info");
	}
	
	//���Ƿα����׽�Ʈ
	@GetMapping("sessionLogin")
	public void sessionLoginGet() {
		log.info("�α��� ȭ������ �̵�");
	}
	//���Ƿα��ν����׽�Ʈ
	@PostMapping("sessionLogin")
	public String sessionLoginPost(InfoVO member, HttpSession session) {	
		log.info("�α��μ���ó��");
		
		//���� ����
		InfoVO info=service.login(member);
		//service.login�� member��� �Ű�����(infoVO�� ����)�� �����ϴ� info��� ����
		session.setAttribute("ssn", info); //������ ssn��� ������ info�� ����
		if(session.getAttribute("ssn")!=null) { // ssn�� null�� �ƴϸ�
			return "redirect:/"; // mainȭ������ �̵�
		}else {
			return "redirect:/member/sessionLogin"; //null�̸� �ٽ� �α���ȭ������ �̵�
		}
		
	}// session�α��� ��
	
	//�α׾ƿ�
	@PostMapping("logout")
	public void logoutPost(HttpSession session) {
		log.info("�α׾ƿ� ���� ó��");
		session.removeAttribute("ssn");
		// �Ǵ�, session.invalidate(); -> ��� �Ӽ� ����
	}
	
}
