package com.maksdu.pay.core;

import com.maksdu.pay.util.ClassUtils;
import com.maksdu.pay.util.PayUnit;

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
