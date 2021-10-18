package com.moolcalm.service;

import java.util.List;

import com.moolcalm.domain.ProductVO;

public interface ProductService {
		//구매하기
		public void buy(ProductVO product);
		//상품 목록리스트(상세페이지)
		public ProductVO get(String p_setname);
		//상품 목록리스트(목록페이지)
		public List<ProductVO> getList();
		
		//조인
}
