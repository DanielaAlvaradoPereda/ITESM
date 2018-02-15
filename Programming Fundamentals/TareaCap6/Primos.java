/**
 * Este programa imprime los numeros primos menores que 10000
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 17/10/16
 * 
 * Entradas: Ninguna
 * Proceso: Calculo de numeros primos menores que 10000
 * Salidas: Numeros primos menores que 10000
 */
public class Primos
{
    public static void main(String args[])
    {
        // prueba numeros del 2 al 10000
        for(int i = 2; i < 10000; i++)
        {
            if(primo(i))
            {
                // salida
                System.out.println(i);
            }
        }
    }
    // proceso
    public static boolean primo(int numero)
    {
        // prueba dividir desde 2 hasta la raíz del numero
        for(int i = 2; i <= Math.sqrt(numero); i++)
        {
            if(numero % i == 0)
            {
                return false;
            }
        }
        return true;
    }
} 