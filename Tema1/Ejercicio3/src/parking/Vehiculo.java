package parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Vehiculo {
    private String matricula;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.fechaInicio = LocalDateTime.now();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public long getMinutosEstacionado() {
        return ChronoUnit.MINUTES.between(fechaInicio, fechaFin);
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Fecha Inicio: " + fechaInicio + ", Fecha Fin: " + fechaFin;
    }
}
