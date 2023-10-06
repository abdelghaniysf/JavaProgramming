public class CuentaTest {
    public static void main(String[] args) {
        // Crear dos cuentas con números de cuenta válidos
        Cuenta cuenta1 = new Cuenta("12345678A", "Juan Pérez", "ES9121000418450200051332", 5000);
        Cuenta cuenta2 = new Cuenta("98765432B", "María López", "ES5601821612345678901234", 3000);

        // Mostrar saldos iniciales
        System.out.println("Saldo inicial de cuenta1:");
        cuenta1.mostrarSaldo();
        System.out.println("Saldo inicial de cuenta2:");
        cuenta2.mostrarSaldo();

        // Realizar operaciones en las cuentas
        cuenta1.ingresarDinero(2000);
        cuenta1.sacarDinero(1500);
        cuenta2.cambioTitular("Carlos Sánchez");

        // Mostrar saldos después de operaciones
        System.out.println("Saldo de cuenta1 después de operaciones:");
        cuenta1.mostrarSaldo();
        System.out.println("Saldo de cuenta2 después de cambio de titular:");
        cuenta2.mostrarSaldo();

        // Validación de cuentas bancarias
        System.out.println("Validación de cuentas bancarias:");
        System.out.println("Cuenta1 es válida: " + cuenta1.validarCuentaBancaria());
        System.out.println("Cuenta2 es válida: " + cuenta2.validarCuentaBancaria());
    }
}
