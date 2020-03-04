package com.mak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author manikandan.dhana
 * 
 * 
*/
@SpringBootApplication
@ComponentScan(basePackages = "com.mak.configuration")
public class SpringbootapplicationdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootapplicationdemoApplication.class, args);
	}

}
