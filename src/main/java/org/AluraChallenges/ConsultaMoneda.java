package org.AluraChallenges;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    private final String API_KEY = "5f15dd042e1ba59f6173a982";
    private final HttpClient client = HttpClient.newHttpClient();
    private final GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo(); // Configuración para guardar archivos.

    public CodigosMoneda consultarCodigos() throws IOException, InterruptedException {
        URI url = URI.create(String.format("https://v6.exchangerate-api.com/v6/%s/codes", API_KEY));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        CodigosMoneda codigosMoneda = new Gson().fromJson(response.body(), CodigosMoneda.class);

        // Guardar los códigos obtenidos en un archivo.
        generadorDeArchivo.guardarCodigos(codigosMoneda);
        return codigosMoneda;
    }

    public TasaDeConversion consultarTasaDeConversion(String codigo) throws IOException, InterruptedException {
        URI url = URI.create(String.format("https://v6.exchangerate-api.com/v6/%1$s/latest/%2$s", API_KEY, codigo));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        TasaDeConversion tasaDeConversion = new Gson().fromJson(response.body(), TasaDeConversion.class);

        // Guardar las tasas obtenidas en un archivo.
        generadorDeArchivo.guardarTasaDeConversion(tasaDeConversion);
        return tasaDeConversion;
    }
}
