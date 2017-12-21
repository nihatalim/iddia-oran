package com.nihatalim.iddiatahmin.bulten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BultenApplication {

	public static void main(String[] args) {
		SpringApplication.run(BultenApplication.class, args);
	}
}
