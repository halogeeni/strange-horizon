package com.arasio.webdev.strangehorizon.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @RequestMapping("/healthcheck")
    @ResponseBody
    public String healthcheck() {
        return "I'm OK!";
    }
}
