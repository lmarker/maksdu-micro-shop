package com.maksdu.user.domain;

import lombok.Data;

/**
 *  -- CREATE TABLE `user_mc` (
	-- 	identity VARCHAR(20) not null primary key,
	-- 	nickName VARCHAR(40) not null,
	-- 	avator VARCHAR(200),
	-- 	sex int(1) not null default 0,
	-- 	description VARCHAR(200),
	-- 	metaJson VARCHAR(500)
	-- )ENGINE=INNODB DEFAULT CHARSET=utf8;
	
	CREATE TABLE `user_login_mc` (
		identity VARCHAR(20) not null,
		loginMethod VARCHAR(4) not null,
		loginToken VARCHAR(20) not null
	)ENGINE=INNODB DEFAULT CHARSET=utf8;
	
	-- alter table `user_mc` add index nickIndex(`nickName`);
 * @author lijia
 *
 */
@Data
public class User {

	private String Identity;
	
	private String nickName;
	
	private String avatar;
	
	private Integer sex;
	
	private String description;
	
	private String metaJson;
	
}
