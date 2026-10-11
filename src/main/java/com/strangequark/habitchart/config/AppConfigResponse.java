package com.strangequark.habitchart.config;

import java.util.List;

public record AppConfigResponse(
        String applicationName,
        String version,
        boolean localFirst,
        List<String> features
) {
}
