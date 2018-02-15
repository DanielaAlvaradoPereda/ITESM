/**
 * Este programa pide al usuario que ingrese un número de cinco dígitos e imprime cada dígito separado por tres espacios
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 25/08/16
 * 
 * Entradas: Número de cinco dígitos ingresado por el usuario
 * Proceso: Usar división y residuo para separar cada dígito
 * Salidas: Imprimir en la pantalla los cinco dígitos separados unos de otros por tres espacios
 */
import java.util.Scanner;
public class Ejercicio230
{
   public static void main(String args[])
   {
       // declaración de variables y creación de scanner 
       int numero, numero1, numero2, numero3, numero4, numero5,
           residuo1, residuo2, residuo3, residuo4;
       Scanner entrada = new Scanner(System.in);
       
       // entrada
       System.out.print("Ingrese un entero de cinco dígitos: ");
       numero = entrada.nextInt();
       
       // proceso, selección de los dígitos con operaciones de división y residuo
       numero1 = numero / 10000;
       residuo1 = numero % 10000;
       numero2 = residuo1 / 1000;
       residuo2 = residuo1 % 1000;
       numero3 = residuo2 / 100;
       residuo3 = residuo2 % 100;
       numero4 = residuo3 / 10;
       numero5 = residuo3 % 10;
       
       // salida
       System.out.println(numero1 + "   " + numero2 + "   " + numero3 + "   " + numero4 + "   " + numero5);
   } // fin de main
} // fin de la clase
