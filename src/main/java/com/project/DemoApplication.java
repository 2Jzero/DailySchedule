package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.project")  // 컴포넌트 스캔을 위한 패키지 설정
@EntityScan(basePackages = "com.project.jpa") // 엔티티 스캔을 위한 패키지 설정
@EnableJpaRepositories(basePackages = "com.project.jpa")  // JPA 리포지토리 스캔
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
