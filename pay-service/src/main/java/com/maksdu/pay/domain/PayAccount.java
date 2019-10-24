package com.maksdu.pay.domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 支付账单
 * @author lijia
 *
 */
@Data
public class PayAccount {

	/**
	 * 支付Id
	 */
	private String Id;
	
	/**
	 * 支付条目
	 */
	private String item;
	
	/**
	 * 支付细节描述
	 */
	private String descriptin;

	/**
	 * 支付金额数量
	 */
	private BigDecimal amount;
	
	/**
	 * 支付方式选择
	 * 0、本地支付
	 * 1、第三方接口支付
	 */
	private int payMethod;
	
	/**
	 * 支付方法明细
	 */
	private String payMethodDetail;
	
	/**
	 * 支付单位
	 */
	private int payUnit;
}
