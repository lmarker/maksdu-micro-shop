package com.maksdu.pay.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.maksdu.pay.condition.OnProcessMethodCondition;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Conditional(OnProcessMethodCondition.class)
@Component
public @interface PayManage {

	String method() default "0";
	
	String unit() default "0";
	
	Class<?> cls();
}
