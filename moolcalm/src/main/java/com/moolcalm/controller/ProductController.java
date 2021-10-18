package com.moolcalm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moolcalm.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller 
@RequestMapping("/products") 
@AllArgsConstructor
public class ProductController {

	@Autowired ProductService service;
	//전체 목록 띄우기
	//GET Mapping을 사용하면 된당
	// URL : http://localhost:8080/board/list 를 실행하면 아래 내용이 표출
	@RequestMapping(value= "p_list", method = RequestMethod.GET)
	public void list(Model model) {
		log.info("list");
						 // "배열명",	select된 결과물
		model.addAttribute("list",service.getList());
	}
	@GetMapping("/p_detail")
	public void read(String p_setname, Model model) {
		log.info("read"+p_setname);
		model.addAttribute("read", service.get(p_setname));
	}
}
