package de.aclue.beansdemo.abstracttestsetup;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Jonas Keßler (jonas.kessler@aclue.de)
 */
public class InheritedInnerClassTestConfigApplicationTest extends InnerClassTestConfigAbstractTest {

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
