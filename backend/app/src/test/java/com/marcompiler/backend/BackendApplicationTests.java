package com.marcompiler.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = BackendApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-tests.properties")
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
