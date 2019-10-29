package com.maksdu.user.login.subject;

import com.maksdu.user.domain.User;
import com.maksdu.user.login.Subject;

public class UnLoginSubject extends AppSubject {

	@Override
	public int getSubjectStatus() {
		return 0;
	}

	@Override
	public Subject loader(User user) {
		return null;
	}

	@Override
	public Subject loader(User user, long timeUnit) {
		return null;
	}

	@Override
	public Subject changeStatus(int status) {
		return null;
	}

	@Override
	public boolean isTimeOut() {
		return false;
	}

	@Override
	public String getSubjectToken(String proxyParam) {
		return null;
	}

	@Override
	public User getCurrentUser() {
		return null;
	}

}
