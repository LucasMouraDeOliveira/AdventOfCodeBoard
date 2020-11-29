package com.lordkadoc.advent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdventOfCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdventOfCodeApplication.class, args);
	}

}
