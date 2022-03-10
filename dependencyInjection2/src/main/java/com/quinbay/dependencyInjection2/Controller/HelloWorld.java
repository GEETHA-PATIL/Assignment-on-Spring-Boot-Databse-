package com.quinbay.dependencyInjection2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

//@controller
public class HelloWorld {


    @GetMapping("/greet")
    public String greet() {
        return "HelloEveryone";
    }
}
