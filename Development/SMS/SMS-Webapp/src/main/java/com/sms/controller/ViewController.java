package com.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ahmed.motair on 3/25/2018.
 */
@Controller
public class ViewController {

    @RequestMapping({ "/login/**", "/register/**", "/home/**", "/course/**", "/lecture/**", "/settings/**",
            "/lecture/**", "/upload/**", "/download/**"})
    public String index() {
        return "forward:/index.html";
    }

}

