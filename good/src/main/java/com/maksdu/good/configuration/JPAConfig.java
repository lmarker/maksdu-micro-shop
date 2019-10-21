package com.maksdu.good.configuration;

import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "masterEntityManagerFactory",
		basePackages="com.maksdu.*.repository",
		transactionManagerRef="transactionManager")
public class JPAConfig {

	@Autowired
	private HibernateProperties hibernateProperties;

	@Resource
	private JpaProperties jpaProperties;

	@Resource
	@Qualifier("jpaDataSource")
	private DataSource jpaDataSource;

	@Primary
	@Bean(name = "masterEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactory(builder).getObject().createEntityManager();
	}

	@Primary
	@Bean(name="masterEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
				jpaProperties.getProperties(), new HibernateSettings());
		return builder
				.dataSource(jpaDataSource)
				.packages("com.maksdu.*.domain")
				.properties(properties)
				.build();
	}

	@Bean(name="transactionManager")
	public JpaTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory(builder).getObject());
		return transactionManager;
	} 
}
