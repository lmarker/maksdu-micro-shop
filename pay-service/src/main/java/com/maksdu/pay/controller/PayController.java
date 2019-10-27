package com.maksdu.pay.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.maksdu.pay.domain.PayAccount;
import com.maksdu.pay.service.PayService;

@RestController
public class PayController {

	@Autowired
	private PayService payService;
	
	@GetMapping("/get/{id}")
	public Map<String, Object> getPayment(@PathVariable(value="id")String id) {
		PayAccount account = payService.getByAccountId(id);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("return", account);
		return hashMap;
	}
	
}
