package com.moolcalm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moolcalm.domain.InfoVO;
import com.moolcalm.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	private MemberMapper mapper;

	@Override
	public InfoVO login(InfoVO member) {
		log.info("login........"+member);
		return mapper.login(member);
	};
}
