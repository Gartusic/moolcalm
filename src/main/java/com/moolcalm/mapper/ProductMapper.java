package com.moolcalm.mapper;

import java.util.List;

import com.moolcalm.domain.CollectionVO;
import com.moolcalm.domain.ProductVO;

public interface ProductMapper {
	public List<ProductVO> getList();
	//public void buy(InfoVO email, ProductVO p_name);
	
	void buy(CollectionVO vo); // 파라미터가 만약 여러개 일경우 타입을 지정하고 한개만 파라미터로 넣어보자
	// 아 참 그리고 interface는  public 안써도 기본이 public 입니당
	
	public int product_check(CollectionVO vo);    //상품구매 중복 확인 
	
	public ProductVO read(String p_setname);
	public List<ProductVO> readList(String p_setname);
	public ProductVO readProductCount(String p_setname);
}
