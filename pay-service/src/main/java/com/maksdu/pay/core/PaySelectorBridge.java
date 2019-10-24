package com.maksdu.pay.core;

import com.maksdu.pay.domain.PayMethod;

/**
 * 支付选择器工厂
 * @author lijia
 *
 */
public class PaySelectorBridge {

	public PaySelector builder(PaySelector selector, int payUnit) {
		selector.loader(payUnit);
		return selector;
	}
	
	/**
	 * 默认构造器
	 * @param selector
	 * @return
	 */
	public PaySelector builder(PaySelector selector) {
		return builder(selector,  PayMethod.THIRD_PLATFORM);
	}
	
}
