package com.west.forlearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan("com.west.forlearn.dao.mapper")
public class ForlearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForlearnApplication.class, args);
	}
}
