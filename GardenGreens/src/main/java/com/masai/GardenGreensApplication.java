package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class GardenGreensApplication {

	public static void main(String[] args) {
		SpringApplication.run(GardenGreensApplication.class, args);
	}
	

	

}
