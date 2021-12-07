package com.jobsity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		org.springframework.context.ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);

	}

}
