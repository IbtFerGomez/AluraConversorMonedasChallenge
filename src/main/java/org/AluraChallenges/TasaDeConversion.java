package org.AluraChallenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record TasaDeConversion(
        String result,
        String base_code,
        Map<String, Double> conversion_rates
) {
    public List<Map.Entry<String, Double>> obtenerTasasOrdenadas() {
        return conversion_rates.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();
    }

    public Map<String, Double> filtrarPorCriterio(double limite) {
        return conversion_rates.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > limite)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}