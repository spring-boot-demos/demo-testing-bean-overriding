package de.aclue.beansdemo;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ExternalTestConfig {

	@Bean
	public MyBean myBean() {
		return Mockito.mock(MyBean.class);
	}
	
}
