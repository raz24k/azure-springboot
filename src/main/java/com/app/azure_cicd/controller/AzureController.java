package com.app.azure_cicd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AzureController {

    @RequestMapping("/hello")
    public String helloRajashekhar() {
        return "Hello Rajashekhar";
    }
}

