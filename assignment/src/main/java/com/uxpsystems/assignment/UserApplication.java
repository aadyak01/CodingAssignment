package com.uxpsystems.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/*
    A Spring Boot application's main class is a class that
     contains a public static void main () method that starts up the Spring ApplicationContext.
 */
@SpringBootApplication(exclude= HazelcastAutoConfiguration.class)
@EnableWebSecurity
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
