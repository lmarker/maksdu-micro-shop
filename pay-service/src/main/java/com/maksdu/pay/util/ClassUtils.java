package com.maksdu.pay.util;

public class ClassUtils {

	public static String getDeclaredClassName(Class<?> cls) {
		String name = cls.getSimpleName();
		return name.substring(0,1).toLowerCase() + name.substring(1);
	}
	
}
