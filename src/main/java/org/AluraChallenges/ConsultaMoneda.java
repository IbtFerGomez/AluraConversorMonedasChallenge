package org.AluraChallenges;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    private final String API_KEY = "17721fc7a0068fa8b95f0aaa";
    private final HttpClient client = HttpClient.newHttpClient();
    public CodigosMoneda consultarCodigos(){
        URI url = URI.create(String.format("https://v6.exchangerate-api.com/v6/%s/codes", API_KEY));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CodigosMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al traer los codigos");
        }
    }

    public TasaDeConversion consultarTasaDeConversion(String codigo) {
        URI url = URI.create(String.format("https://v6.exchangerate-api.com/v6/%1$s/latest/%2$s", API_KEY, codigo));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TasaDeConversion.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al traer la tasa de cambio");
        }
    }
}
