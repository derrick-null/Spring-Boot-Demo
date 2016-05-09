package com.derrick;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Derrick on 2016/4/26.
 */
@Controller
@EnableAutoConfiguration
public class HelloWorld {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        org.springframework.boot.SpringApplication.run(HelloWorld.class, args);
    }
}
