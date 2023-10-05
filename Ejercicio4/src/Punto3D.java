public class Punto3D extends Punto {
    private int z;

    public Punto3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public double distancia(Punto3D otroPunto) {
        int dx = this.getX() - otroPunto.getX();
        int dy = this.getY() - otroPunto.getY();
        int dz = this.z - otroPunto.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public boolean equals(Punto3D otroPunto) {
        return super.equals(otroPunto) && z == otroPunto.z;
    }
}
