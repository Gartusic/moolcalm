package com.moolcalm.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.moolcalm.domain.ProductVO;
import com.moolcalm.mapper.CollectionMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Repository //???
@AllArgsConstructor
public class CollectionServiceImpl implements CollectionService{
	private CollectionMapper mapper;
	
	@Override
	public List<ProductVO> getMyList(String email){
		log.info("getMyList");
		return mapper.getMyList(email);
	};
}
