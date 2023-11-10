package actividad2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Persona> Personas=new ArrayList<Persona>();
        String menu="Agenda\n\n"+
                    "Elige una opción:\n"+
                    "1.- Nuevo contacto\n"+
                    "2.- Buscar por nombre\n"+
                    "3.- Mostrar todos\n"+
                    "4.- Salir\n";
        int opcion=0;
        while (opcion !=4){
            System.out.println(menu);
            try {
                opcion=sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error en la entrada.");
            } 
            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Introduce el nombre: ");                   
                    String nombre = sc.nextLine();                   
                    System.out.println("Introduce el telefono de "+nombre+":");                    
                    String telefono = sc.next();
                    System.out.println(nombre+" con telefono: "+telefono+" agregado correctamente\n");
                    Persona persona1=new Persona(nombre.toUpperCase(), telefono);
                    Personas.add(persona1);
                    break;
                case 2:
                    System.out.println("Introduce las iniciales para la búsqueda");
                    String iniciales=sc.next().toUpperCase();
                    for (Persona personas : Personas) {
                        if (personas.getNombre().startsWith(iniciales)){
                            System.out.println(personas.getNombre()+" "+personas.getTelefono());
                        }                   
                    }
                    break;
                case 3:
                    System.out.println("Listado completo de contactos");
                    for (Persona personas : Personas) {
                        System.out.println(personas.getNombre()+" "+personas.getTelefono());
                    }                   
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción incorrecta. \n");
                    break;
            }
        }
    sc.close();    
    }
}