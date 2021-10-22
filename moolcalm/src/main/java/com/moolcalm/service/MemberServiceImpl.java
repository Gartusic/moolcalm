package com.moolcalm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.moolcalm.domain.InfoVO;
import com.moolcalm.mapper.MemberMapper;

import lombok.AllArgsConstructor;
 
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	private MemberMapper mapper;

	public void join(Map<String, Object>map,InfoVO vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void login(InfoVO vo) {
		mapper.insertSelectKey(vo);		
	}

	@Override
	public boolean loginCheck(InfoVO vo, HttpSession session) {
        boolean check = mapper.loginCheck(vo);
        if(check) {    //로그인 성공
            session.setAttribute("password", vo.getPassword());            
            System.out.println(session.getAttribute("password"));
        }
        
        return check;
	}

	public String find_passCheck(InfoVO vo) {
		String password=mapper.find_passCheck(vo);
		return password;
	}

	@Override
	public void pass_change(Map<String, Object> map, InfoVO vo) throws Exception {
		mapper.pass_change(map, vo);
		
	}

	@Override
	public boolean email_check(String email) throws Exception {
        boolean check = mapper.email_check(email);
        
        return check;
	}

	@Override
	public List<InfoVO> member_profile(String email) throws Exception {
		return mapper.member_profile(email);
	}



	
}
