package com.imsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.imsystem.mapper")
public class ImsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsystemApplication.class, args);
	}

}
