/**
 * Este programa permite al usuario ingresar cinco numeros, después solo muestra los dígitos únicos ingresados (omite los repetidos)
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 31/10/16
 * 
 * Entradas: cinco números enteros
 * Proceso: comparación del último número ingresado con los anteriores
 * Salidas: números únicos ingresados
 */
import java.util.Scanner;
public class Duplicados
{
    public static void main()
    {
        // declaración de variables y scanner
        int[] numeros = new int[5];
        int contador = 0;
        Scanner entrada = new Scanner(System.in);
        
        // proceso
        while(contador < 5)
        {
            System.out.print("Introduzca un número entre 10 y 100: ");
            int numero = entrada.nextInt();
            boolean duplicado = false;
            
            if(numero >= 10 && numero <= 100)
            {
                for(int i = 0; i <= contador; i++)
                {
                    if(numero == numeros[i])
                    {
                        duplicado = true;
                        break;
                    }
                }
                if(duplicado == false)
                {
                    numeros[contador] = numero;
                }
                // salida
                for(int i = 0; i <= contador; i++)
                {
                    System.out.print(numeros[i] == 0? "" : (numeros [i] + " "));
                }
                System.out.println();
                contador++;
            }
            else
            {
                System.out.println("El numero ingresado no está entre 10 y 100");
            }
        }
    }
}