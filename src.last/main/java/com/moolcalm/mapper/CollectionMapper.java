package com.moolcalm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moolcalm.domain.ProductVO;

public interface CollectionMapper {
	public List<ProductVO> getMyList(String email);
}
