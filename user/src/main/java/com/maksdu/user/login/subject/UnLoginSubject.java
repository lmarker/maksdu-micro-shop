package com.maksdu.user.login.subject;

import com.maksdu.user.domain.User;
import com.maksdu.user.domain.UserLogin;
import com.maksdu.user.login.Subject;

public final class UnLoginSubject extends AppSubject {

	@Override
	public int getSubjectStatus() {
		return 0;
	}

	@Override
	public Subject loader(UserLogin user) {
		return null;
	}

	@Override
	public Subject loader(UserLogin user, long timeUnit) {
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
	public String getSubjectToken() {
		return null;
	}

	@Override
	public User getCurrentUser() {
		return null;
	}

}
