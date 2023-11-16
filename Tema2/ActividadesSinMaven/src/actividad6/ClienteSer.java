package actividad6;

import java.io.Serializable;

public class ClienteSer implements Serializable, Comparable<ClienteSer>{
    private String nombre;
    private String dni;
    private String fechaNacimiento;
    private Double saldo;

    public ClienteSer(String nombreCliente, String dniCliente, String fechaNacimiento, Double saldoCliente) {
        this.nombre = nombreCliente;
        this.dni = dniCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldoCliente;   
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "ClienteSer [nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", saldo="
                + saldo + "]";
    }

    @Override
    public int compareTo(ClienteSer c) {  
        return (int) (c.getSaldo()-this.getSaldo());
    }
}