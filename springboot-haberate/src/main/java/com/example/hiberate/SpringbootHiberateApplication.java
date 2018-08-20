package com.example.hiberate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableSwagger2
public class SpringbootHiberateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHiberateApplication.class, args);
	}

	/*@Autowired
	private EntityManagerFactory entityManagerFactory;

	有这一段 报错循环依赖,网上说是因为
	you should inject the JPA EntityManager via @PersistenceUnit, not @Autowired.
	And remove the getSessionFactory since the Hibernate SessionFactory is already created internally
	and you can always unwrap the EntityManagerFactory.

	@Bean
	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}*/

	/*@PersistenceContext
	EntityManagerFactory entityManagerFactory;*/

	/*@PersistenceContext
	SessionFactory sessionFactory;*/

	/*@Bean
	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}*/

}