package com.example.recruitmentwebsitesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.example.recruitmentwebsitesystem.repo")
@EntityScan(basePackages = {"com.example.recruitmentwebsitesystem.entity"})
@ComponentScan(basePackages = { "com.example.recruitmentwebsitesystem.*" })
@EnableConfigurationProperties
public class RecruitmentWebsiteSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentWebsiteSystemApplication.class, args);
    }

}
