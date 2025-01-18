package org.AluraChallenges;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GeneradorDeArchivo generador = new GeneradorDeArchivo();
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("Estas son todas las monedas soportadas:");
        CodigosMoneda codigosMoneda = consulta.consultarCodigos();
        System.out.println(gson.toJson(codigosMoneda.supported_codes()));
        System.out.println("Ingrese el codigo de moneda para ver la tasa de cambio:");
        try{
            String codigo = String.valueOf(lectura.nextLine());
            TasaDeConversion tasaDeConversion = consulta.consultarTasaDeConversion(codigo);
            System.out.println(gson.toJson(tasaDeConversion.conversion_rates()));
            generador.guardarCodigos(codigosMoneda);
            generador.guardarTasaDeConversion(tasaDeConversion);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}