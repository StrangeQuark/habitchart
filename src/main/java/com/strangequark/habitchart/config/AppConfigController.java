package com.strangequark.habitchart.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/habitchart/config")
public class AppConfigController {

    private final String applicationName;
    private final String version;

    public AppConfigController(
            @Value("${spring.application.name}") String applicationName,
            @Value("${app.version}") String version
    ) {
        this.applicationName = applicationName;
        this.version = version;
    }

    @GetMapping
    public AppConfigResponse getConfig() {
        return new AppConfigResponse(
                applicationName,
                version,
                true,
                List.of("local-first", "offline-ready", "habit-chart")
        );
    }
}
