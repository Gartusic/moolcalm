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

	public void register(InfoVO email) {
		log.info("register...."+email);
		mapper.insertSelectKey(email);		
	}	

	public InfoVO get(InfoVO email) {
		log.info("getregister...."+email);
		return mapper.read(email);}

	public String modify(InfoVO password) {
		log.info("modify...."+password);
		return mapper.update(password);}

	public String remove(InfoVO email) {
		log.info("remove...."+email);		
		return mapper.delete(email);}

	public List<InfoVO> getList() {
		log.info("getregister....");
		return mapper.getList();
		}
}
