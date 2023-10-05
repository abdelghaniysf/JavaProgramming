public class Portatil extends Ordenador {
    private double peso;

    public Portatil(String codigo, int ram, String cpu, double precio, double peso) {
        super(codigo, ram, cpu, precio);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String getCaracteristicas() {
        return super.getCaracteristicas() + ", Peso: " + peso + " kg";
    }
}
