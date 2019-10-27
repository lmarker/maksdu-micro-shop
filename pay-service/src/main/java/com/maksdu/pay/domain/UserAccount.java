package com.maksdu.pay.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UserAccount {

	private int id;
	
	/**
	 * 钱包Id
	 */
	private String accountId;
	
	/**
	 * 用户Id
	 */
	private String userId;
	
	/**
	 * 账户余额
	 */
	private BigDecimal remainAmount;
	
	public void changeRemain(BigDecimal number, boolean isAdd) throws Throwable {
		if(isAdd) {
			this.remainAmount = this.remainAmount.add(number);
		} else {
			if(number.compareTo(this.remainAmount) > 1) {
				throw new Throwable();
			} else {
				this.remainAmount = this.remainAmount.subtract(number);
			}
		}
	}
	
}
