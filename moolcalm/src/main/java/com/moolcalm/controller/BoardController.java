package com.moolcalm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.moolcalm.domain.R_configVO;
import com.moolcalm.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private BoardService service;

	@GetMapping("t_table")
	public void list(Model model) {
		log.info("list");
		//                  �迭�̸�, select�� �����
		model.addAttribute("list", service.getList());
		//return "list";
	}
		
	//�۾��� ȭ������ �̵��ϱ� ���� ����
	@GetMapping("t_write")
	public void register() {	
		log.info("register");
	}
	//�۾��� ȭ�鿡�� �۾��� ��ư�� Ŭ������ �� ����, ����, �ۼ��ڸ� ó���ϱ� ���� ����.
	@PostMapping("register")
	
	//����Ÿ�� �޼ҵ��             (Ÿ�� ������)
	//void add            (int a)
	public String registerPost(R_configVO R_config, RedirectAttributes rttr) {	
		log.info("register = " + R_config);
		service.register(R_config); //�۾��� �� ��
		rttr.addAttribute("r_num", R_config.getR_num());
		return "redirect:/board/t_table"; //board/read.jspȭ���̵�.
	}
	//����ȭ������ �̵�(modify.jsp)�� ���� �ۼ�
	@GetMapping("t_writemodify")
	public void modifyGet(long r_num, Model model) {
		log.info("modify");
		model.addAttribute("modify", service.get(r_num));
	}
	// �ۼ��� ȭ�鿡�� �ۼ��� ��ư�� Ŭ������ �� ����, ������ ó���ϱ� ����.
	@PostMapping("modify")
	public String modifyPost(R_configVO R_config, RedirectAttributes rttr, Model model) {
		log.info("modifyPost"+R_config);
		model.addAttribute("result", service.modify(R_config));
		rttr.addAttribute("r_num", R_config.getR_num());
		return "redirect:/board/t_writemodify";
	}
	@GetMapping("remove")
	public String remove(long r_num) {
		log.info("remove"+r_num);
		service.remove(r_num);
		return "redirect:/board/t_write";
		}
}
