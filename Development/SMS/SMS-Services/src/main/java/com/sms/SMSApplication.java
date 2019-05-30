package com.sms;

import com.sms.configuration.JerseyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.text.MessageFormat;

@SpringBootApplication
@EnableAutoConfiguration
@Import({ JerseyConfig.class })
public class SMSApplication {

    public static void main(String[] args) {
//        String sql1 = "INSERT INTO user_detail (user_id, first_name, last_name, email) VALUE " +
//                "({0}, ''{1}'', ''User {0}'', ''{2}.user{0}@sms.com'');";
//        String sql = "INSERT INTO user_detail (user_id, first_name, last_name, email) VALUE " +
//                "({0}, ''{1}'', ''User {0}'', ''{2}.user{0}@sms.com'');";
//
//        for(int i=1; i<30; i++)
//            if(i==9 || i==15)
//                System.out.println(MessageFormat.format(sql, i, "System Admin", "system.admin"));
//            else if(i==1 || i==4 || i==5 || i==6 || i==30)
//                System.out.println(MessageFormat.format(sql, i, "Instructor", "instructor"));
//            else
//                System.out.println(MessageFormat.format(sql, i, "Student", "student"));
        SpringApplication.run(SMSApplication.class, args);
    }
}
