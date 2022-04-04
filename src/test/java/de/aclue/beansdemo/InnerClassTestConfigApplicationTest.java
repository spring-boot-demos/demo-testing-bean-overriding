package de.aclue.beansdemo;

import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
class InnerClassTestConfigApplicationTest {

	@Autowired
	private MyBean myBeanMock;

	@Autowired
	private AnotherBean anotherBeanMock;

	@Test
	void overrideBeanDefinedViaBeanMethod() {
		// test fails, if myBeanMock is not a mock
		verifyNoInteractions(myBeanMock);
	}

	@Test
	void overrideBeanDefinedViaServiceAnnotation() {
		// test fails, if myBeanMock is not a mock
		verifyNoInteractions(anotherBeanMock);
	}
	
	@TestConfiguration
	public static class TestConfig{
		
		@Bean
		public MyBean myBean() {
			return Mockito.mock(MyBean.class);
		}
		
		@Bean
		public AnotherBean anotherBean() {
			return Mockito.mock(AnotherBean.class);
		}
	}

}
