package com.dmv.controller;

import com.dmv.domain.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String index() {
        return "Hello world!";
    }

    @GetMapping("/private")
    public String privateIndex(@AuthenticationPrincipal CustomUserDetails user) {
        System.out.println(user.getId());
        return "private";
    }
}
