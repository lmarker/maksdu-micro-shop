package com.maksdu.user.login.subject;

import com.maksdu.user.domain.User;
import com.maksdu.user.domain.UserLogin;
import com.maksdu.user.login.Subject;
import com.maksdu.user.login.TokenProvider;

import lombok.Setter;

public class AppSubject implements Subject {

	private int status;
	private long startTime;
	private long timeOut;
	
	@Setter
	private TokenProvider provider;
	
	/**
	 * 增强对象
	 */
	private UserLogin user;
	
	@Override
	public int getSubjectStatus() {
		return status;
	}

	@Override
	public Subject loader(UserLogin user) {
		return loader(user, Integer.MAX_VALUE);
	}

	@Override
	public Subject changeStatus(int status) {
		this.status = status;
		return this;
	}

	@Override
	public boolean isTimeOut() {
		if(status == TIMEOUT) {
			return true;
		}
		if(this.timeOut < System.currentTimeMillis() - this.startTime) {
			this.status = TIMEOUT;
		}
		return this.status == TIMEOUT;
	}

	@Override
	public Subject loader(UserLogin user, long timeUnit) {
		this.user = user;
		this.startTime = System.currentTimeMillis();
		this.timeOut = timeUnit;
		this.user.setLoginToken(getSubjectToken());
		return this;
	}

	@Override
	public String getSubjectToken() {
		return provider.tokenBuilder();
	}

	@Override
	public User getCurrentUser() {
		if(this.status > ERROR_DIVID) {
			return null;
		}
		return this.user.getUserEntity();
	}
	
}
