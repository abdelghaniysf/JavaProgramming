package actividad5;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static List<Registro> registros;
    private static File fichero;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        registros = new ArrayList<>();
        String nombreFichero = "meteo.dat";
        String menu = "1- Registrar nueva temperatura\n" +
                "2- Mostrar historial de registros por ciudad\n" +
                "3- Mostrar media de temperatura por ciudad\n" +
                "4- Salir";
        fichero = new File(nombreFichero);

        try {
            cargarRegistros();
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            int opcion;
            do {
                System.out.println(menu);
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch (opcion) {
                    case 1:
                        registrarTemperatura();
                        break;
                    case 2:
                        mostrarHistorial();
                        break;
                    case 3:
                        mostrarMediaTemperatura();
                        break;
                    case 4:
                        guardarRegistros();
                        break;
                    default:
                        System.out.println("Número fuera de rango de opciones.");
                }
            } while (opcion != 4);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            sc.close();
        }
    }

    private static void cargarRegistros() throws IOException, ClassNotFoundException {
        if (fichero.exists() && fichero.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                registros = (List<Registro>) ois.readObject();
            }
        }
    }

    private static void guardarRegistros() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(registros);
        }
    }

    private static void registrarTemperatura() {
        System.out.println("Introduzca la ciudad");
        String ciudad = sc.nextLine();
        System.out.println("Introduzca la fecha");
        String fecha = sc.next();
        System.out.println("Introduzca la temperatura máxima");
        int temperaturaMaxima = sc.nextInt();
        System.out.println("Introduzca la temperatura mínima");
        int temperaturaMinima = sc.nextInt();
        Registro registro = new Registro(ciudad, fecha, temperaturaMaxima, temperaturaMinima);
        registros.add(registro);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(registros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarHistorial() {
        System.out.println("Introduzca el nombre de la ciudad");
        String ciudad = sc.nextLine();
        System.out.println("CIUDAD       FECHA          Temperatura máxima      Temperatura mínima");
        for (Registro registro : registros) {
            if (registro.getCiudad().equals(ciudad)) {
                System.out.println(registro);
            }
        }
    }

    private static void mostrarMediaTemperatura() {
        System.out.println("Introduzca el nombre de la ciudad");
        String ciudad = sc.nextLine();
        double mediaMaxima = 0;
        double mediaMinima = 0;
        int n = 0;
        for (Registro registro : registros) {
            if (registro.getCiudad().equals(ciudad)) {
                n++;
                mediaMaxima += registro.getTemperaturaMaxima();
                mediaMinima += registro.getTemperaturaMinima();
            }
        }
        System.out.println("Temperatura máxima media: " + (mediaMaxima / n));
        System.out.println("Temperatura mínima minima: " + (mediaMinima / n));
        System.out.println("Temperatura media: " + ((mediaMaxima / n + mediaMinima / n) / 2));
    }
}
