package com.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisteryServiceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisteryServiceEurekaApplication.class, args);
	}

}
