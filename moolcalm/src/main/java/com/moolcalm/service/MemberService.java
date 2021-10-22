package com.moolcalm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.moolcalm.domain.InfoVO;

public interface MemberService {
		public void join (Map<String, Object>map,InfoVO vo); //ȸ������ ����
	    
		public void login(InfoVO vo); //�α��� ����		
	    
	    public boolean loginCheck(InfoVO vo, HttpSession session);    //�α��� ����	       
	  
	    public String find_passCheck(InfoVO vo);    //��й�ȣ ã�� ����
	    
	    public void pass_change(Map<String, Object> map, InfoVO vo)throws Exception;    //��й�ȣ ����
	    
	    
	    public boolean email_check(String email) throws Exception;    //�̸��� �ߺ�Ȯ���� �ϴ� �޼ҵ�
	 
	    
	    public List<InfoVO> member_profile(String email) throws Exception;    //ȸ���� �������� �� �� �ִ� �޼ҵ�
	    
}