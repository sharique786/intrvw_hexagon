package org.intervw.hexagon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("org.intervw.hexagon")
@Configuration 
@EnableAutoConfiguration(exclude=ErrorMvcAutoConfiguration.class)
public class BootApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
