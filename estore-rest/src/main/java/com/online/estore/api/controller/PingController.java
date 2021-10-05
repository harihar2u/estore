package com.online.estore.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PingController {

    @GetMapping(value = "/")
    public String index() {
        return String.format("E-Store Spring Boot Running: %s!", new Date());
    }
}
