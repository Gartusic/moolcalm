package com.moolcalm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.moolcalm.domain.InfoVO;

public interface MemberService {
		public void join (InfoVO vo); //ȸ������ ����
    
	    public String find_passCheck(InfoVO vo);    //��й�ȣ ã�� ����
	    
	    public void pass_change(InfoVO vo);    //��й�ȣ ����
	    	    
	    public boolean email_check(InfoVO vo, HttpSession session);    //�̸��� �ߺ�Ȯ���� �ϴ� �޼ҵ�
	     
	    public List<InfoVO> member_profile(String email);    //ȸ���� �������� �� �� �ִ� �޼ҵ�
	    
}