 package com.moolcalm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	public void join(InfoVO vo) {	
		mapper.join(vo);
	}

	public String find_passCheck(InfoVO vo) {
		
		return mapper.find_passCheck(vo); 
	}

	@Override
	public String pass_change(InfoVO vo)  {
		return mapper.pass_change(vo);	
		
	}

	public boolean email_check(InfoVO vo, HttpSession session) {
        boolean check = mapper.email_check(vo);
        if(check) {    //����
            session.setAttribute("email", vo.getPassword());            
           log.info(session.getAttribute("email"));
        }
        
        return check;
	}

	@Override
	public List<InfoVO> member_profile(String email){
		return mapper.member_profile();
	}



	
}
