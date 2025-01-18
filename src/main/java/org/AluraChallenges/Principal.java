package org.AluraChallenges;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner lectura = new Scanner(System.in);

        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        ConversorDeMonedas conversor = new ConversorDeMonedas();
        HistorialDeConversiones historialDeConversiones = new HistorialDeConversiones(); // NUEVO

        while (true) {
            System.out.println("\n******* Conversor de Monedas *******");

            // Mostrar opciones del menú
            System.out.println("1. Convertir monedas");
            System.out.println("2. Salir");
            System.out.println("3. Ver historial de conversiones"); // NUEVA OPCIÓN
            System.out.print("Ingrese su opción: ");
            int opcion = lectura.nextInt();

            if (opcion == 1) {
                // Preguntar las monedas y el monto
                System.out.print("Ingrese la moneda de origen (código): ");
                String codigoOrigen = lectura.next().toUpperCase();

                System.out.print("Ingrese la moneda de destino (código): ");
                String codigoDestino = lectura.next().toUpperCase();

                System.out.print("Ingrese el monto a convertir: ");
                double monto = lectura.nextDouble();

                // Consultar las tasas de la moneda origen
                TasaDeConversion tasaDeConversion = consultaMoneda.consultarTasaDeConversion(codigoOrigen);
                Double tasaDestino = tasaDeConversion.conversion_rates().get(codigoDestino);

                if (tasaDestino != null) {
                    // Calcular la conversión y mostrar el resultado
                    double resultado = conversor.convertir(monto, tasaDestino);
                    System.out.printf("El monto convertido es: %.2f %s%n", resultado, codigoDestino);

                    // Registrar la conversión en el historial
                    historialDeConversiones.agregarConversion(codigoOrigen, codigoDestino, monto, resultado); // NUEVO
                } else {
                    System.out.println("Error: Tasa de conversión no encontrada.");
                }

            } else if (opcion == 2) {
                System.out.println("Saliendo del programa...");

                // Guardar el historial en el archivo
                try {
                    historialDeConversiones.guardarHistorialEnArchivo(); // NUEVO
                } catch (IOException e) {
                    System.out.println("Error al guardar el historial en archivo: " + e.getMessage());
                }

                break;
            } else if (opcion == 3) { // NUEVO
                // Mostrar historial de conversiones
                historialDeConversiones.mostrarHistorial();
            } else {
                System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }

    // Metodo para mostrar los códigos en columnas
    private static void mostrarCodigosPorColumnas(List<List<String>> supportedCodes) {
        final int COLUMNAS = 4; // Número de columnas deseadas
        int contador = 0;

        for (List<String> codigo : supportedCodes) {
            System.out.printf("%-10s", codigo.get(0)); // Mostrar el código de moneda
            contador++;

            // Si se alcanza el número de columnas, hacer un salto de línea
            if (contador % COLUMNAS == 0) {
                System.out.println();
            }
        }

        // Saltar línea final en caso de ser necesario
        if (contador % COLUMNAS != 0) {
            System.out.println();
        }
    }
}