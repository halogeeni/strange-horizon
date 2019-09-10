package com.arasio.webdev.strangehorizon.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HealthCheckControllerTest {

    @Autowired
    HealthCheckController controller;

    @Test
    public void returnsOkMessage() {
        assertEquals("I'm OK!", controller.healthcheck());
    }
}
