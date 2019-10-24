package com.maksdu.pay.core;

/**
 * 支付选择器
 * @author lijia
 *
 */
public interface PaySelector {

	/**
	 * 装载支付单位
	 * @param payMethod
	 * @param payUnit
	 */
	void loader(int payUnit);
	
	void processor();
	
	/**
	 * 获取唯一Key
	 * @return
	 */
	String getUniqueKey();
}
