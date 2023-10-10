class Televisor extends Electrodomestico {
    private int resolucion;

    // Constructor por defecto
    public Televisor() {
        super();
        resolucion = 50;
    }

    // Constructor con resolución y atributos heredados
    public Televisor(int resolucion, String marca, String modelo, double precio, String color, int potenciaWatios,
            int horasUsoDiarias, int diasUsoAnuales, double precioEnergia) {
        super(marca, modelo, precio, color, potenciaWatios, horasUsoDiarias, diasUsoAnuales, precioEnergia);
        this.resolucion = resolucion;
    }

    // Método para calcular el consumo energético anual en euros
    @Override
    public double consumoAnual() {
        double consumoAnual = super.consumoAnual();
        if (resolucion > 50) {
            consumoAnual += 30; // Aplicar tasa adicional
        }
        return consumoAnual;
    }

    // Getters y setters
    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    // Método toString
    @Override
    public String toString() {
        return "Televisor [resolucion=" + resolucion + ", " + super.toString() + "]";
    }
}
