package com.moolcalm.service;

import java.util.List;

import com.moolcalm.domain.Criteria;
import com.moolcalm.domain.R_configVO;

public interface BoardService {
	
	public void register(R_configVO r_config);

	public R_configVO get(long r_num);

	public boolean modify(R_configVO r_config);

	public boolean remove(long r_num);

	//public List<R_configVO> getList();
	
	public List<R_configVO> getList(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
