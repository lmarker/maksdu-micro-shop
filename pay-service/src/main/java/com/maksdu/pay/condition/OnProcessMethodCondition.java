package com.maksdu.pay.condition;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import com.maksdu.pay.anno.PayManage;
import com.maksdu.pay.core.PaySelectorFactory;

@Component
public class OnProcessMethodCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//获取注解的原信息
		Map<String,Object> attributes = metadata.getAnnotationAttributes
				(PayManage.class.getName());
		if(attributes == null)
			return false;
		String propertyName = String.valueOf(attributes.get("method"));
		String propertyValue = String.valueOf(attributes.get("unit"));
		Class<?> cls = (Class<?>) attributes.get("cls");
		PaySelectorFactory.initLoader(propertyName+"-"+propertyValue, cls);
		return true;
	}



}
