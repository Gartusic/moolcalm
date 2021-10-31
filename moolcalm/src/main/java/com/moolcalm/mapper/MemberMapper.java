package com.moolcalm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.moolcalm.domain.InfoVO;


public interface MemberMapper {

	//로그인 처리
	public InfoVO login(InfoVO member);
	
	//출석체크 시 포인트보상, 업데이트 처리
	public void dailycheck(String email);
//public void join(Map<String, Object>map,InfoVO vo);     //회원가입 관련
    
    public void join(InfoVO vo);   
   
    public String find_passCheck(InfoVO vo);    //비밀번호 찾기
 
    //public void authentication(InfoVO vo);        //소셜 로그인 회원인증 관련 메소드
 
    public void pass_change(InfoVO vo);    //비밀번호 변경
 
    public int email_check(String email);    //이메일 중복 확인 
   
    public List<InfoVO> member_profile();    //회원의 프로필 정보를 확인할 수 있는 메소드

    public void info_delete_r(String email);
    public void info_delete_c(String email);
    public void info_delete(String email);  //회원탈퇴
}
