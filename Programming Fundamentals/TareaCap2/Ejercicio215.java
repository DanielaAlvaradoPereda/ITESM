/**
 * Este programa pide al usuario dos números y obtiene la suma, producto, diferencia y cociente de esos números
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 25/08/16
 * 
 * Entradas: Dos números ingresados por el usuario a través del teclado
 * Proceso: Obtener suma, producto, diferencia y cociente de los números introducidos
 * Salidas: Imprimir los resultados de las operaciones en la pantalla
 */
import java.util.Scanner;
public class Ejercicio215
{
    public static void main(String args[])
    {
        // declaración de variables y creación de scanner
        Scanner entrada = new Scanner(System.in);
        double numero1, numero2, suma, diferencia, producto, cociente;
        
        // entradas
        System.out.print("Ingrese un número: ");
        numero1 = entrada.nextDouble();
        System.out.print("Ingrese otro número: ");
        numero2 = entrada.nextDouble();
        
        // procesos, cálculo de las operaciones
        suma = numero1 + numero2;
        diferencia = numero1 - numero2;
        producto = numero1 * numero2;
        cociente = numero1 / numero2;
        
        // salidas
        System.out.println("La suma de los números ingresados es: " + suma +
                           "\nLa diferencia de los números ingresados es: " + diferencia +
                           "\nEl producto de los números ingresados es: " + producto +
                           "\nEl cociente de los números ingresados es: " + cociente);
    } // fin de main
} // fin de la clase
