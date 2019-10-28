package com.maksdu.user.login;

import com.maksdu.user.domain.User;

/**
 * 登录接口对象
 * @author lijia
 *
 */
public interface Subject {

	int ONLOGIN = 0;
	int CHECKLOGIN = 1;
	int CHECKAUTH = 2;
	
	int ERROR_DIVID = 5;
	
	int TIMEOUT = 7;
	int UNLOGIN = 8;
	int UNAUTH = 9;
	int OFFLOGIN = 10;
	
	/**
	 * 获取登录状态
	 * @return
	 */
	int getSubjectStatus();
	
	/**
	 * 装载用户实体进行登录
	 * @param user
	 * @return
	 */
	Subject loader(User user);
	
	/**
	 * 设置过期时间
	 * @param user
	 * @param timeUnit
	 * @return
	 */
	Subject loader(User user, long timeUnit);
	
	/**
	 * 改变用户状态
	 * @param status
	 * @return
	 */
	Subject changeStatus(int status);
	
	/**
	 * 登陆是否超时
	 * @return
	 */
	boolean isTimeOut();
	
	/**
	 * 返回登陆密钥
	 * @return
	 */
	String getSubjectToken(String proxyParam);
	
	/**
	 * 返回登陆实体
	 * @return
	 */
	User getCurrentUser();
}
