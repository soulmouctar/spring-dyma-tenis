package com.dyma.tennis.spring;

import com.dyma.tennis.spring.repository.HealthCheckRepository;
import com.dyma.tennis.spring.rest.HealthCheckController;
import com.dyma.tennis.spring.service.HealthCheckService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    HealthCheckController healthCheckController;

    @Autowired
    HealthCheckService healthCheckService;

    @Autowired
    HealthCheckRepository healthCheckRepository;


    @Test
    void contextLoads() {
        Assertions.assertNotNull(healthCheckController);
        Assertions.assertNotNull(healthCheckService);
        Assertions.assertNotNull(healthCheckRepository);
    }

}
