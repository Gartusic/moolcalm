package com.moolcalm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.moolcalm.domain.InfoVO;


public interface MemberMapper {

	//로그인 처리
	public InfoVO login(InfoVO member);
	
	//출석체크 시 포인트보상, 업데이트 처리
	public void dailycheck(String email);
//public void join(Map<String, Object>map,InfoVO vo);     //ȸ������ ����
    
    public void join(InfoVO vo);   
   
    public String find_passCheck(InfoVO vo);    //��й�ȣ ã��
 
    //public void authentication(InfoVO vo);        //�Ҽ� �α��� ȸ������ ���� �޼ҵ�
 
    public void pass_change(InfoVO vo);    //��й�ȣ ����
 
    public int email_check(String email);    //�̸��� �ߺ� Ȯ�� 
   
    public List<InfoVO> member_profile();    //ȸ���� ������ ������ Ȯ���� �� �ִ� �޼ҵ�

    public void info_delete(String email);  //ȸ��Ż��
    public void remove_fk();  //ȸ��Ż��
    public void reset_fk();  //ȸ��Ż��
}
