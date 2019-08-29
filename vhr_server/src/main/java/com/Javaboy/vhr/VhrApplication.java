package com.Javaboy.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.Javaboy.vhr.mapper")
public class VhrApplication {

	public static void main(String[] args) {
		SpringApplication.run(VhrApplication.class, args);
	}

}
