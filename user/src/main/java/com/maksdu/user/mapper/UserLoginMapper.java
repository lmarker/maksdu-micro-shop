package com.maksdu.user.mapper;

import org.springframework.stereotype.Repository;

import com.maksdu.user.domain.UserLogin;

@Repository
public interface UserLoginMapper {

	UserLogin loginCheck(String identity, String token);
	
}
