package com.maksdu.pay;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maksdu.pay.core.PaySelectorFactory;

@SpringBootApplication
@RestController
public class PayApplication {

	@GetMapping("/")
	public Map<String, String> getMap() {
		return PaySelectorFactory.getMap();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PayApplication.class, args);
	}
	
}
