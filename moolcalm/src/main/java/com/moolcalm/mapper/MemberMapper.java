package com.moolcalm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.moolcalm.domain.InfoVO;


public interface MemberMapper {

	//�α��� ó��
	public InfoVO login(InfoVO member);
}
