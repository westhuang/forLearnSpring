package com.west.forlearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@MapperScan("com.west.forlearn.dao.mapper")
@EnableTransactionManagement
public class ForlearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForlearnApplication.class, args);
	}
}
