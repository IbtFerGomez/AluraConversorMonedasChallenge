package org.AluraChallenges;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
public class GeneradorDeArchivo {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public void guardarCodigos(CodigosMoneda codigosMoneda) throws IOException {
        FileWriter escritura = new FileWriter("codigos.json");
        escritura.write(gson.toJson(codigosMoneda));
        escritura.close();
    }

    public void guardarTasaDeConversion(TasaDeConversion tasaDeConversion) throws IOException {
        FileWriter escritura = new FileWriter(tasaDeConversion.base_code() + ".json");
        escritura.write(gson.toJson(tasaDeConversion));
        escritura.close();
    }
}