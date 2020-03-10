package com.lms.cblog;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class CblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CblogApplication.class, args);

    }

}
