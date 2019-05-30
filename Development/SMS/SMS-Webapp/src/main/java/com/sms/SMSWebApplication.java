package com.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SMSWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMSWebApplication.class, args);
    }
}
