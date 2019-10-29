package com.maksdu.user.domain;

import lombok.Data;

@Data
public class UserLogin {

	private String identity;
	
	private String loginMethod;
	
	private String loginToken;
	
	/**
	 * 用户实体
	 */
	private User userEntity;
	
}
