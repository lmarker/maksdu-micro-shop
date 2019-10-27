package com.maksdu.pay.domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 * CREATE TABLE pay_account (
	payid int(32) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id VARCHAR(20) NOT NULL,
	item VARCHAR(40) NOT NULL,
	descriptin VARCHAR(100),
	amount DECIMAL,
	payMethodDetail VARCHAR(100),
	payMethod TINYINT,
	payUnit TINYINT
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

ALTER TABLE `pay_account` ADD INDEX index_name ( `id` );
alter table pay_account add `status` int(32) not null; 

 * 支付账单
 * @author lijia
 *
 */
@Data
public class PayAccount {

	private int payId;
	
	/**
	 * 支付Id
	 */
	private String id;
	
	/**
	 * 支付条目
	 */
	private String item;
	
	/**
	 * 支付细节描述
	 */
	private String description;

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
	
	/**
	 * 来源id
	 */
	private String sourceAccountId;
	
	/**
	 * 目标id
	 */
	private String targetAccountId;
	
	/**
	 * 交易金额
	 */
	private BigDecimal amount;
	
	/**
	 * 交易状态
	 */
	private int status;
}
