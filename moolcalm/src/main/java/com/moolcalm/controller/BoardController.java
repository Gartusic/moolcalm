package com.moolcalm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.moolcalm.domain.Criteria;
import com.moolcalm.domain.PageDTO;
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
	public void list(Model model, Criteria cri) {
		log.info("list");
		//                  �迭�̸�, select�� �����
		model.addAttribute("list", service.getList(cri));
		int total=service.getTotalCount(cri);
		model.addAttribute("PageMaker", new PageDTO(cri,total));
	}
		
	//�۾��� ȭ������ �̵��ϱ� ���� ����
	@GetMapping("t_write")
	public void register() {	
		log.info("register");
	}
	//�۾��� ȭ�鿡�� �۾��� ��ư�� Ŭ������ �� ����, ����, �ۼ��ڸ� ó���ϱ� ���� ����.
	@PostMapping("t_write")
	
	//����Ÿ�� �޼ҵ��             (Ÿ�� ������)
	//void add            (int a)
	public String registerPost(R_configVO R_config, RedirectAttributes rttr, HttpServletResponse response) throws IOException {	
		log.info("register = " + R_config);
		service.register(R_config); //�۾��� �� ��
		rttr.addAttribute("r_num", R_config.getR_num());
		
		response.setContentType("text/html; charset=UTF-8");
    	PrintWriter board_register = response.getWriter();
    	board_register.println("<script>alert('관리자에게 의견이 전달되었습니다. ')</script>");	        	
    	board_register.flush();		
		
		return "member/member_info"; //board/read.jspȭ���̵�.
	}
	//����ȭ������ �̵�(modify.jsp)�� ���� �ۼ�
	@GetMapping("modify")
	public void modifyGet(long r_num, Model model) {
		log.info("modify");
		model.addAttribute("modify", service.get(r_num));
	}
	// �ۼ��� ȭ�鿡�� �ۼ��� ��ư�� Ŭ������ �� ����, ������ ó���ϱ� ����.
	@PostMapping("modify")
	public String modifyPost(R_configVO R_config, RedirectAttributes rttr, HttpServletResponse response) throws IOException {		
		service.modify(R_config);	
		rttr.addAttribute("r_num", R_config.getR_num());
		
		
		log.info("modifyPost"+R_config);
		
		response.setContentType("text/html; charset=UTF-8");
    	PrintWriter board_register = response.getWriter();
    	board_register.println("<script>alert('글이 수정되었습니다. ')</script>");
    	board_register.flush();	
		
		return "member/member_info";
	}
	@GetMapping("remove")	
	public String remove(long r_num) {
		log.info("remove"+r_num);
		service.remove(r_num);
		return "redirect:/board/t_table";
		}
}
