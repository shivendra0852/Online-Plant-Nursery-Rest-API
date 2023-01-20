package com.greenhood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GreenHoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenHoodApplication.class, args);
	}

}
