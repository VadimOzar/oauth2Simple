package com.dmv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String index() {
        return "Hello world!";
    }

    @GetMapping("/private")
    public String privateIndex() {
        return "private";
    }
}
