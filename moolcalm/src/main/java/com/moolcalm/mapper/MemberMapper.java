package com.moolcalm.mapper;

import java.util.List;

import com.moolcalm.domain.InfoVO;

public interface MemberMapper {

    //public void join(Map<String, Object>map,InfoVO vo);     //ȸ������ ����
    
    public void join(InfoVO vo);   
   
    public String find_passCheck(InfoVO vo);    //��й�ȣ ã��
 
    //public void authentication(InfoVO vo);        //�Ҽ� �α��� ȸ������ ���� �޼ҵ�
 
    public void pass_change(InfoVO vo);    //��й�ȣ ����
 
    public int email_check(String email);    //�̸��� �ߺ� Ȯ�� 
   
    public List<InfoVO> member_profile();    //ȸ���� ������ ������ Ȯ���� �� �ִ� �޼ҵ�
}