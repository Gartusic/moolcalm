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
		//                  �迭�̸�, select�� �����.
		model.addAttribute("list", service.getList());
		//return "list";
	}
	@GetMapping("read")           //mvc model�ƴ�
	public void read(InfoVO email, Model model) {	
		log.info("read="+email);
		model.addAttribute("read", service.get(email));
	}
	
	//�۾��� ȭ������ �̵��ϱ� ���� ����
	@GetMapping("register")
	public void register() {	
		log.info("register");
	}
	//�۾��� ȭ�鿡�� �۾��� ��ư�� Ŭ������ �� ����, ����, �ۼ��ڸ� ó���ϱ� ���� ����.
	@PostMapping("register")
	
	//����Ÿ�� �޼ҵ��             (Ÿ�� ������)
	//void add            (int a)
	public String registerPost(InfoVO password, RedirectAttributes rttr) {	
		log.info("register = " + password);
		service.register(password); //�۾��� �� ��
		rttr.addAttribute("password", service.get(password));
		return "redirect:/board/read"; //board/read.jspȭ���̵�.
	}
	//����ȭ������ �̵�(modify.jsp)�� ���� �ۼ�
	@GetMapping("modify")
	public void modifyGet(InfoVO password, Model model) {
		log.info("modify");
		model.addAttribute("modify", service.get(password));
	}
	// �ۼ��� ȭ�鿡�� �ۼ��� ��ư�� Ŭ������ �� ����, ������ ó���ϱ� ����.
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
