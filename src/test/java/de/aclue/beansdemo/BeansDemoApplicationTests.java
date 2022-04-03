package de.aclue.beansdemo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@Slf4j
class BeansDemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@TestConfiguration
	public static class TestConfig{
		
		@Bean
		public MyBean myBean() {
			log.info("MOCK");
			return Mockito.mock(MyBean.class);
		}
	}

}
