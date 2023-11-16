package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AbdelghaniCV {
    private String nombre;
    private int edad;
    private Educacion[] educacion;
    private ExperienciaLaboral[] experienciaLaboral;
    private String[] habilidades;
    private Idioma[] idiomas;

    // Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Educacion[] getEducacion() {
        return educacion;
    }

    public void setEducacion(Educacion[] educacion) {
        this.educacion = educacion;
    }

    public ExperienciaLaboral[] getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(ExperienciaLaboral[] experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public Idioma[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idioma[] idiomas) {
        this.idiomas = idiomas;
    }

    // Additional constructors, if needed

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nEducación: " + arrayToString(educacion) +
                "\nExperiencia Laboral: " + arrayToString(experienciaLaboral) +
                "\nHabilidades: " + arrayToString(habilidades) +
                "\nIdiomas: " + arrayToString(idiomas);
    }

    private <T> String arrayToString(T[] array) {
        if (array == null) return "N/A";
        StringBuilder result = new StringBuilder("[");
        for (T item : array) {
            result.append(item).append(", ");
        }
        if (array.length > 0) {
            result.setLength(result.length() - 2); // Remove the trailing comma and space
        }
        result.append("]");
        return result.toString();
    }

    public static AbdelghaniCV fromJsonFile(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, AbdelghaniCV.class);
        }
    }

    public void toJsonFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        }
    }

    // POJO classes for nested structures
    static class Educacion {
        private String titulo;
        private String institucion;
        private int anio;

        // Getters and setters
    }

    static class ExperienciaLaboral {
        private String puesto;
        private String empresa;
        private int anioInicio;
        private Integer anioFin; // Integer allows null values

        // Getters and setters
    }

    static class Idioma {
        private String idioma;
        private String nivel;

        // Getters and setters

        public String getIdioma() {
            return idioma;
        }

        public void setIdioma(String idioma) {
            this.idioma = idioma;
        }

        public String getNivel() {
            return nivel;
        }

        public void setNivel(String nivel) {
            this.nivel = nivel;
        }

        @Override
        public String toString() {
            return "Idioma{" +
                    "idioma='" + idioma + '\'' +
                    ", nivel='" + nivel + '\'' +
                    '}';
        }
    }
}
