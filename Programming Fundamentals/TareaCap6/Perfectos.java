/**
 * Este programa imprime los numeros perfectos entre 1 y 1000
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 17/10/16
 * 
 * Entradas: Ninguna
 * Proceso: Calculo de numeros perfectos entre 1 y 1000
 * Salidas: Tabla con numeros perfectos entre 1 y 1000
 */
public class Perfectos
{
    public static void main(String args[])
    {
        // imprime perfectos del 1 al 1000
        System.out.println("Perfecto\tFactores");
        for(int i = 1; i <= 1000; i++)
        {
            if(esPerfecto(i))
            {
                // salida
                System.out.print(i + "\t\t");
                for(int factor = 1; factor <= (i / 2); factor ++)
                {
                    if(i % factor == 0)
                    {
                        System.out.print(factor + " ");
                    }
                }
                System.out.println();
            }
        }
    }
    // proceso
    public static boolean esPerfecto(int numero)
    {
        // declaración de variables
        int suma = 0;
        // loop que calcula y suma factores
        for(int factor = 1; factor <= (numero / 2); factor++)
        {
            if(numero % factor == 0)
            {
                suma += factor;
            }
        }
        // determina si es perfecto o no
        if(suma == numero)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
