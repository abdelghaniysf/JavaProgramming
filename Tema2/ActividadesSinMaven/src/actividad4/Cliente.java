package actividad4;

public class Cliente implements Comparable<Cliente>{
    private String nombre;
    private String dni;
    private String fechaNacimiento;
    private double saldo;

    public Cliente(String nombre, String dni, String fechaNacimiento, double saldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
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



    public double getSaldo() {
        return saldo;
    }



    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", saldo="
                + saldo + "]";
    }

    @Override
    public int compareTo(Cliente c) {
        return (int) (c.getSaldo()-this.saldo);
    }

    
    
}