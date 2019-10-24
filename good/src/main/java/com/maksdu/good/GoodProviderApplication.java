package com.maksdu.good;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.spring4all.swagger.EnableSwagger2Doc;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2Doc
public class GoodProviderApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GoodProviderApplication.class, args);
	}
	
}
