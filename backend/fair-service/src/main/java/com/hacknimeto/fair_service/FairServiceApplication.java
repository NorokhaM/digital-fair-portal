package com.hacknimeto.fair_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class FairServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FairServiceApplication.class, args);
	}

}
