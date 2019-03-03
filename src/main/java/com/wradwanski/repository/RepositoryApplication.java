package com.wradwanski.repository;

import com.wradwanski.repository.client.decoder.GithubErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class RepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
	}

	@Bean
	public GithubErrorDecoder githubErrorDecoder(){
		return new GithubErrorDecoder();
	}
}
