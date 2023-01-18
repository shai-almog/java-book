package com.debugagent.demo.rest;

import com.debugagent.demo.service.HelloService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWebService {
    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.helloService(name);
    }
}
