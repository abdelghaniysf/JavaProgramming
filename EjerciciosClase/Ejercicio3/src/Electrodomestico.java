class Electrodomestico {
    private String marca;
    private String modelo;
    private double precio;
    private String color;
    private int potenciaWatios;
    private int horasUsoDiarias;
    private int diasUsoAnuales;
    private double precioEnergia;

    // Constructor por defecto
    public Electrodomestico() {
        marca = "Bosch";
        modelo = "7200";
        precio = 400.0;
        color = "gris";
        potenciaWatios = 2300;
        horasUsoDiarias = 1;
        diasUsoAnuales = 3 * 365;
        precioEnergia = 0.40397;
    }

    // Constructor con marca, modelo y precio
    public Electrodomestico(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        // Resto de atributos por defecto
        color = "gris";
        potenciaWatios = 2300;
        horasUsoDiarias = 1;
        diasUsoAnuales = 3 * 365;
        precioEnergia = 0.40397;
    }

    // Constructor con todos los atributos como parámetro
    public Electrodomestico(String marca, String modelo, double precio, String color, int potenciaWatios,
            int horasUsoDiarias, int diasUsoAnuales, double precioEnergia) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.color = color;
        this.potenciaWatios = potenciaWatios;
        this.horasUsoDiarias = horasUsoDiarias;
        this.diasUsoAnuales = diasUsoAnuales;
        this.precioEnergia = precioEnergia;
    }

    // Método para calcular el consumo energético anual en euros
    public double consumoAnual() {
        double consumoDiario = (potenciaWatios * horasUsoDiarias * precioEnergia) / 1000;
        double consumoAnual = consumoDiario * diasUsoAnuales;
        return consumoAnual;
    }

    // Método toString para mostrar la información del objeto
    @Override
    public String toString() {
        return "Electrodomestico [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", color=" + color
                + ", potenciaWatios=" + potenciaWatios + ", horasUsoDiarias=" + horasUsoDiarias + ", diasUsoAnuales="
                + diasUsoAnuales + ", precioEnergia=" + precioEnergia + "]";
    }

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPotenciaWatios() {
        return potenciaWatios;
    }

    public void setPotenciaWatios(int potenciaWatios) {
        this.potenciaWatios = potenciaWatios;
    }

    public int getHorasUsoDiarias() {
        return horasUsoDiarias;
    }

    public void setHorasUsoDiarias(int horasUsoDiarias) {
        this.horasUsoDiarias = horasUsoDiarias;
    }

    public int getDiasUsoAnuales() {
        return diasUsoAnuales;
    }

    public void setDiasUsoAnuales(int diasUsoAnuales) {
        this.diasUsoAnuales = diasUsoAnuales;
    }

    public double getPrecioEnergia() {
        return precioEnergia;
    }

    public void setPrecioEnergia(double precioEnergia) {
        this.precioEnergia = precioEnergia;
    }
}

