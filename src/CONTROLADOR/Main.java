package CONTROLADOR;

import MODELO.*;
import VISTA.Menu;

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
                case "1" -> Gestora.addInterino(profInterinoList);//Se quiere añadir un profesor interino
                case "2" -> Gestora.addFijo(profFijoList);//Se quiere añadir un profesor fijo
                case "3" -> Gestora.mostrarOpcionesInterino(profInterinoList);//Se quiere mostrar que hacer con los profesores interinos
                case "4" -> Gestora.mostrarOpcionesFijo(profFijoList);//Se quiere mostrar que hacer con los profesores fijo
            }
        } while (!eleccion.equals("5"));//5 es la opcion para salir del programa
    }
}
