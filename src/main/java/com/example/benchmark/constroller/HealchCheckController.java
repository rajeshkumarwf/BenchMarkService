package com.example.benchmark.constroller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealchCheckController implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return null;
    }

    @Override
    public Health health() {
        return Health.up().build();
    }

    @GetMapping("/esg/benchmark/keepalive")
    public Object keepAlive(){
        return health().getStatus();
    }
}
