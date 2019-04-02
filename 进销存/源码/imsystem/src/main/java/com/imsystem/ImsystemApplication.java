package com.imsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@MapperScan("com.imsystem.mapper")
/*@ComponentScan(basePackages = "com.imsystem.mapper.*")
*///@EnableWebSocket//开启websocket
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class ImsystemApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ImsystemApplication.class, args);
	}

}
