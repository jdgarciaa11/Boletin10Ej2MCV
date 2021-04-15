package VISTA;

import MODELO.Fijo;
import MODELO.Interino;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static final String MENU_INICIAL = """
            [1]. Crear profesor interino.
            [2]. Crear profesor fijo.
            [3]. Opciones profesor interino.
            [4]. Opciones profesro fijo.
            [5]. EXIT.""";
    public static final String MENU_FIJO = """
            [1]. Intercambiar cargo con otro profesor fijo.
            [2]. MENU PRINCIPAL.""";
    public static final String MENU_INTERINO = """
            [1]. Cambiar la fecha de interinidad.
            [2]. Consultar cuantos dias tiene de interinidad.
            [3]. Consultar cuantos dias que le queda trabajando.
            [4]. MENU PRINCIPAL.""";
    public static final String ELIGE_OPCION = "Elige una opcion: ";
    public static final String ELIGE_INTERINO = "Elige un profesor interino: ";
    public static final String ELIGE_FIJO = "Elige un profesor fijo: ";
    public static final String MENU_NOMBRE = "Dime un nombre: ";
    public static final String MENU_APELLIDO = "Dime los apellidos: ";
    public static final String MENU_EDAD = "Dime un edad: ";
    public static final String MENU_FECHA_INICIO = "Dime una fecha de inicio: ";
    public static final String MENU_FECHA_OBTENCION_PLAZA = "Dime una fecha de obtencion de la plaza: ";
    public static final String MENU_FECHA_FIN = "Dime una fecha de fin: ";
    public static final String MENU_CARGO_INTERINO = """
            [1].JEFE DE DEPARTAMENTO
            [2].PROFESOR""";
    public static final String MENU_CARGO_FIJO = """
            [1].JEFE DE DEPARTAMENTO
            [2].PROFESOR
            [3].DIRECTOR
            [4].JEFE DE ESTUDIO
            [5].SECRETARIO""";
    public static final String MENU_IDENTIFICADOR = "Introduce un identificador: ";
    public static final String MENSAJE_ERROR_VAL_ID = "ERROR! El dato introducido no es un numero o no tiene una longitud de 4.";
    public static final String MENSAJE_ERROR_FECHA = "ERROR! El formato de la fecha es dd-MM-yyyy.";
    public static final String MENSAJE_ERROR_EDAD = "ERROR! Su edad tiene que ser de 18 o mayor de 18.";
    public static final String MENU_INSTITUTO = "Dime el instituto donde trabaja: ";
    public static final String DIAS_RESTANTES = "Estos son los dias que te quedan para finalizar la inteniridad: ";
    public static final String DIAS_TOTALES = "Estos son los dias de inteniridad que tienes: ";

    private static Scanner teclado = new Scanner(System.in);//TODO pasar el scaner por parametro para mejorar el acoplamiento

    public static String menuInicial() {
        System.out.println(MENU_INICIAL);//Mostrar informacion
        System.out.print(ELIGE_OPCION);
        return teclado.nextLine();//Obtener informacion
    }

    public static String obtenerNombre() {
        System.out.print(MENU_NOMBRE);
        return teclado.nextLine();//Obtener informacion
    }

    public static String obtenerApellido() {
        System.out.print(MENU_APELLIDO);
        return teclado.nextLine();//Obtener informacion
    }

    public static int obtenerEdad() {
        String edad;
        boolean salir = false;
        do {
            System.out.print(MENU_EDAD);
            edad = teclado.nextLine();
            if (isNumeric(edad)){
                if (Integer.parseInt(edad) >= 18){
                    salir = true;
                }
            } else {
                System.out.println(MENSAJE_ERROR_EDAD);
            }
        } while (!salir);
        return Integer.parseInt(edad);//Obtener informacion
    }

    public static LocalDate obtenerFechaInicio() {
        LocalDate fInicio;
        String fecha;
        do{
            System.out.print(MENU_FECHA_INICIO);
            fecha = teclado.nextLine();
            try {
                fInicio = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException tm){
                System.out.println(MENSAJE_ERROR_FECHA);
                fInicio = null;
            }
        }while (fInicio == null);
        return fInicio;
    }

    public static LocalDate obtenerFechaFin() {
        LocalDate fFin;
        String fecha;
        do{
            System.out.print(MENU_FECHA_FIN);
            fecha = teclado.nextLine();
            try {
                fFin = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException tm){
                System.out.println(MENSAJE_ERROR_FECHA);
                fFin = null;
            }
        }while (fFin == null);
        return fFin;
    }

    public static LocalDate obtenerFechaObtencionPlaza() {
        LocalDate fPlaza;
        String fecha;
        do{
            System.out.print(MENU_FECHA_OBTENCION_PLAZA);
            fecha = teclado.nextLine();
            try {
                fPlaza = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException tm){
                System.out.println(MENSAJE_ERROR_FECHA);
                fPlaza = null;
            }
        }while (fPlaza == null);
        return fPlaza;
    }

    public static String obtenerInstituto() {
        System.out.print(MENU_INSTITUTO);
        return teclado.nextLine();//Obtener informacion
    }

    public static String obtenerCargoInterino() {
        System.out.println(MENU_CARGO_INTERINO);
        System.out.print(ELIGE_OPCION);
        return teclado.nextLine();//Obtener informacion
    }

    public static String obtenerCargoFijo() {
        System.out.println(MENU_CARGO_FIJO);
        System.out.print(ELIGE_OPCION);
        return teclado.nextLine();//Obtener informacion
    }

    public static int obtenerIdentificador() {
        String id;
        boolean salir = false;
        do {
            System.out.print(MENU_IDENTIFICADOR);
            id = teclado.nextLine();
            if (isNumeric(id)){
                if (id.length() == 4){
                    salir = true;
                }
            } else {
                System.out.println(MENSAJE_ERROR_VAL_ID);
            }
        } while (!salir);
        return Integer.parseInt(id);//Obtener informacion
    }

    public static String menuInterino(){
        System.out.println(MENU_INTERINO);
        System.out.print(ELIGE_OPCION);
        return teclado.nextLine();
    }

    public static String menuFijo(){
        System.out.println(MENU_FIJO);
        System.out.print(ELIGE_OPCION);
        return teclado.nextLine();
    }

    public static String eligeInterino(List<Interino> profInterinoList){
        for (int i = 0; i < profInterinoList.size(); i++) {
            System.out.println("["+i+"] "+profInterinoList.get(i).toString());
        }
        System.out.print(ELIGE_INTERINO);
        return teclado.nextLine();
    }

    public static String eligeFijo(List<Fijo> profFijoList) {
        for (int i = 0; i < profFijoList.size(); i++) {
            System.out.println("["+i+"] "+profFijoList.get(i).toString());
        }
        System.out.print(ELIGE_FIJO);
        return teclado.nextLine();
    }

    public static void consultarDiasInterinidad(int prof, List<Interino> profInterinoList) {
        System.out.println(DIAS_TOTALES+profInterinoList.get(prof).duracionInternidad());
    }

    public static void consultarDiasQueLeQuedanTrabajando(int prof, List<Interino> profInterinoList) {
        System.out.println(DIAS_RESTANTES+profInterinoList.get(prof).tiempoRestrante());
    }

    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
