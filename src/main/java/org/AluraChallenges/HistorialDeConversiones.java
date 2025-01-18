package org.AluraChallenges;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialDeConversiones {

    // Lista para almacenar el historial de conversiones
    private final List<String> historial = new ArrayList<>();

    // Metodo para agregar una nueva conversión al historial
    public void agregarConversion(String origen, String destino, double monto, double resultado) {
        String registro = String.format("%s - Convertido %.2f %s a %.2f %s",
                LocalDateTime.now(), monto, origen, resultado, destino);
        historial.add(registro);
    }

    // Metodo para mostrar el historial en consola
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("Historial de Conversiones:");
            historial.forEach(System.out::println);
        }
    }

    // Metodo para guardar el historial en un archivo
    public void guardarHistorialEnArchivo() throws IOException {
        try (FileWriter escritura = new FileWriter("historial-conversiones.txt", true)) {
            for (String registro : historial) {
                escritura.write(registro + System.lineSeparator());
            }
        }
    }
}
