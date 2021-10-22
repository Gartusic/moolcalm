package com.moolcalm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.moolcalm.domain.InfoVO;

public interface MemberService {
		public void join (Map<String, Object>map,InfoVO vo); //회원가입 관련
	    
		public void login(InfoVO vo); //로그인 관련		
	    
	    public boolean loginCheck(InfoVO vo, HttpSession session);    //로그인 관련	       
	  
	    public String find_passCheck(InfoVO vo);    //비밀번호 찾기 관련
	    
	    public void pass_change(Map<String, Object> map, InfoVO vo)throws Exception;    //비밀번호 변경
	    
	    
	    public boolean email_check(String email) throws Exception;    //이메일 중복확인을 하는 메소드
	 
	    
	    public List<InfoVO> member_profile(String email) throws Exception;    //회원의 프로필을 볼 수 있는 메소드
	    
}