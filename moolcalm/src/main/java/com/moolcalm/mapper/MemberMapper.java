package com.moolcalm.mapper;

import java.util.List;
import java.util.Map;

import com.moolcalm.domain.InfoVO;

public interface MemberMapper {

    public void join(Map<String, Object>map,InfoVO vo);     //회원가입 관련
    
    public void insert(InfoVO vo);
    
    public boolean loginCheck(InfoVO vo);        //로그인 관련
    
    public void insertSelectKey(InfoVO vo); 
   
    public String find_passCheck(InfoVO vo);    //비밀번호 찾기
 
    //public void authentication(InfoVO vo);        //소셜 로그인 회원인증 관련 메소드
 
    public void pass_change(Map<String, Object> map, InfoVO vo)throws Exception;    //비밀번호 변경
 
    public boolean email_check(String email) throws Exception;    //이메일 중복 확인 
   
    public List<InfoVO> member_profile(String email) throws Exception;    //회원의 프로필 정보를 확인할 수 있는 메소드
}
