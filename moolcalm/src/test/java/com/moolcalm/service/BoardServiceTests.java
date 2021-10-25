package com.moolcalm.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	@Test
	public void tstRegister() {
		R_configVO board=new R_configVO();
		board.setEmail("1111");
		board.setR_content("새로 작성하는 내용");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : "+board.getR_num());
	}
	@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
	}
	@Test
	public void testGet() {
		log.info(service.get(2L));
	}
	@Test
	public void testUpdate() {
		R_configVO board=new R_configVO();
		board.setEmail("1111");
		board.setR_content("새로 수정하는 내용");
		
		log.info("MODIFY RESULT : "+service.modify(board));
	}
	@Test
	public void testDelete() {
		//log.info("REMOVE RESULT : "+service.remove(2L));
	}
}
