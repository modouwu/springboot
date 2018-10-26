package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@SpringBootApplication
public class HessianClientApplication {
	@Bean
	public HessianProxyFactoryBean helloClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://localhost:8090/HelloWorldService");
		factory.setServiceInterface(HelloWorldService.class);
		factory.setOverloadEnabled(true);//设置是否支持方法重载,默认false
		return factory;
	}




	public static void main(String[] args) {
		SpringApplication.run(HessianClientApplication.class, args);
	}
}
