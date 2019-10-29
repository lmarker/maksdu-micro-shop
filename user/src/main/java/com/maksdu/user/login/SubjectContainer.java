package com.maksdu.user.login;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.maksdu.user.domain.UserLogin;
import com.maksdu.user.login.subject.AppSubject;
import com.maksdu.user.login.subject.UnLoginSubject;
import com.maksdu.user.mapper.UserLoginMapper;

import lombok.Getter;
import lombok.Setter;

public class SubjectContainer {

	private ConcurrentMap<String, Subject> TokenSubjectMap = new ConcurrentHashMap<>();
	@Setter
	@Getter
	private UserLoginMapper loginMapper;
	
	public Subject registry(String token, Subject subject) {
		Subject isLogin = TokenSubjectMap.getOrDefault(token, null);
		if(isLogin!=null && !isLogin.isTimeOut()) {
			return isLogin;
		} 
		TokenSubjectMap.put(token, subject);
		return subject;
	} 
	
	/**
	 * @param identity
	 * @param token
	 * @return
	 */
	public Subject passwordCheck(String identity, String token) {
		UserLogin user = loginMapper.loginCheck(identity, token);
		if(user == null ) {
			return new UnLoginSubject();
		}
		Subject newSubject = new AppSubject().loader(user);
		return newSubject;
	}
	
	public Subject pull(String token) {
		return TokenSubjectMap.getOrDefault(token, null);
	}
}
