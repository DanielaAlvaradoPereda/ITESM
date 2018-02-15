/**
 * Este programa pide al usuario dos números y los compara indicando cual es mayor o si son iguales
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 25/08/16
 * 
 * Entradas: Dos números ingresados por el usuario a través del teclado
 * Proceso: Comparación de los números introducidos
 * Salidas: Indicar el número mayor o igualdad en la pantalla
 */
import java.util.Scanner;
public class Ejercicio216
{
    public static void main(String args[])
    {
        // declaración variables y creación de scanner
        Scanner entrada = new Scanner(System.in);
        double numero1, numero2;
        
        // entradas
        System.out.print("Ingrese un número: ");
        numero1 = entrada.nextDouble();
        System.out.print("Ingrese otro número: ");
        numero2 = entrada.nextDouble();
        
        // proceso y salida, comparación de los números ingresados
        if(numero1>numero2)
        {
            System.out.print(numero1 + " es mayor");
        }
        if(numero1<numero2)
        {
            System.out.print(numero2 + " es mayor");
        }
        if(numero1==numero2)
        {
            System.out.print(numero1 + " es igual a " + numero2);
        }
    } // fin de main
} // fin de la clase