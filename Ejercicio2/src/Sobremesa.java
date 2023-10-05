public class Sobremesa extends Ordenador {
    private String tipoTorre;

    public Sobremesa(String codigo, int ram, String cpu, double precio, String tipoTorre) {
        super(codigo, ram, cpu, precio);
        this.tipoTorre = tipoTorre;
    }

    public String getTipoTorre() {
        return tipoTorre;
    }

    @Override
    public String getCaracteristicas() {
        return super.getCaracteristicas() + ", Tipo de Torre: " + tipoTorre;
    }
}
