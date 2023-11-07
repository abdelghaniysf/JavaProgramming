public class OrdenadorTestAbdel {
    public static void main(String[] args) {
        Sobremesa sobremesa = new Sobremesa("S001", 16, "Intel i7", 899.99, "Torre ATX");

        Portatil portatil = new Portatil("P001", 8, "AMD Ryzen 5", 799.99, 2.5);

        System.out.println("Ordenador de Sobremesa:");
        System.out.println(sobremesa.getCaracteristicas());

        System.out.println("Portátil:");
        System.out.println(portatil.getCaracteristicas());
    }
}
