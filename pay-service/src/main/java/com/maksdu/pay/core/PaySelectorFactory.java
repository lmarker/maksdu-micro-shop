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

	private static final ConcurrentMap<String, PaySelector> selectorMap = new ConcurrentHashMap<>();
	//静态表
	private static final Map<String, String> viewTable = new HashMap<>();

	public static void initLoader(String key, Class<?> cls) {
		viewTable.put(key, ClassUtils.getDeclaredClassName(cls));
	}
	
	public static void registerSelector(PaySelector paySelector) throws Throwable {
		if(selectorMap.containsKey(paySelector.getUniqueKey())) {
			throw new Throwable();
		}
		selectorMap.putIfAbsent(paySelector.getUniqueKey(), paySelector);
	}
	
	public static PaySelector getSelector(PayAccount payAccount) {
		int payMethod = payAccount.getPayMethod();
		int payUnit = payAccount.getPayUnit();
		String key = String.valueOf(payMethod)+"-"+String.valueOf(payUnit);
		return selectorMap.getOrDefault(viewTable.getOrDefault(key, ""), null);
	}
	
	public static Map<String, String> getMap() {
		return viewTable;
	}
}
