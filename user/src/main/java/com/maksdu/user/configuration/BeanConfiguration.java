package com.maksdu.user.configuration;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maksdu.user.login.DefaultSubjectFactory;
import com.maksdu.user.login.LoginFactory;
import com.maksdu.user.mapper.UserLoginMapper;

@Configuration
public class BeanConfiguration {

	@Resource UserLoginMapper mapper;
	
	@Bean
	public LoginFactory getLoginFactory(UserLoginMapper mapper) {
		LoginFactory factory = new LoginFactory(mapper);
		factory.setSubjectFactory(new DefaultSubjectFactory());
		return factory;
	}
	
}
