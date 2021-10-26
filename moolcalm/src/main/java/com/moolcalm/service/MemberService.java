package com.moolcalm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.moolcalm.domain.InfoVO;

public interface MemberService {
		public void join (InfoVO vo); //회원가입 관련
    
	    public String find_passCheck(InfoVO vo);    //비밀번호 찾기 관련
	    
	    public void pass_change(InfoVO vo);    //비밀번호 변경
	    	    
	    public int email_check(String email);    //이메일 중복확인을 하는 메소드
	     
	    public List<InfoVO> member_profile(String email);    //회원의 프로필을 볼 수 있는 메소드
	    
}