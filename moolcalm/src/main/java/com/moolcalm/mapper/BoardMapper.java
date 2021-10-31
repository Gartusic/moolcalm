package com.moolcalm.mapper;

import java.util.List;

import com.moolcalm.domain.Criteria;

//import org.apache.ibatis.annotations.Select;

import com.moolcalm.domain.R_configVO;

public interface BoardMapper {

		//@Select("select * from moolcalm where r_num > 0")

		public List<R_configVO> getList();
		
		public List<R_configVO> getListWithPaging(Criteria cri);
		
		public int getTotalCount(Criteria cri);

		public void insert(R_configVO r_config);

		public void insertSelectKey(R_configVO r_config);
		
		public R_configVO read(long r_num);

		public int delete(long r_num);

		public int update(R_configVO r_config);
	
}
