package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class TestLog4j2 {

	public static void main(String[] args) {
		log.error("Hello World!");
		SpringApplication.run(TestLog4j2.class, args);
	}

}
