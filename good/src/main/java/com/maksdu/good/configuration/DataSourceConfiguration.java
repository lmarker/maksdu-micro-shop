package com.maksdu.good.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {
	
	@Primary
	@Bean(name="jpaDataSource")
	@ConfigurationProperties(prefix="spring.datasource.master")
	public DataSource jpaDataSource() {
		return DataSourceBuilder.create().build();
	}
	
}
