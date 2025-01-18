package org.AluraChallenges;

import java.util.List;

public record CodigosMoneda(
        String result,
        List<List<String>> supported_codes
) {
}