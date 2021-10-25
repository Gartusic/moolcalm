package com.moolcalm.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moolcalm.domain.R_configVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board));
	}
	@Test
	public void testInsert() {
		R_configVO board=new R_configVO();
		board.setEmail("1111");
		board.setR_content("새로 작성하는 내용");
		
		mapper.insert(board);
		
		log.info(board);
	}
	@Test
	public void testInsertSelectKey() {
		R_configVO board=new R_configVO();
		board.setEmail("1111");
		board.setR_content("새로 작성하는 내용");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	@Test
	public void testRead() {
		R_configVO board=mapper.read(5L);
		
		log.info(board);
	}
	@Test
	public void testDelete() {
		log.info("DELETE COUNT : "+mapper.delete(3L));
	}
	@Test
	public void testUpdate() {
		R_configVO board=new R_configVO();
		board.setEmail("1111");
		board.setR_content("새로 수정하는 내용");
		
		int count=mapper.update(board);
		log.info("UPDATE COUNT : "+count);
	}
}
