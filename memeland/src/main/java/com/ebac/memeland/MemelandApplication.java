package com.ebac.memeland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MemelandApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemelandApplication.class, args);
	}

}
