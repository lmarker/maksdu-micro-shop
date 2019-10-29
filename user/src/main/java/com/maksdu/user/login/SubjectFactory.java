package com.maksdu.user.login;

import com.maksdu.user.domain.User;
import com.maksdu.user.mapper.UserLoginMapper;

public interface SubjectFactory {

	void setSubjectContainer(SubjectContainer container);
	
	/**
	 * 根据用户名密码，获取登录实体
	 * @return
	 */
	Subject instance(String username, String password);
	
	/**
	 * 根据用户对象获取登录实体
	 * @param user
	 * @return
	 */
	Subject instance(User user);
	
	/**
	 * 根据token获取登录实体
	 * @param token
	 * @return
	 */
	Subject instance(String token);
}
