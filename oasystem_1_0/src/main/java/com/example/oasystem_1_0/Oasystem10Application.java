package com.example.oasystem_1_0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = {"com.example.oasystem_1_0.dao"})
@SpringBootApplication
public class Oasystem10Application {

	public static void main(String[] args) {
		SpringApplication.run(Oasystem10Application.class, args);
	}
}
