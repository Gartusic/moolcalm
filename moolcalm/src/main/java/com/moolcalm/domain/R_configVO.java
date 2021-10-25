package com.moolcalm.domain;

import java.util.Date;

import lombok.Data;

@Data
public class R_configVO {
	private int r_num;
	private String email;
	private Date r_date;
	private String r_content;
}