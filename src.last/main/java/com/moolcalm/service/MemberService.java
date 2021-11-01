package com.moolcalm.service;

import java.util.List;

import com.moolcalm.domain.InfoVO;

public interface MemberService {
	//로그인
	public InfoVO login(InfoVO member);
	
	//출석체크 시 포인트보상, 업데이트 처리
	public void dailycheck(String email);
	
	public void join (InfoVO vo); //ȸ������ ����
    
    public String find_passCheck(InfoVO vo);    //��й�ȣ ã�� ����
    
    public void pass_change(InfoVO vo);    //��й�ȣ ����
    	    
    public int email_check(String email);    //�̸��� �ߺ�Ȯ���� �ϴ� �޼ҵ�
     
    public List<InfoVO> member_profile(String email);    //ȸ���� �������� �� �� �ִ� �޼ҵ�

    public void info_delete(String email);  //ȸ��Ż��
}
