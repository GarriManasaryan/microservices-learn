package com.example.m1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class M1Application {

	public static void main(String[] args) {
		SpringApplication.run(M1Application.class, args);
	}

}
