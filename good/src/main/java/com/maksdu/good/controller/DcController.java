package com.maksdu.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maksdu.good.client.UidProviderClient;

@RestController
public class DcController {

	@Autowired
	private UidProviderClient uidProviderClient;
	
	@GetMapping("/consumer")
	public String dc() {
		return uidProviderClient.consumer();
	}
}
