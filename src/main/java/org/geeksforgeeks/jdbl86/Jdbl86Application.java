package org.geeksforgeeks.jdbl86;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Jdbl86Application {

    public static void main(String[] args) {
        SpringApplication.run(Jdbl86Application.class, args);
    }

}
