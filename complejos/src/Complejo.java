public class Complejo {
    private double parteReal;
    private double parteImaginaria;

    public Complejo() {
    }

    public void asignar(double x, double y){
        this.parteReal=x;
        this.parteImaginaria=y;
    }

    public double getParteReal() {
        return parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public static Complejo sumar(Complejo c1,Complejo c2){
        double parteReal=c1.getParteReal()+c2.getParteReal();
        double parteImaginaria=c1.getParteImaginaria()+c2.getParteImaginaria();
        Complejo complejo=new Complejo();
        complejo.asignar(parteReal, parteImaginaria);
        return complejo;
    }

    public void imprimir(){
        System.out.println("("+this.parteReal+","+this.parteImaginaria+")");
    }
}
