package de.aclue.beansdemo.abstracttestsetup;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import de.aclue.beansdemo.AnotherBean;
import de.aclue.beansdemo.MyBean;

/**
 *
 * @author Jonas Keßler (jonas.kessler@aclue.de)
 */
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
public abstract class InnerClassTestConfigAbstractTest {

	@Autowired
	@Qualifier("myBean")
	protected MyBean myBeanMock;

	@Autowired(required = false)
	@Qualifier("myBean2")
	protected MyBean myBeanDefinedInBeansDemoConfig;

	@Autowired
	protected AnotherBean anotherBeanMock;
	
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
