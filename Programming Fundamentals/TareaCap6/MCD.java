/**
 * Este programa obtiene el MCD de dos números con el algoritmo de Euclides
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 17/10/16
 * 
 * Entradas: dos numero enteros
 * Proceso: algoritmo de Euclides
 * Salidas: MCD de los numeros
 */
import java.util.Scanner;
public class MCD
{
    public static void main(String args[])
    {
        // entradas y creación de variables
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int a = entrada.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int b = entrada.nextInt();
        // salida
        System.out.print("El máximo común divisor de " + a + " y " + b + " es " + mcd(a, b));
    }
    // proceso
    public static int mcd(int a, int b)
    {
        while(a != b)
        {
            if(a > b)
            {
                a -= b;
            }
            else
            {
                b -= a;
            }
        }
        return a;
    }
}
