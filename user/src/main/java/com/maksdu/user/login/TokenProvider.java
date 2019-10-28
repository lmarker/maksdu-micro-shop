package com.maksdu.user.login;

public interface TokenProvider {

	String tokenBuilder(String proxyParam);
	
}
