package com.moolcalm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moolcalm.domain.InfoVO;
import com.moolcalm.domain.ProductVO;
import com.moolcalm.service.CollectionService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/collections")
@AllArgsConstructor
public class CollectonController {
	@Autowired
	CollectionService service;
	
	//내 보관함 보기
	@GetMapping("myCollection")
	public void getMyList(String email, HttpServletRequest Request, Model model) {
		HttpSession session = Request.getSession();
		email = ((InfoVO) session.getAttribute("ssn")).getEmail();
		model.addAttribute("list", service.getMyList(email));
		log.info("getMyList + email: "+email);
		
	}
	@GetMapping("c_detail")
	public void c_detail(Model model, HttpServletRequest Request, String p_name) {
		HttpSession session = Request.getSession();
		String email = ((InfoVO) session.getAttribute("ssn")).getEmail();
		/*model.addAttribute("c_detail",service.c_detail(p_name,email));*/
		List<ProductVO> test = service.c_detail(p_name,email); //타입 오류를 이런식으로 고쳤음..
		model.addAttribute("c_detail",test);
	}
}
