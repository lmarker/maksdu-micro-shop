package com.maksdu.pay.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.maksdu.pay.domain.PayAccount;
import com.maksdu.pay.util.ClassUtils;

/**
 * 通过PayAccount选择支付处理器
 * @author lijia
 *
 */
public class PaySelectorFactory {

	private final ConcurrentMap<String, PaySelector> selectorMap = new ConcurrentHashMap<>();
	//静态表
	private final Map<String, String> viewTable = new HashMap<>();

	PaySelectorFactory() {
		viewTable.put("0-0", ClassUtils.getDeclaredClassName(NativePaySelector.class));
	}
	
	public void initLoader(String key, Class<?> cls) {
		viewTable.put(key, ClassUtils.getDeclaredClassName(cls));
	}
	
	public void registerSelector(PaySelector paySelector) throws Throwable {
		if(selectorMap.containsKey(paySelector.getUniqueKey())) {
			throw new Throwable();
		}
		selectorMap.putIfAbsent(paySelector.getUniqueKey(), paySelector);
	}
	
	public PaySelector getSelector(PayAccount payAccount) {
		int payMethod = payAccount.getPayMethod();
		int payUnit = payAccount.getPayUnit();
		String key = String.valueOf(payMethod)+"-"+String.valueOf(payUnit);
		return selectorMap.getOrDefault(viewTable.getOrDefault(key, ""), null);
	}
}
