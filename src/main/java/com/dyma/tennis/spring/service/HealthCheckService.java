package com.dyma.tennis.spring.service;

import com.dyma.tennis.spring.repository.HealthCheckRepository;
import com.dyma.tennis.spring.ApplicationStatus;
import com.dyma.tennis.spring.HealthCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    @Autowired
    private HealthCheckRepository healthCheckRepository;
    public HealthCheck healthCheck() {
        Long activeSession = healthCheckRepository.countApplicaltionConnections();
        if (activeSession > 0) {
            return new HealthCheck(ApplicationStatus.OK, "Tout est ok, il ya : "+ activeSession + " pools de connexion active");
        }else {
            return new HealthCheck(ApplicationStatus.KO, "Aucune connexion active");
        }
    }
}
