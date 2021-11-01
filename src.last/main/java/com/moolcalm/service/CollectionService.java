package com.moolcalm.service;

import java.util.List;

import com.moolcalm.domain.ProductVO;

public interface CollectionService {

	public List<ProductVO> getMyList(String email);
}
