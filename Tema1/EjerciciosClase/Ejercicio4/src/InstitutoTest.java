public class InstitutoTest {
    public static void main(String[] args) {
        // Crear dos aulas en el instituto
        Aula aula1 = new Aula(Constantes.AULA_2_6);
        Aula aula2 = new Aula(Constantes.AULA_B5);

        // Asignar profesores y alumnos a las aulas
        Profesor profesor1 = new Profesor(Constantes.PROFESORES[0], "Programación");
        Profesor profesor2 = new Profesor(Constantes.PROFESOR_JUAN, "Base de datos");
        Alumno alumno1 = new Alumno("Estudiante1", 18, aula1,5);
        Alumno alumno2 = new Alumno("Estudiante2", 19, aula1);
        Alumno alumno3 = new Alumno("Estudiante3", 20, aula2);

        aula1.agregarProfesor(profesor1);
        aula1.agregarProfesor(profesor2);
        aula1.agregarAlumno(alumno1);
        aula1.agregarAlumno(alumno2);
        aula2.agregarAlumno(alumno3);

        // Imprimir información sobre las aulas
        System.out.println("Información del aula " + aula1.getNombre() + ":");
        System.out.println("Profesores asignados: " + aula1.getProfesores());
        System.out.println("Alumnos asignados: " + aula1.getAlumnos());
        System.out.println("Materias que se imparten: " + aula1.getMaterias());

        System.out.println("\nInformación del aula " + aula2.getNombre() + ":");
        System.out.println("Profesores asignados: " + aula2.getProfesores());
        System.out.println("Alumnos asignados: " + aula2.getAlumnos());
        System.out.println("Materias que se imparten: " + aula2.getMaterias());
    }
}
