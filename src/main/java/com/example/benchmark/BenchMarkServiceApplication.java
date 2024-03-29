package com.example.benchmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan
public class BenchMarkServiceApplication {

	@Autowired
	Environment env;

	@Value("${baseUrl}")
	private String baseUrl;

	@Bean
	public WebClient webClient() {
		return WebClient.builder().baseUrl(baseUrl).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(BenchMarkServiceApplication.class, args);
	}

}
