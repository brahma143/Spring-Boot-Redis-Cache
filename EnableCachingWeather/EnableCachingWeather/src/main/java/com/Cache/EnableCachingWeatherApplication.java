package com.Cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.Cache")
@EntityScan(basePackages = "com.Cache.Entity")
@EnableJpaRepositories(basePackages = "com.Cache.Repository")
public class EnableCachingWeatherApplication {

	public static void main(String[] args) {

		SpringApplication.run(EnableCachingWeatherApplication.class, args);

		System.out.println("Weather 8010!!!..");
	}

}
