package com.moolcalm.domain;

import lombok.Data;

@Data
public class ProductVO {
	private String p_name;
	private String p_setname;
	private String p_author;
	private String p_type;
	private int p_price;
	private String p_path;
	private String p_info;
	private int count;
	private int sum;
	private int price;
}
