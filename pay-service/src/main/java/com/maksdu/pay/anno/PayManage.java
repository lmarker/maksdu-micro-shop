package com.maksdu.pay.anno;

public @interface PayManage {

	String method() default "0";
	
	String unit() default "0";
	
}
