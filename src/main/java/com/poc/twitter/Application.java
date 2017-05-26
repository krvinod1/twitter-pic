package com.poc.twitter;

import com.poc.twitter.persistence.DatabaseInitializer;
import com.poc.twitter.persistence.h2db.H2DatabaseInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        DatabaseInitializer databaseInitializer = new H2DatabaseInitializer();
        databaseInitializer.initialize();
        SpringApplication.run(Application.class, args);
    }
}
