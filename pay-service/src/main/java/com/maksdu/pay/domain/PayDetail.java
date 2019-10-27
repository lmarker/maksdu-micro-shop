package com.maksdu.pay.domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 支付明细
 * @author lijia
 *
 */
@Data
public class PayDetail {

	/**
	 * 支付Id
	 */
	private String payId;
	
	/**
	 * 源账户
	 */
	private String sourceAccountId;
	
	/**
	 * 目标账户
	 */
	private String targetAccountId;
	
	/**
	 * 支付金额数量
	 */
	private BigDecimal amount;
	
}
