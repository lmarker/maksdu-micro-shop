package com.maksdu.pay.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.maksdu.pay.condition.OnProcessMethodCondition;
import com.maksdu.pay.util.PayMethod;
import com.maksdu.pay.util.PayUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Conditional(OnProcessMethodCondition.class)
@Component
public @interface PayManage {

	int[] method() default {PayMethod.NATIVE};
	
	int[] unit() default {PayUnit.UNIT_ONE};
	
	Class<?> cls();
}
