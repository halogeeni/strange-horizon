package com.arasio.webdev.strangehorizon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/healthcheck")
public class HealthCheckController {

    @Autowired
    private BuildProperties buildProperties;

    @RequestMapping("")
    @ResponseBody
    public String checkSanity() {
        return buildProperties.getName() + " " + buildProperties.getVersion();
    }
}
