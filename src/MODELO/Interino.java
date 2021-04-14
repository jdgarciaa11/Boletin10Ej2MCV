package MODELO;

import MODELO.Enums.CargoInterino;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Interino extends Profesor{
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String instituto;
    private CargoInterino cargo;
    private LocalDate fechaActual = LocalDate.now();

    public Interino(String nombre, String apellidos, int edad, LocalDate fechaInicio, LocalDate fechaFinal, String instituto, CargoInterino cargo) {
        super(nombre, apellidos, edad);
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.instituto = instituto;
        this.cargo = cargo;
    }

    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public CargoInterino getCargo() {
        return cargo;
    }

    public void setCargo(CargoInterino cargo) {
        this.cargo = cargo;
    }

    //Funcion para saber cuanto dura su interinidad
    public long duracionInternidad(){
        return ChronoUnit.DAYS.between(getFechaInicio(), getFechaFinal());
    }

    //Funcion para cambiar su fecha de inicio y final de interino
    public void cambiarFechas(LocalDate fInicio, LocalDate fFinal){
        setFechaInicio(fInicio);
        setFechaFinal(fFinal);
    }

    //Funcion para saber cuanto tiempo le queda para el fin de interinidad
    public long tiempoRestrante(){
        return ChronoUnit.DAYS.between(getFechaActual(), getFechaFinal());
    }

    public void cambiarCargo(Interino prof){
        CargoInterino cargoAux;
        cargoAux = getCargo();
        setCargo(prof.getCargo());
        prof.setCargo(cargoAux);
    }

    @Override
    public String toString() {
        return "Interino" +
                "\n\tFecha Inicio = " + fechaInicio +
                "\n\tFecha Final = " + fechaFinal +
                "\n\tInstituto = " + instituto +
                "\n\tCargo = " + cargo +
                "\n\t" + super.toString();
    }
}

