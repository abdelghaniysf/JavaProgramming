package actividad6;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static ArrayList<ClienteSer> listaClientes;
    private static File fichero;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        listaClientes = new ArrayList<>();
        String nombreFichero = "clientes.dat";
        String menu = "1.- Alta cliente\n" +
                "2.- Baja cliente\n" +
                "3.- Listar clientes por saldo\n" +
                "4.- Saldo medio clientes\n" +
                "5.- Salir";
        fichero = new File(nombreFichero);

        try {
            cargarClientes();
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
                sc.nextLine(); 

                switch (opcion) {
                    case 1:
                        altaCliente();
                        break;
                    case 2:
                        bajaCliente();
                        break;
                    case 3:
                        listarClientesPorSaldo();
                        break;
                    case 4:
                        saldoMedioClientes();
                        break;
                    case 5:
                        try {
                            guardarClientes();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Número fuera de rango de opciones.");
                }
            } while (opcion != 5);

        }finally {
            sc.close();
        }
    }

    private static void cargarClientes() throws IOException, ClassNotFoundException {
        if (fichero.exists() && fichero.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                listaClientes = (ArrayList<ClienteSer>) ois.readObject();
            }
        }
    }

    private static void guardarClientes() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(listaClientes);
        }
        
    }

    private static void altaCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.next();
        System.out.print("Fecha de nacimiento: ");
        String fechaNacimiento = sc.next();
        System.out.print("Saldo: ");
        double saldo = sc.nextDouble();

        ClienteSer cliente = new ClienteSer(nombre, dni, fechaNacimiento, saldo);
        listaClientes.add(cliente);
        try {
            guardarClientes();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void bajaCliente() {
        System.out.println("DNI a dar de baja: ");
        String dniEntrada = sc.next();
        Iterator<ClienteSer> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            ClienteSer cli = iterator.next();
            if (cli.getDni().equals(dniEntrada)) {
                iterator.remove();
                break;
            }
        }
    }

    private static void listarClientesPorSaldo() {
        Collections.sort(listaClientes);
        for (ClienteSer cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    private static void saldoMedioClientes() {
        double mediaSaldo = listaClientes.stream().mapToDouble(ClienteSer::getSaldo).average().orElse(0.0);
        System.out.println("El saldo medio es: " + mediaSaldo);
    }
}


