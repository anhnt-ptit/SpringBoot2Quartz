package com.spring.quartz.test.SpringBoot2Quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.spring.quartz.test"})
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBoot2QuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2QuartzApplication.class, args);
	}

}
