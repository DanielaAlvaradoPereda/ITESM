
/**
 * Write a description of class Comparar here.
 * 
 * @author Daniela Alvarado Pereda A01329233
 * @version v1.0
 */

import java.util.Scanner;

public class Comparar
{
   public static void main (String args[])
   {
       double a = 0;
       double b = 0;
       Scanner input = new Scanner(System.in);
       
       // introducir dos números
       System.out.print("Escribe un número: ");
       a = input.nextDouble();
       
       System.out.print("Escribe otro número: ");
       b = input.nextDouble();
       
       // comparar números
       if(a!=b)
       {
           if(a>b)
           {
               System.out.print(a + " es mayor que " + b);
           }
           else
           {
               System.out.print(b + " es mayor que " + a);
           }
       }
       else
       {
           System.out.print(a + " es igual que " + b);
       }
   }
}
