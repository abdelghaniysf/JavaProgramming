public class Suceso extends Punto3D {
    private String descripcion;
    private String tiempo;

    public Suceso(int x, int y, int z, String descripcion, String tiempo) {
        super(x, y, z);
        this.descripcion = descripcion;
        this.tiempo = tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public boolean equals(Suceso otroSuceso) {
        return super.equals(otroSuceso) && descripcion.equals(otroSuceso.descripcion) && tiempo.equals(otroSuceso.tiempo);
    }

    @Override
    public String toString() {
        return super.toString()+"Suceso [descripcion=" + descripcion + ", tiempo=" + tiempo + "]";
    }
    
}
