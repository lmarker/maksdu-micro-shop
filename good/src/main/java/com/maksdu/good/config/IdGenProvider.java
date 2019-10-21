package com.maksdu.good.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maksdu.good.client.UidProviderClient;

@Component
public class IdGenProvider {

	@Autowired
	private UidProviderClient uidProviderClient;
	
	private static IdGenProvider provider;
	
	public void init() {
		provider = this;
	}
	
	public static String getId() {
		return provider.uidProviderClient.consumer();
	}
	
}
