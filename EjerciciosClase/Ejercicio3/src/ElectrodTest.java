import java.util.ArrayList;

public class ElectrodTest {
    public static void main(String[] args) {
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();

        // Crear 4 electrodomésticos con valores personalizados
        electrodomesticos.add(new Electrodomestico("Samsung", "1234", 600.0, "negro", 2000, 2, 4 * 365, 0.35));
        electrodomesticos.add(new Nevera(400, 250, 45, "LG", "ABC", 800.0, "blanco", 400, 3, 5 * 365, 0.30));
        electrodomesticos.add(new Televisor(60, "Sony", "XYZ", 700.0, "plateado", 150, 6, 6 * 365, 0.25));
        electrodomesticos.add(new Televisor(42, "Panasonic", "PQR", 400.0, "negro", 120, 4, 7 * 365, 0.20));

        // Mostrar el consumo anual de cada electrodoméstico
        for (Electrodomestico electrodomestico : electrodomesticos) {
            System.out.println("Consumo anual de " + electrodomestico.toString() + ": " + electrodomestico.consumoAnual() + "€");
        }

        // Calcular la suma total de consumo anual de todos los electrodomésticos
        double sumaTotal = 0;
        for (Electrodomestico electrodomestico : electrodomesticos) {
            sumaTotal += electrodomestico.consumoAnual();
        }
        System.out.println("Suma total de consumo anual de todos los electrodomésticos: " + sumaTotal + "€");
    }
}
