package parking;

public class ParkingVehiculo implements Parking {
    private static final double PRECIO_POR_MINUTO = 0.0425;
    private static final int MAX_PLAZAS = 100;
    private String direccion;
    private int plazasOcupadas;

    public ParkingVehiculo(String direccion) {
        this.direccion = direccion;
        this.plazasOcupadas = 0;
    }

    @Override
    public boolean hayPlaza() {
        return plazasOcupadas < MAX_PLAZAS;
    }

    @Override
    public void aparcaCoche(Vehiculo coche) {
        if (hayPlaza()) {
            plazasOcupadas++;
            System.out.println("El vehículo con matrícula " + coche.getMatricula() + " ha sido aparcado en " + direccion);
        } else {
            System.out.println("No hay plazas disponibles en " + direccion + ". No se pudo aparcar.");
        }
    }

    @Override
    public void sacaCoche(Vehiculo coche) {
        plazasOcupadas--;
        System.out.println("El vehículo con matrícula " + coche.getMatricula() + " ha salido de " + direccion);
    }

    @Override
    public double getFactura(Vehiculo coche) {
        long minutosEstacionado = coche.getMinutosEstacionado();
        return minutosEstacionado * PRECIO_POR_MINUTO;
    }
}
