package com.dxjunkyard.sportsevent;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dxjunkyard.sportsevent.repository.dao.mapper")
public class SportsEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsEventApplication.class, args);
	}

}
