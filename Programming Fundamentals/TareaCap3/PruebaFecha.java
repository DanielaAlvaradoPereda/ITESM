/**
 * Este programa permite al usuario ingresar y manipular una fecha compuesta por un día, un mes y un año
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 05/09/16
 * 
 * Entradas: Día, mes y año
 * Proceso: Llama a los metodos set y get de la clase para establecer y obtener los atributos, obtiene la fecha separando los atributos con diagonales llamando a un metodo especial
 * Salidas: Los atributos ingresados y la fecha ingresada con los elementos separados por diagonales
 */
import java.util.Scanner;
public class PruebaFecha
{
    public static void main(String args[])
    {
        // crear scanner
        Scanner entrada = new Scanner(System.in);
        
        // crea objeto de la clase Fecha con el metodo constructor
        Fecha fecha1 = new Fecha(9, 5, 2016);
        
        // modifica los atributos de fecha1 con metodos set
        System.out.print("Ingrese el mes: ");
        int mes = entrada.nextInt();
        fecha1.establecerMes(mes);
        System.out.print("Ingrese el día: ");
        int dia = entrada.nextInt();
        fecha1.establecerDia(dia);
        System.out.print("Ingrese el año: ");
        int año = entrada.nextInt();
        fecha1.establecerAño(año);
        
        // muestra la fecha con el metodo mostrarFecha
        System.out.println("\nLa fecha introducida es: " + fecha1.mostrarFecha());
        
        // obtiene los atributos de fecha1 con metodos get
        System.out.println("El mes es: " + fecha1.obtenerMes());
        System.out.println("El día es: " + fecha1.obtenerDia());
        System.out.println("El año es: " + fecha1.obtenerAño());
    } // fin de main
} // fin de la clase
