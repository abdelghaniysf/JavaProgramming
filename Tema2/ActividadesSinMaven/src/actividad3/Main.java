package actividad3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Temperatura> ciudades = new ArrayList<Temperatura>();

        String nombreFichero="meteo.txt";
        File fichero= new File(nombreFichero);
        FileWriter fw;
        
        String menu="\n1.- Registrar nueva temperatura\n"+
                    "2.- Mostrar historial de registros por ciudad\n"+
                    "3.- Mostrar media de temperatura por ciudad\n"+
                    "4.- Salir\n";

        int opcion=0;
        while (opcion !=4){
            System.out.println(menu);
            System.out.println("Eliga una opción");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Introduzca la ciudad");
                    String ciudad = sc.nextLine();
                    System.out.println("Introduzca la fecha");
                    String fecha=sc.next();
                    System.out.println("Introduzca la temperatura máxima");
                    int temperaturaMaxima=sc.nextInt();
                    System.out.println("Introduzca la temperatura mínima");
                    int temperaturaMinima=sc.nextInt();
                    Temperatura temperatura=new Temperatura(ciudad, fecha, temperaturaMaxima, temperaturaMinima);
                    ciudades.add(temperatura);
                    try {
                        fw= new FileWriter(fichero, true);
                        fw.write(temperatura.toString());
                        fw.write("\n");
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Introduzca el nombre de la ciudad");
                    ciudad=sc.nextLine();
                    System.out.println("CIUDAD       FECHA          Temperatura maxima      Temperatura minimo");
                    for (Temperatura temperaturas : ciudades) {
                        if (temperaturas.getCiudad().equals(ciudad)){
                            System.out.println(temperaturas);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduzca el nombre de la ciudad");
                    ciudad=sc.nextLine();
                    double mediaMaxima=0;
                    double mediaMinima=0;
                    int n=0;
                    for (Temperatura temp : ciudades) {
                        if (temp.getCiudad().equals(ciudad)){
                            n++;
                            mediaMaxima += temp.getTemperaturaMaxima();
                            mediaMinima += temp.getTemperaturaMinima();
                        }
                    }
                    System.out.println("Temperatura máxima media: "+mediaMaxima/n);
                    System.out.println("Temperatura mínima minima: "+mediaMinima/n);
                    System.out.println("Temperatura media: "+(mediaMaxima/n+mediaMinima/n)/2);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Entrada incorrecta");
                    break;
            }
        }      
    }
}