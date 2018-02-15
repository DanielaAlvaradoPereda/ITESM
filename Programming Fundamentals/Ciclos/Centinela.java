
/**
 * Write a description of class Centinela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Centinela
{
   public static void main()
   {
       int valor, suma = 0;
       Scanner entrada = new Scanner(System.in);
       
       System.out.println("Introduzca un valor entero positivo, o introduzca 0 para salir");
       valor = entrada.nextInt();
       
       while(valor != 0)
       {
           if(valor > 0)
           {
               while(valor != 0 && valor > 0)
               {
                   suma += valor;
                   System.out.println("Introduzca un valor entero positivo, o introduzca 0 para salir");
                   valor = entrada.nextInt();
               }
           }
           else
           {
                System.out.println("No introdujo un valor entero positivo");
                System.out.println("Introduzca un valor entero positivo, o introduzca 0 para salir");
                valor = entrada.nextInt();
           }
       }
       System.out.println("La suma de los números es: " + suma);
   }
}
