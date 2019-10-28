package com.maksdu.user.login;

import com.maksdu.user.domain.User;

public abstract class AbstractLoginFactoryAware {

	protected SubjectFactory subjectFactory;
	
	/**
	 * 登录容器体
	 */
	protected SubjectContainer subjectContainer;
	
	public void setSubjectFactory(SubjectFactory subjectFactory) {
		this.subjectFactory = subjectFactory;
	}
	
	public Subject getSubjectLogin(String username, String password) {
		return subjectFactory.instance(username, password);
	}
	
	public Subject getSubjectLogin(User user) {
		return subjectFactory.instance(user);
	}
	
	public Subject getSubjectLogin(String token) {
		return subjectFactory.instance(token);
	}
}
