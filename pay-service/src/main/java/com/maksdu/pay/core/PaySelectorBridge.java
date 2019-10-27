package com.maksdu.pay.core;

import com.maksdu.pay.util.PayMethod;

/**
 * 支付选择器工厂
 * @author lijia
 *
 */
public class PaySelectorBridge {

	public static PaySelector builder(PaySelector selector, int payUnit) {
		selector.loader(payUnit);
		return selector;
	}
	
	/**
	 * 默认构造器
	 * @param selector
	 * @return
	 */
	public static PaySelector builder(PaySelector selector) {
		return builder(selector,  PayMethod.THIRD_PLATFORM);
	}
	
}
