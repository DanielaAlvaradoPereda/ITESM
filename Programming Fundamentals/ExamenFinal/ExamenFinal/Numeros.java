/**
 * Este programa devuelve varios datos y cálculos a partir de cinco enteros positivos introducidos por el usuario
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 29/11/2016
 * 
 * Entradas: cinco enteros positivos introducidos por el usuario
 * Proceso: cálculos de suma, promedio, numero menor y mayor
 * Salidas: suma, promedio, valores menor y mayor
 */
import java.util.Scanner;
public class Numeros
{
    public static void main(String[] args)
    {
        // creación de scanner y arreglo
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[5];
        // validación de entrada
        for(int i = 0; i < numeros.length; i++)
        {
            System.out.print("Introduzca un entero positivo: ");
            numeros[i] = entrada.nextInt();
            while(numeros[i] <= 0)
            {
                 System.out.print("El número está fuera del rango. Introduzca un entero positivo: ");
                 numeros[i] = entrada.nextInt();
            }
        }
        // salidas
        System.out.println("La suma de los números introducidos es: " + suma(numeros));
        System.out.println("El promedio de los números introducidos es: " + promedio(numeros));
        System.out.println("El mayor de los números introducidos es: " + mayor(numeros));
        System.out.println("El menor de los números introducidos es: " + menor(numeros));
    }
    // procesos
    public static int suma(int[] numeros)
    {
        int suma = 0;
        for(int numero : numeros)
        {
            suma += numero;
        }
        return suma;
    }
    public static double promedio(int[] numeros)
    {
        int suma = 0;
        for(int numero : numeros)
        {
            suma += numero;
        }
        return (double)suma / numeros.length;
    }
    public static int mayor(int[] numeros)
    {
        int mayor = numeros[0];
        for(int numero : numeros)
        {
            if(numero > mayor)
            {
                mayor = numero;
            }
        }
        return mayor;
    }
    public static int menor(int[] numeros)
    {
        int menor = numeros[0];
        for(int numero : numeros)
        {
            if(numero < menor)
            {
                menor = numero;
            }
        }
        return menor;
    } // fin de menor
} // fin de la clase
