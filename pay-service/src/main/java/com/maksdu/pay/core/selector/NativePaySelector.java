package com.maksdu.pay.core.selector;

import com.maksdu.pay.anno.PayManage;
import com.maksdu.pay.core.BasePaySelector;

@PayManage(cls=NativePaySelector.class)
public class NativePaySelector extends BasePaySelector {

	@Override
	public void processor() {
		
	}

	@Override
	public void loader(int payUnit) {
		// TODO Auto-generated method stub
		
	}
	
	

}
