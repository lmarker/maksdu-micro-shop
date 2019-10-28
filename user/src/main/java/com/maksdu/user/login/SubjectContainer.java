package com.maksdu.user.login;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SubjectContainer {

	private static ConcurrentMap<String, Subject> TokenSubjectMap = new ConcurrentHashMap<>();
	private static final int REJECT = 0;
	
	public static Subject registry(String token, Subject subject) {
		Subject isLogin = TokenSubjectMap.getOrDefault(token, null);
		if(isLogin!=null && !isLogin.isTimeOut()) {
			return isLogin;
		} 
		TokenSubjectMap.put(token, subject);
		return subject;
	} 
}
