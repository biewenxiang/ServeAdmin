package com.xss.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServeAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeAdminApplication.class, args);

	}
}
