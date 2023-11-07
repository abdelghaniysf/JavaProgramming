import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese edad:");
        int edad = scanner.nextInt();
        System.out.println("Ingrese sexo (H para hombre, M para mujer<mayusculas>):");
        char sexo = scanner.next().charAt(0);
        scanner.nextLine(); // Consumir el salto de línea

        Persona persona1 = new Persona(nombre, edad, sexo);

        System.out.println("Ingrese nombre:");
        nombre = scanner.nextLine();
        System.out.println("Ingrese edad:");
        edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese sexo (H para hombre, M para mujer<mayusculas>):");
        sexo=scanner.next().charAt(0);

        Persona persona2 = new Persona(nombre, edad, sexo);

        Persona persona3 = new Persona();
        persona3.setNombre("John");
        persona3.setEdad(30);
        persona3.setSexo(Persona.SEXO_HOMBRE);
        persona3.setPeso(75.5);
        persona3.setAltura(1.75);

        scanner.close();

        // Calcular el IMC y mostrar los datos de cada persona
        System.out.println("Persona 1:");
        int imc1 = persona1.calcularIMC();
        System.out.println(persona1.toString());
        System.out.println("IMC: " + imc1);

        System.out.println("Persona 2:");
        int imc2 = persona2.calcularIMC();
        System.out.println(persona2.toString());
        System.out.println("IMC: " + imc2);

        System.out.println("Persona 3:");
        int imc3 = persona3.calcularIMC();
        System.out.println(persona3.toString());
        System.out.println("IMC: " + imc3);
    }
}
