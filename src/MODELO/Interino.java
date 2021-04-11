package MODELO;

import MODELO.Enums.CargoInterino;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public void duracionInternidad(){
        long dias= ChronoUnit.DAYS.between(getFechaInicio(), getFechaFinal());
        System.out.println("Dias de duracion de la internidad: "+dias);
    }

    //Funcion para cambiar su fecha de inicio y final de interino
    public void cambiarFechas(String fInicio, String fFinal){
        LocalDate fInicial = LocalDate.parse(fInicio);
        LocalDate fFin = LocalDate.parse(fFinal);
        setFechaInicio(fInicial);
        setFechaFinal(fFin);
    }

    //Funcion para saber cuanto tiempo le queda para el fin de interinidad
    public void tiempoRestrante(){
        long dias= ChronoUnit.DAYS.between(getFechaActual(), getFechaFinal());
        System.out.println("Dias de que te quedan para salir: "+dias);
    }

    public void cambiarCargo(Interino prof){
        CargoInterino cargoAux;
        cargoAux = getCargo();
        setCargo(prof.getCargo());
        prof.setCargo(cargoAux);
    }

    @Override
    public String toString() {
        return "Interino{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", instituto='" + instituto + '\'' +
                ", cargo=" + cargo +
                ", fechaActual=" + fechaActual +
                "} " + super.toString();
    }
}

