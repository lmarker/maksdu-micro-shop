package com.maksdu.user.login;

import com.maksdu.user.mapper.UserLoginMapper;

public class LoginFactory extends AbstractLoginFactoryAware {

	private UserLoginMapper mapper;

	public LoginFactory(UserLoginMapper mapper) {
		this.mapper = mapper;
	}
	
}
