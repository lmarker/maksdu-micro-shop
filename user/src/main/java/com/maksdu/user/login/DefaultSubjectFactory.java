package com.maksdu.user.login;

import com.maksdu.user.domain.User;

public class DefaultSubjectFactory implements SubjectFactory {

	private SubjectContainer container;
	
	@Override
	public Subject instance(String username, String password) {
		return null;
	}

	@Override
	public Subject instance(User user) {
		return null;
	}

	@Override
	public Subject instance(String token) {
		return container.pull(token);
	}

	@Override
	public void setSubjectContainer(SubjectContainer container) {
		this.container = container;
	}
	

}
