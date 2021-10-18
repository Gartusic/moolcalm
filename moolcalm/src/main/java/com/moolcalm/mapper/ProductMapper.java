package com.moolcalm.mapper;

import java.util.List;

import com.moolcalm.domain.ProductVO;

public interface ProductMapper {
	public List<ProductVO> getList();
	public void buy(ProductVO product);
	public ProductVO read(String p_setname);
	
}
