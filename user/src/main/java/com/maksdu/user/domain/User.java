package com.maksdu.user.domain;

import lombok.Data;

@Data
public class User {

	private String Identity;
	
	private String nickName;
	
	private String avator;
	
	private Integer sex;
	
	private String description;
	
	private String metaJson;
	
}
