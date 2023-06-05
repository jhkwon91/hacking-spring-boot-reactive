package com.jhkwon91.hackingspringboot.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.publisher.Hooks;

@SpringBootApplication
@ComponentScan(basePackages = "com.jhkwon91.hackingspringbo\not")
public class HackingSpringBootApplication {

//	@Bean
//	HttpTraceRepository traceRepository() {
//		return new InMemoryHttpTraceRepository();
//	}

	public static void main(String[] args) {
		Hooks.onOperatorDebug();
//		BlockHound.install();

		SpringApplication.run(HackingSpringBootApplication.class, args);
	}

}
