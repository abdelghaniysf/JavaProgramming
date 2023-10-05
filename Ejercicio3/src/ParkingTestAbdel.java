import java.time.LocalDateTime;
import parking.*;

public class ParkingTestAbdel {
    public static void main(String[] args) {
        Parking parking = new ParkingVehiculo("Mi Parking");
        
        Vehiculo vehiculo1 = new Vehiculo("ABC123");
        Vehiculo vehiculo2 = new Vehiculo("XYZ789");
        Vehiculo vehiculo3 = new Vehiculo("DEF456");
        Vehiculo vehiculo4 = new Vehiculo("GHI789");
        Vehiculo vehiculo5 = new Vehiculo("JKL012");
        
        if (parking.hayPlaza()) {
            parking.aparcaCoche(vehiculo1);
            parking.aparcaCoche(vehiculo2);
            parking.aparcaCoche(vehiculo3);
            parking.aparcaCoche(vehiculo4);
            parking.aparcaCoche(vehiculo5);
        }
        
        vehiculo1.setFechaFin(LocalDateTime.now().plusMinutes(120));
        vehiculo2.setFechaFin(LocalDateTime.now().plusMinutes(90));
        vehiculo3.setFechaFin(LocalDateTime.now().plusMinutes(150));
        vehiculo4.setFechaFin(LocalDateTime.now().plusMinutes(60));
        vehiculo5.setFechaFin(LocalDateTime.now().plusMinutes(180));
        
        parking.sacaCoche(vehiculo3);
        
        System.out.println("Factura vehículo 1: $" + parking.getFactura(vehiculo1));
        System.out.println("Factura vehículo 2: $" + parking.getFactura(vehiculo2));
        System.out.println("Factura vehículo 3: $" + parking.getFactura(vehiculo3));
        System.out.println("Factura vehículo 4: $" + parking.getFactura(vehiculo4));
        System.out.println("Factura vehículo 5: $" + parking.getFactura(vehiculo5));
    }
}
