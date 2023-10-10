import java.util.Random;

public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    public static final char SEXO_HOMBRE = 'H';
    public static final char SEXO_MUJER = 'M';

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = SEXO_HOMBRE;
        this.peso = 0;
        this.altura = 0;
        generarDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = validarSexo(sexo) ? sexo : SEXO_HOMBRE;
        this.peso = 0;
        this.altura = 0;
        generarDNI();
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = validarSexo(sexo) ? sexo : SEXO_HOMBRE;
        this.peso = peso;
        this.altura = altura;
        this.DNI = validarDNI(DNI) ? DNI : generarDNI();
    }

    public int calcularIMC() {
        double imc = peso / (altura * altura);
        if (imc < 18.5) {
            return -1; // Bajo peso
        } else if (imc >= 18.5 && imc < 24.9) {
            return 0; // Peso normal
        } else {
            return 1; // Sobrepeso
        }
    }

    private boolean validarDNI(String dni) {
        // Implementa la lógica de validación del DNI aquí (omitiendo por simplicidad)
        return true; // Por defecto, siempre válido en este ejemplo
    }

    private boolean validarSexo(char sexo) {
        return sexo == SEXO_HOMBRE || sexo == SEXO_MUJER;
    }

    private String generarDNI() {
        Random rand = new Random();
        StringBuilder dni = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            dni.append(rand.nextInt(10));
        }
        // Calcula la letra del DNI
        int numeroDNI = Integer.parseInt(dni.toString());
        char letra = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numeroDNI % 23);
        DNI = dni + String.valueOf(letra);
        return DNI;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI + "\nSexo: " + sexo + "\nPeso: " + peso
                + "\nAltura: " + altura + "\n";
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        if (validarDNI(DNI)) {
            this.DNI = DNI;
        }
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (validarSexo(sexo)) {
            this.sexo = sexo;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
