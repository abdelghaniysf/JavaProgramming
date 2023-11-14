package actividad3;

public class Temperatura {
    private String ciudad;
    private String fecha;
    private int temperaturaMaxima;
    private int temperaturaMinima;
    
    

    public Temperatura(String ciudad, String fecha, int temperaturaMaxima, int temperaturaMinima) {
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
    }



    public String getCiudad() {
        return ciudad;
    }



    public String getFecha() {
        return fecha;
    }



    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }



    public int getTemperaturaMinima() {
        return temperaturaMinima;
    }



    @Override
    public String toString() {
        return ciudad + "       " + fecha + "     " + temperaturaMaxima
                + "                      " + temperaturaMinima;
    }
    
}
