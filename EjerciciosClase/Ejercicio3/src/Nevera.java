class Nevera extends Electrodomestico {
    private int capacidadFrigorifico;
    private int capacidadCongelador;
    private int sonoridad;

    // Constructor por defecto
    public Nevera() {
        super();
        capacidadFrigorifico = 300;
        capacidadCongelador = 200;
        sonoridad = 50;
    }

    // Constructor con capacidad y atributos heredados
    public Nevera(int capacidadFrigorifico, int capacidadCongelador, int sonoridad, String marca, String modelo,
            double precio, String color, int potenciaWatios, int horasUsoDiarias, int diasUsoAnuales,
            double precioEnergia) {
        super(marca, modelo, precio, color, potenciaWatios, horasUsoDiarias, diasUsoAnuales, precioEnergia);
        this.capacidadFrigorifico = capacidadFrigorifico;
        this.capacidadCongelador = capacidadCongelador;
        this.sonoridad = sonoridad;
    }

    // Método para calcular el consumo energético anual en euros
    @Override
    public double consumoAnual() {
        double consumoAnual = super.consumoAnual();
        if (capacidadFrigorifico > 300 || capacidadCongelador > 200) {
            consumoAnual += 50; // Aplicar tasa adicional
        }
        return consumoAnual;
    }

    // Getters y setters
    public int getCapacidadFrigorifico() {
        return capacidadFrigorifico;
    }

    public void setCapacidadFrigorifico(int capacidadFrigorifico) {
        this.capacidadFrigorifico = capacidadFrigorifico;
    }

    public int getCapacidadCongelador() {
        return capacidadCongelador;
    }

    public void setCapacidadCongelador(int capacidadCongelador) {
        this.capacidadCongelador = capacidadCongelador;
    }

    public int getSonoridad() {
        return sonoridad;
    }

    public void setSonoridad(int sonoridad) {
        this.sonoridad = sonoridad;
    }

    // Método toString
    @Override
    public String toString() {
        return "Nevera [capacidadFrigorifico=" + capacidadFrigorifico + ", capacidadCongelador=" + capacidadCongelador
                + ", sonoridad=" + sonoridad + ", " + super.toString() + "]";
    }
}
