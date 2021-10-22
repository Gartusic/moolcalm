package com.moolcalm.domain;

import java.util.Date;

import lombok.Data;
@Data
public class InfoVO {
	private String email;
	private String password;
	private Date join_date;
	private Date now_date;
	private Date login_date;
	private int login_count;
	private int point;
}