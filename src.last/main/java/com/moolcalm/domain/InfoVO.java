package com.moolcalm.domain;

import java.util.Date;


import lombok.Data;
@Data
public class InfoVO {
	private String email;
	private String password;
	
	//20211027추가 - yuj
	private String password_again;
	//20211027추가 end
	
	private Date join_date;
	private Date now_date;
	private Date login_date;
	private int login_count;
	private int point;
}
