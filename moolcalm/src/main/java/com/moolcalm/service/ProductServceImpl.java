package com.moolcalm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
	
	//�����ϱ�	
	@Override
	public void buy(ProductVO product) {
		log.info("buy");
		mapper.buy(product);
	};
	
	@Override
	//��ǰ ��ϸ���Ʈ
	public ProductVO get(String p_setname) {
		log.info("get"+p_setname);
		return mapper.read(p_setname);
	};
	
	@Override
	//��ǰ ��ϸ���Ʈ
	public List<ProductVO> getList(){
		log.info("getList");
		return mapper.getList();
	};
	
	
}
