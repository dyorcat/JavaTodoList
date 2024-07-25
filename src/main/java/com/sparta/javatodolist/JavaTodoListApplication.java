package com.sparta.javatodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JavaTodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTodoListApplication.class, args);
    }

}
