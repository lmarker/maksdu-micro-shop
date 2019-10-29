package com.maksdu.user.login.builder;

import com.maksdu.user.domain.User;
import com.maksdu.user.domain.UserLogin;

public class UserBuilder {

	/**
	 * 进行实体绑定时，要确保实体不为空
	 * @param login
	 * @param user
	 * @return
	 * @throws Throwable
	 */
	public static UserLogin loginBuilder(UserLogin login, User user) throws Throwable {
		if(login == null)
			throw new Throwable();
		if(user == null)
			throw new Throwable();
		login.setUserEntity(user);
		return login;
	}
	
}
