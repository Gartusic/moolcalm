package com.moolcalm.service;

import java.util.List;

import com.moolcalm.domain.InfoVO;

public interface MemberService {
	public void register(InfoVO password);

	public InfoVO get(InfoVO email);

	public String modify(InfoVO password);

	public String remove(InfoVO email);

	public List<InfoVO> getList();
}
