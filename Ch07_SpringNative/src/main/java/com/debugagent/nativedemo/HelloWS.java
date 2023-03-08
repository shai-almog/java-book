package com.debugagent.nativedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWS {
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }
}
