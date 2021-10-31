package com.moolcalm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.moolcalm.domain.CollectionVO;
import com.moolcalm.domain.ProductVO;
import com.moolcalm.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Repository //???
@AllArgsConstructor
public class ProductServceImpl implements ProductService{
	@Autowired
	private ProductMapper mapper;
	
	//구매하기	
	@Override
	public void buy(CollectionVO vo) {
		log.info("buy");
		System.out.println(vo.getEmail() + " : " + vo.getP_name());
		mapper.buy(vo);
	};
	
	// 구매중복 확인
	public int product_check(CollectionVO vo) {
		log.info("product_check");
		return mapper.product_check(vo);
	}
	
	@Override
	//모음집 상세페이지 생성
	public ProductVO read(String p_setname) {
		log.info("get"+p_setname);
		return mapper.read(p_setname);
	};
	
	@Override
	//모음집 목록 생성
	public List<ProductVO> getList(){
		log.info("getList");
		return mapper.getList();
	};
	//상세페이지의 상품 낱개 리스트 생성
	public List<ProductVO> readList(String p_setname){
		log.info("readList");
		return mapper.readList(p_setname);
	}
	@Override
	//상품 모음집 속 상품의 총 갯수
	public ProductVO readProductCount(String p_setname) {
		log.info("readProductCount");
		return mapper.readProductCount(p_setname);
	};

	
}
