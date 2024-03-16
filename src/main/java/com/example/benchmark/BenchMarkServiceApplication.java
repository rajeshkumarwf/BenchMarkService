package com.example.benchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BenchMarkServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenchMarkServiceApplication.class, args);
	}

}
