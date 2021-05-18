package com.thanhsang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringBoot2021Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2021Application.class, args);
	}

}
