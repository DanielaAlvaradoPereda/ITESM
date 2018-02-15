/**
 * Este programa pide al usuario un número e indica si este es par o impar
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 25/08/16
 * 
 * Entradas: Número entero ingresado por el usuario a través del teclado
 * Proceso: Comprobar si al dividir el número introducido entre 2 el residuo es igual a 0
 * Salidas: Imprimir en la pantalla si el número es par o impar
 */
import java.util.Scanner;
public class Ejercicio225
{
   public static void main(String args[])
   {
       // declaración de variable y creación de scanner
       int numero;
       Scanner entrada = new Scanner(System.in);
       
       // entrads
       System.out.print("Ingrese un número entero: ");
       numero = entrada.nextInt();
       
       // proceso y salida, comprobar si el residuo es igual a cero
       if(numero%2==0)
       {
           System.out.println(numero + " es un número par");
       }
       else
       {
           System.out.println(numero + " es un número impar");
       }
   } // fin de main
} // fin de la clase