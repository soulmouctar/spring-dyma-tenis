package com.dyma.tennis.spring.rest;

import com.dyma.tennis.spring.HealthCheck;
import com.dyma.tennis.spring.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private final HealthCheckService healthCheckService;

    public HealthCheckController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping("/healthcheck")
    public HealthCheck healthCheck() {
        return healthCheckService.healthCheck();
    }
}
