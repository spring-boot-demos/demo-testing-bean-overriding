package de.aclue.beansdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Jonas Keßler (jonas.kessler@aclue.de)
 */
@Configuration
public class BeansDemoConfig {
	
	@Bean
	public MyBean myBean() {
		return new MyBean();
	}

	@Bean
	public MyBean myBean2() {
		return new MyBean();
	}
	
}
