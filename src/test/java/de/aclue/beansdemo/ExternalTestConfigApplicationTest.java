package de.aclue.beansdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
// does not work -> myBeanMock is not a mock
//@Import(ExternalTestConfig.class)
// works -> all configs from app must be listed in the correct order (TestConfig as last)
@ContextConfiguration(classes = {BeansDemoConfig.class, ExternalTestConfig.class})
// does not work -> myBeanMock is not a mock
//@ContextConfiguration(classes = {ExternalTestConfig.class, BeansDemoConfig.class})
public class ExternalTestConfigApplicationTest {

	@Autowired
	@Qualifier("myBean")
	private MyBean myBeanMock;

	@Autowired(required = false)
	@Qualifier("myBean2")
	private MyBean myBeanDefinedInBeansDemoConfig;

	@Autowired
	private AnotherBean anotherBeanMock;
	
	@Test
	void notOverridenBeanFromBeansDemoConfigFound() {
		assertThat(myBeanDefinedInBeansDemoConfig).isNotNull();
	}

	@Test
	void overrideBeanDefinedViaBeanMethod() {
		// test fails, if myBeanMock is not a mock
		verifyNoInteractions(myBeanMock);
	}

	@Test
	void overrideBeanDefinedViaServiceAnnotation() {
		// test fails, if anotherBeanMock is not a mock
		verifyNoInteractions(anotherBeanMock);
	}
}
