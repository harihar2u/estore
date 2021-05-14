package com.online.estore.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping(value = "/ping")
    public String index() {
        return "Estore Spring Boot Ping!!";
    }
}
