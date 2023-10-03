public class ComplejoTest {
    public static void main(String[] args) {
        Complejo c1=new Complejo();
        Complejo c2=new Complejo();
        c1.asignar(4, 5);
        c2.asignar(5, 4);
        Complejo suma=Complejo.sumar(c1, c2);
        c1.imprimir();
        c2.imprimir();
        suma.imprimir();
    }
}
