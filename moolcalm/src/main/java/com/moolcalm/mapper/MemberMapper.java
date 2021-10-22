package com.moolcalm.mapper;

import java.util.List;
import java.util.Map;

import com.moolcalm.domain.InfoVO;

public interface MemberMapper {

    public void join(Map<String, Object>map,InfoVO vo);     //ȸ������ ����
    
    public void insert(InfoVO vo);
    
    public boolean loginCheck(InfoVO vo);        //�α��� ����
    
    public void insertSelectKey(InfoVO vo); 
   
    public String find_passCheck(InfoVO vo);    //��й�ȣ ã��
 
    //public void authentication(InfoVO vo);        //�Ҽ� �α��� ȸ������ ���� �޼ҵ�
 
    public void pass_change(Map<String, Object> map, InfoVO vo)throws Exception;    //��й�ȣ ����
 
    public boolean email_check(String email) throws Exception;    //�̸��� �ߺ� Ȯ�� 
   
    public List<InfoVO> member_profile(String email) throws Exception;    //ȸ���� ������ ������ Ȯ���� �� �ִ� �޼ҵ�
}
