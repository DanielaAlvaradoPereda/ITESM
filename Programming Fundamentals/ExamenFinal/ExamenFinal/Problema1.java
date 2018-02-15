/**
 * Este programa regresa f(x) para un valor real x introducido por el usuario
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 29/11/2016
 * 
 * Entradas: valor real x introducido por el usuario
 * Proceso: cálculo de f(x)
 * Salidas: f(x)
 */
import java.util.Scanner;
public class Problema1
{
    public static void main(String[] args)
    {
        // creación de scanner y pedir entrada
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduzca un valor x para evaluar en la función, introduzca Ctrl + z para terminar ");
        
        // entrada y salida
        while(entrada.hasNext())
        {
            double x = entrada.nextDouble();
            System.out.println("El valor de f(" + x + ") es : " + obtenerValor(x));
            System.out.print("Introduzca un valor x para evaluar en la función, introduzca Ctrl + z para terminar: ");
        }
    }
    // proceso
    public static double obtenerValor(double x)
    {
        if(x <= 0)
        {
            return x + 3;
        }
        else
        {
            return Math.pow(x, 2) + (2 * x);
        }
    } // fin de obtenerValor
} // fin de la clase
