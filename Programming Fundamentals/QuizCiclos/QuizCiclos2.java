/**
 * Este programa permite al usuario ingresar un número n e imprime un cuadrado de dimensiones nxn
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 13/09/16
 * 
 * Entradas: Lado del cuadrado
 * Proceso: Imprime cada línea mediante ciclos
 * Salidas: Cuadrado de lado n
 */
import java.util.Scanner;
public class QuizCiclos2
{
    public static void main()
    {
        // contadores, lado del cuadrado y scanner
        int n = 0, renglon = 1, posicion = 1;
        Scanner entrada = new Scanner(System.in);
        
        // entrada
        System.out.print("Introduzca un número entero positivo mayor que 0 para los lados de un cuadrado: ");
        n = entrada.nextInt();
        
        // proceso y salidas
        while(renglon <= n)
        {
            if(renglon == 1 || renglon == n)
            {
               posicion = 1;
               while(posicion <= n)
               {
                   System.out.print("*");
                   posicion++;
               }
               System.out.print("\n");
            }
            else
            {
                posicion = 1;
                System.out.print("*");
                while(posicion <= n - 2)
                {
                    System.out.print(" ");
                    posicion++;
                }
                System.out.print("*\n");
            }
            renglon++;
        }
    } // fin de main
} // fin de la clase