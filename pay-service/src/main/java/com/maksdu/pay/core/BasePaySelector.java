package com.maksdu.pay.core;

import com.maksdu.pay.domain.PayUnit;
import com.maksdu.pay.util.ClassUtils;

public abstract class BasePaySelector implements PaySelector {

	protected int payUnit = PayUnit.UNIT_ONE;
	
	public void setPayUnit(int payUnit) {
		this.payUnit = payUnit;
	}
	
	@Override
	public String getUniqueKey() {
		return getClassDeclareName();
	}
	
	private String getClassDeclareName() {
		return ClassUtils.getDeclaredClassName(this.getClass());
	}
}
