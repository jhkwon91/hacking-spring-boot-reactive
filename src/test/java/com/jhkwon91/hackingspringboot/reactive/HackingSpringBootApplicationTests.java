package com.jhkwon91.hackingspringboot.reactive;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HackingSpringBootApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(HackingSpringBootApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Test
	public void testMyKitchen() {
		KitchenService kitchen = new KitchenService();
		kitchen.getDishes().subscribe(
				dish -> logger.info("Getting dish " + dish)
		);
	}

}
