package com.maksdu.pay.core.selector;

import com.maksdu.pay.anno.PayManage;
import com.maksdu.pay.core.BasePaySelector;

@PayManage(cls=NativePaySelector.class, method="1",unit="1")
public class NativePaySelector extends BasePaySelector {

	
	@Override
	public void loader(int payUnit) {
		this.payUnit = payUnit;
	}

	@Override
	public void processor() {
		
	}
	
	

}
