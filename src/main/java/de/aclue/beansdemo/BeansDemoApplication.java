package de.aclue.beansdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeansDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeansDemoApplication.class, args);
	}
	
	@Bean
	public MyBean myBean() {
		return new MyBean();
	}

}
