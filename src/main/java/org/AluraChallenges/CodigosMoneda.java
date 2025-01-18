package org.AluraChallenges;

import java.util.List;

public record CodigosMoneda(
        String result,
        List<List<String>> supported_codes
) {
    public List<String> buscarCodigos(String prefijo) {
    return supported_codes.stream()
            .flatMap(List::stream)
            .filter(codigo -> codigo.startsWith(prefijo))
            .toList();
}
}