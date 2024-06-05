package com.flipkart.RestaurantManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.flipkart")
@EnableJpaRepositories(basePackages = "com.flipkart.core.repository")
@EntityScan(basePackages = "com.flipkart.core.entities") // Explicitly scan entity package

public class RestaurantManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantManagementApplication.class, args);
	}

}
