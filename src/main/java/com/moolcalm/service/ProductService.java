package com.moolcalm.service;

import java.util.List;

import com.moolcalm.domain.CollectionVO;
import com.moolcalm.domain.ProductVO;

public interface ProductService {
		//구매하기
		public void buy(CollectionVO vo);
		
		//상품구매 중복확인
		public int product_check(CollectionVO vo);
		
		//상품 목록리스트(상세페이지)
		public ProductVO read(String p_setname);
		//상품 목록리스트(목록페이지)
		public List<ProductVO> getList();
		//상품 낱개 리스트(상세페이지)
		public List<ProductVO> readList(String p_setname);
		//상품 모음집 속 상품의 총 갯수,총가격,낱개가격
		public ProductVO readProductCount(String p_setname);
}
