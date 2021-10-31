package com.moolcalm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moolcalm.domain.InfoVO;
import com.moolcalm.service.CollectionService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class CollectonController {
	@Autowired
	CollectionService service;
	
	//내 보관함 보기
	@GetMapping("myCollection")
	public void readCollection(String email, HttpServletRequest Request) {
		HttpSession session = Request.getSession();
		email = ((InfoVO) session.getAttribute("ssn")).getEmail();
		service.getMyList(email);
		log.info("getMyList + email: "+email);
	}
}
