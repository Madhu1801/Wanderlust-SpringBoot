package com.example.wanderlust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WanderlustApplication {

	public static void main(String[] args) {
		SpringApplication.run(WanderlustApplication.class, args);
		System.out.print("Hello world");
	}

}
