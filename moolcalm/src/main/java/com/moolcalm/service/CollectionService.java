package com.moolcalm.service;

import java.util.List;

import com.moolcalm.domain.ProductVO;

public interface CollectionService {

	//구매목록 출력
	public List<ProductVO> getMyList(String email);
	//구매내역 상세페이지
	public List<ProductVO> c_detail(String p_name,String email);
}
