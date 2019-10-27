package com.maksdu.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@MapperScan("com.maksdu.pay.mapper") 
public class PayApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(PayApplication.class, args);
	}
	
}
