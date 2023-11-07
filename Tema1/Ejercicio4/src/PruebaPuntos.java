public class PruebaPuntos {
    public static void main(String[] args) {
        Punto punto1 = new Punto(1, 2);
        Punto punto2 = new Punto(3, 4);

        System.out.println("Distancia entre punto1 y punto2: " + punto1.distancia(punto2));
        System.out.println("punto1 es igual a punto2: " + punto1.equals(punto2));
        
        Punto3D punto3D1 = new Punto3D(1, 2, 3);
        Punto3D punto3D2 = new Punto3D(3, 4, 5);

        System.out.println("\nDistancia entre punto3D1 y punto3D2: " + punto3D1.distancia(punto3D2));
        System.out.println("punto3D1 es igual a punto3D2: " + punto3D1.equals(punto3D2));
        
        Suceso suceso1 = new Suceso(1, 2, 3, "Evento 1", "2023-10-05 12:00");
        Suceso suceso2 = new Suceso(1, 2, 3, "Evento 1", "2023-10-05 12:00");

        System.out.println("\nSuceso 1:\n" + suceso1.toString());
        System.out.println("Suceso 2:\n" + suceso2.toString());
        System.out.println("suceso1 es igual a suceso2: " + suceso1.equals(suceso2));
    }
}
çç