package org.AluraChallenges;

import java.util.Map;

public record TasaDeConversion(
        String result,
        String base_code,
        Map<String, Double> conversion_rates
) {
}