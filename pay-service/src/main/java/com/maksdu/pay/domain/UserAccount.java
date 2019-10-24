package com.maksdu.pay.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class UserAccount {

	private String accountId;
	
	private String userId;

	/**
	 * 账户余额
	 */
	private BigDecimal remainAmount;
	
	/**
	 * 账户创建时间
	 */
	private Date createTime;
	
	/**
	 * 账户上次消费时间
	 */
	private Date updateTime;
}
