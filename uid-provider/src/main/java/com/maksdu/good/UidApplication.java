package com.maksdu.good;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baidu.fsg.uid")
public class UidApplication {

	public static void main(String[] args) {
		SpringApplication.run(UidApplication.class, args);
	}
	
}
