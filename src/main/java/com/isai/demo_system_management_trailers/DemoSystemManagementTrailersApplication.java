package com.isai.demo_system_management_trailers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
public class DemoSystemManagementTrailersApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSystemManagementTrailersApplication.class, args);
    }

    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
}
