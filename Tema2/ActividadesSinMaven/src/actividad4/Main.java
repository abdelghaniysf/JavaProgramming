package actividad4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static ArrayList<Cliente> listaClientes;
    private static File fichero;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        listaClientes = new ArrayList<>();
        String nombreFichero = "clientes.txt";
        String menu = "1.- Alta cliente\n" +
                "2.- Baja cliente\n" +
                "3.- Listar clientes por saldo\n" +
                "4.- Saldo medio clientes\n" +
                "5.- Salir";
        fichero = new File(nombreFichero);

        try {
            int opcion;
            do {
                System.out.println(menu);
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // Consume the newline character

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
                        break;
                    default:
                        System.out.println("Número fuera de rango de opciones.");
                }
            } while (opcion != 5);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static void altaCliente() throws IOException {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.next();
        System.out.print("Fecha de nacimiento: ");
        String fechaNacimiento = sc.next();
        System.out.print("Saldo: ");
        double saldo = sc.nextDouble();

        Cliente cliente = new Cliente(nombre, dni, fechaNacimiento, saldo);
        listaClientes.add(cliente);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero, true))) {
            writer.write(cliente.toString() + "\n");
        }
    }

    private static void bajaCliente() throws IOException {
        System.out.println("DNI a dar de baja: ");
        String dniEntrada = sc.next();

        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cli = iterator.next();
            if (cli.getDni().equals(dniEntrada)) {
                iterator.remove();
                actualizarArchivo();
            }
        }
    }

    private static void actualizarArchivo() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero))) {
            for (Cliente cliente : listaClientes) {
                writer.write(cliente.toString() + "\n");
            }
        }
    }

    private static void listarClientesPorSaldo() {
        Collections.sort(listaClientes);
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    private static void saldoMedioClientes() {
        double mediaSaldo = listaClientes.stream().mapToDouble(Cliente::getSaldo).average().orElse(0.0);
        System.out.println("El saldo medio es: " + mediaSaldo);
    }
}
