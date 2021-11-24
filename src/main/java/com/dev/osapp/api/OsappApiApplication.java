package com.dev.osapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.dev.osapp.api.config.property.OsAppApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(OsAppApiProperty.class)
public class OsappApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsappApiApplication.class, args);
	}

}
