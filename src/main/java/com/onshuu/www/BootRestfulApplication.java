package com.onshuu.www;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EntityScan(
		basePackageClasses = {Jsr310JpaConverters.class},
		basePackages = {"com.onshuu.www"})

@SpringBootApplication(exclude= {MultipartAutoConfiguration.class})
public class BootRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestfulApplication.class, args);
	}

}
 