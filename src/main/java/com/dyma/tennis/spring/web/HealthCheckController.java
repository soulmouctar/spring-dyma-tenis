package com.dyma.tennis.spring.web;

import com.dyma.tennis.spring.HealthCheck;
import com.dyma.tennis.spring.service.HealthCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Health check API")
@RestController
public class HealthCheckController {

    @Autowired
    private final HealthCheckService healthCheckService;


    public HealthCheckController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @Operation(summary = "Return application health check", description = "returns the application status.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "healthcheck status with some detail",
                 content = {@Content(mediaType = "application/json",
                 schema = @Schema(implementation = HealthCheck.class))}),
    })

    @GetMapping("/healthcheck")
    public HealthCheck healthCheck() {
        return healthCheckService.healthCheck();
    }
}
