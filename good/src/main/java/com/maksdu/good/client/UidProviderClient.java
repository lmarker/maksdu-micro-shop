package com.maksdu.good.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("uid-provider")
public interface UidProviderClient {
	
	@GetMapping("/testuid")
	String consumer();
	
}
