package com.maksdu.user.login;

import com.maksdu.user.domain.User;

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
	private User user;
	
	@Override
	public int getSubjectStatus() {
		return status;
	}

	@Override
	public Subject loader(User user) {
		this.user = user;
		this.startTime = System.currentTimeMillis();
		this.timeOut = Integer.MAX_VALUE;
		return this;
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
	public Subject loader(User user, long timeUnit) {
		this.user = user;
		this.startTime = System.currentTimeMillis();
		this.timeOut = timeUnit;
		return this;
	}

	@Override
	public String getSubjectToken(String proxyParam) {
		return provider.tokenBuilder(proxyParam);
	}

	@Override
	public User getCurrentUser() {
		if(this.status > ERROR_DIVID) {
			return null;
		}
		return this.user;
	}
	
}
