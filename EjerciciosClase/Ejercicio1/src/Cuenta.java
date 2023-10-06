public class Cuenta {
    // Constantes para importe máximo a retirar e ingresar
    private static final double MAX_RETIRAR = 3000;
    private static final double MAX_INGRESAR = 6000;
    
    private String dni;
    private String nombre;
    private String numCuenta;
    private double saldo;

    public Cuenta(String dni, String nombre, String numCuenta, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public void ingresarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a ingresar debe ser mayor que cero.");
            return;
        }
        if (cantidad > MAX_INGRESAR) {
            System.out.println("Se ha superado el importe máximo a ingresar en un mismo día.");
            return;
        }
        saldo += cantidad;
        System.out.print("Se han ingresado " + cantidad + " euros en la cuenta. Saldo actual: ");
        mostrarSaldo();
    }

    public void sacarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser mayor que cero.");
            return;
        }
        if (cantidad > MAX_RETIRAR) {
            System.out.println("Se ha superado el importe máximo a retirar en un mismo día.");
            return;
        }
        if (saldo < cantidad) {
            System.out.println("Fondos insuficientes.");
            return;
        }
        saldo -= cantidad;
        System.out.print("Se han retirado " + cantidad + " euros de la cuenta. Saldo actual: ");
        mostrarSaldo();
    }

    public void mostrarSaldo() {
        System.out.println(saldo + "$");
    }

    public void cambioTitular(String nuevoNombre) {
        nombre = nuevoNombre;
        System.out.println("El titular de la cuenta ha sido cambiado a " + nuevoNombre + ".");
    }

    public boolean validarCuentaBancaria() {
        // Algoritmo de validación de cuenta bancaria (formato IBAN)
        String iban = numCuenta.replaceAll(" ", "");
        if (iban.length() != 24) {
            return false;
        }
        if (!iban.matches("[0-9A-Z]+")) {
            return false;
        }

        iban = iban.substring(4) + iban.substring(0, 4);
        String ibanChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int remainder = 0;
        for (char c : iban.toCharArray()) {
            int value = ibanChars.indexOf(c);
            remainder = (remainder * 10 + value) % 97;
        }

        return remainder == 1;
    }
}
