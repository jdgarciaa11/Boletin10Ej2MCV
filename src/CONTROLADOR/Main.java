package CONTROLADOR;

import MODELO.*;
import MODELO.Enums.CargoFijo;
import MODELO.Enums.CargoInterino;
import VISTA.Menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Interino> profInterinoList = new ArrayList<Interino>();
        List<Fijo> profFijoList = new ArrayList<Fijo>();
        String eleccion;
        do {//En funcion de la eleccion del usuario, controla que se debe hacer
            eleccion = Menu.menuInicial();
            switch (eleccion) {
                case "1" -> addInterino(profInterinoList);//Se quiere añadir un profesor interino
                case "2" -> addFijo(profFijoList);//Se quiere añadir un profesor fijo
                case "3" -> mostrarOpcionesInterino(profInterinoList);//Se quiere mostrar que hacer con los profesores interinos
                case "4" -> mostrarOpcionesFijo(profFijoList);//Se quiere mostrar que hacer con los profesores fijo
            }
        } while (!eleccion.equals("5"));//5 es la opcion para salir del programa
    }

    private static void addInterino(List<Interino> profInterino) {
        String nombre = Menu.obtenerNombre();
        String apellido = Menu.obtenerApellido();
        int edad = Menu.obtenerEdad();
        LocalDate fechaInicio = Menu.obtenerFechaInicio();
        LocalDate fechaFinal = Menu.obtenerFechaFin();
        String instituto = Menu.obtenerInstituto();
        CargoInterino cargo = seleccionarCargoInterino();
        profInterino.add(new Interino(nombre, apellido, edad, fechaInicio, fechaFinal, instituto, cargo));
    }

    private static CargoInterino seleccionarCargoInterino() {
        CargoInterino cargo = null;
        String eleccion;
        do {
            eleccion = Menu.obtenerCargoInterino();
            switch (eleccion) {
                case "1" -> cargo = CargoInterino.JEFE_DE_DEPARTAMENTO;
                case "2" -> cargo = CargoInterino.PROFESOR;
            }
        } while (cargo == null);
        return cargo;
    }

    private static void addFijo(List<Fijo> profFijo) {
        String nombre = Menu.obtenerNombre();
        String apellido = Menu.obtenerApellido();
        int edad = Menu.obtenerEdad();
        int identificadorFuncionario = Menu.obtenerIdentificador();
        LocalDate fechaPlaza = Menu.obtenerFechaObtencionPlaza();
        CargoFijo cargo = seleccionarCargoFijo();
        profFijo.add(new Fijo(nombre, apellido, edad, identificadorFuncionario, fechaPlaza, cargo));
    }

    private static CargoFijo seleccionarCargoFijo() {
        CargoFijo cargo = null;
        String eleccion;
        do {
            eleccion = Menu.obtenerCargoFijo();
            switch (eleccion) {
                case "1" -> cargo = CargoFijo.JEFE_DE_DEPARTAMENTO;
                case "2" -> cargo = CargoFijo.PROFESOR;
                case "3" -> cargo = CargoFijo.DIRECTOR;
                case "4" -> cargo = CargoFijo.JEFE_DE_ESTUDIO;
                case "5" -> cargo = CargoFijo.SECRETARIO;
            }
        } while (cargo == null);
        return cargo;
    }
    private static void mostrarOpcionesInterino(List<Interino> profInterinoList) {
        String eleccion;
        int prof = Integer.parseInt(Menu.eligeInterino(profInterinoList));
        do {
            eleccion = Menu.menuInterino();
            switch (eleccion) {
               case "1" -> cambiarFechaInterinidad(prof, profInterinoList);
               case "2" -> Menu.consultarDiasInterinidad(prof, profInterinoList);
               case "3" -> Menu.consultarDiasQueLeQuedanTrabajando(prof, profInterinoList);
            }
        } while (!eleccion.equals("4"));
    }

    private static void mostrarOpcionesFijo(List<Fijo> profFijoList) {
        String eleccion;
        int prof = Integer.parseInt(Menu.eligeFijo(profFijoList));
        do {
            eleccion = Menu.menuFijo();
            switch (eleccion) {
                case "1" -> profFijoList.get(prof).cambiarCargo(profFijoList.get(Integer.parseInt(Menu.eligeFijo(profFijoList))));
            }
        } while (!eleccion.equals("2"));
    }

    private static void cambiarFechaInterinidad(int prof, List<Interino> profInterinoList) {
        LocalDate fechaInicio = Menu.obtenerFechaInicio();
        LocalDate fechaFinal = Menu.obtenerFechaFin();
        profInterinoList.get(prof).cambiarFechas(fechaInicio, fechaFinal);
    }
}
