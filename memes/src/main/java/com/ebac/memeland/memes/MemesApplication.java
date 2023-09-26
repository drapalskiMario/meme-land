package com.ebac.memeland.memes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MemesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemesApplication.class, args);
	}

}
