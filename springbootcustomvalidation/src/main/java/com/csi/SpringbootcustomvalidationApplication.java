package com.csi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringApplication
@EnableCaching
public class SpringbootcustomvalidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcustomvalidationApplication.class, args);
	}

}
