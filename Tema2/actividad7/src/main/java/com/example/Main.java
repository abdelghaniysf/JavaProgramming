package com.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Leer el archivo JSON y convertirlo a la clase AbdelghaniCV
            AbdelghaniCV miCV = AbdelghaniCV.fromJsonFile("AbdelghaniCV.json");

            // Mostrar el CV por pantalla
            System.out.println("Currículum antes de la modificación:");
            System.out.println(miCV);

            // Modificar el nivel de inglés de B1 a B2
            if (miCV.getIdiomas() != null) {
                for (AbdelghaniCV.Idioma idioma : miCV.getIdiomas()) {
                    if ("Inglés".equals(idioma.getIdioma())) {
                        idioma.setNivel("B2");
                        break;
                    }
                }
            }

            // Volver a volcar el CV al archivo JSON
            miCV.toJsonFile("AbdelghaniCV.json");

            // Mostrar el CV modificado por pantalla
            System.out.println("\nCurrículum después de la modificación:");
            System.out.println(miCV);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
