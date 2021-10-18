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
		//                  배열이름, select된 결과물
		model.addAttribute("list", service.getList());
		//return "list";
	}
		
	//글쓰기 화면으로 이동하기 위해 만듦
	@GetMapping("t_write")
	public void register() {	
		log.info("register");
	}
	//글쓰기 화면에서 글쓰기 버튼을 클릭했을 때 제목, 내용, 작성자를 처리하기 위해 존재.
	@PostMapping("register")
	
	//리턴타입 메소드명             (타입 변수명)
	//void add            (int a)
	public String registerPost(R_configVO R_config, RedirectAttributes rttr) {	
		log.info("register = " + R_config);
		service.register(R_config); //글쓰기 한 후
		rttr.addAttribute("r_num", R_config.getR_num());
		return "redirect:/board/t_table"; //board/read.jsp화면이동.
	}
	//수정화면으로 이동(modify.jsp)을 위해 작성
	@GetMapping("t_writemodify")
	public void modifyGet(long r_num, Model model) {
		log.info("modify");
		model.addAttribute("modify", service.get(r_num));
	}
	// 글수정 화면에서 글수정 버튼을 클릭했을 때 제목, 내용을 처리하기 위해.
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
