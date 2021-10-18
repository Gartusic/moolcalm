package com.moolcalm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.moolcalm.domain.InfoVO;


public interface MemberMapper {
	@Select("select * from moolcalm where bno > 0")

	public List<InfoVO> getList();

	public void insert(InfoVO email);

	public void insertSelectKey(InfoVO email);
	
	public InfoVO read(InfoVO email);

	public String delete(InfoVO email);

	public String update(InfoVO password);
}
