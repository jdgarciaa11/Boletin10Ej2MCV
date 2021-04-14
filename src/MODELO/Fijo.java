package MODELO;

import MODELO.Enums.CargoFijo;

import java.time.LocalDate;

public class Fijo extends Profesor{
    private int identificadorFuncionario;
    private LocalDate fechaPlaza;
    private CargoFijo cargo;

    public Fijo(String nombre, String apellidos, int edad, int identificadorFuncionario, LocalDate fechaPlaza, CargoFijo cargo) {
        super(nombre, apellidos, edad);
        this.identificadorFuncionario = identificadorFuncionario;
        this.fechaPlaza = fechaPlaza;
        this.cargo = cargo;
    }

    public int getIdentificadorFuncionario() {
        return identificadorFuncionario;
    }

    public void setIdentificadorFuncionario(int identificadorFuncionario) {
        this.identificadorFuncionario = identificadorFuncionario;
    }

    public LocalDate getFechaPlaza() {
        return fechaPlaza;
    }

    public void setFechaPlaza(LocalDate fechaPlaza) {
        this.fechaPlaza = fechaPlaza;
    }

    public CargoFijo getCargo() {
        return cargo;
    }

    public void setCargo(CargoFijo cargo) {
        this.cargo = cargo;
    }

    //INTERCAMBIAR CARGO CON OTRO PROFESOR FIJO
    public void cambiarCargo(Fijo prof){
        CargoFijo cargoAux;
        cargoAux = this.getCargo();
        this.setCargo(prof.getCargo());
        prof.setCargo(cargoAux);
    }

    @Override
    public String toString() {
        return "Fijo" +
                "\n\tIdentificadorFuncionario = " + identificadorFuncionario +
                "\n\tFecha Plaza = " + fechaPlaza +
                "\n\tCargo = " + cargo +
                "\n\t" + super.toString();
    }
}
