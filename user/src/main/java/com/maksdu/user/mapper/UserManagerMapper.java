package com.maksdu.user.mapper;

import org.springframework.stereotype.Repository;

import com.maksdu.user.domain.User;

@Repository
public interface UserManagerMapper {

	User findByIdentity(String identity);
	
	int createUser(User user);
	
	int updateUser(User user);
	
	
	
}
