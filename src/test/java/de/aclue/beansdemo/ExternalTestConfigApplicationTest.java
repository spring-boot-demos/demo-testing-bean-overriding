package de.aclue.beansdemo;

import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@Import(ExternalTestConfig.class)
public class ExternalTestConfigApplicationTest {

	@Autowired
	private MyBean myBeanMock;

	@Test
	void contextLoads() {
		// test fails, if myBeanMock is not a mock
		verifyNoInteractions(myBeanMock);
	}
}
