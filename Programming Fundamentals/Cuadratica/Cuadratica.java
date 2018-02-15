/**
 * Write a description of class Cuadratica here.
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version (a version number or a date) 18/08/16
 */

// importar Scanner y Math para usar entrada y raíz cuadrada
import java.util.Scanner;
import java.lang.Math;

public class Cuadratica
{
    public static void main (String args[])
    {
       // declarar variables y crear scanner
       double a;
       double b;
       double c;
       double r1;
       double r2;
       Scanner input = new Scanner(System.in);
       
       // entrada de valores
       System.out.println("Hola Nacho, dada la forma general ax^2 + bx + c, introduce un número real para a: ");
       a = input.nextDouble();
       System.out.println("Introduce un número real para b: ");
       b = input.nextDouble();
       System.out.println("Introduce un número real para c: ");
       c = input.nextDouble();
       
       // resolver radicando
       double d = (b*b)-(4*a*c);
       
       // soluciones para cada caso
       if(a==0)
       {
           System.out.println("Los valores introducidos no corresponden a una ecuación cuadrática");
           System.out.println("Adiós Nacho :)");
       }
       else
       {
           if(d<0)
           {
               System.out.println("Los valores introducidos no corresponden a una ecuación cuadrática con raíces reales");
               System.out.println("Adiós Nacho :)");
           }
           if(d==0)
           {
               r1 = ((-1)*b)/(2*a);
               System.out.println("Los valores introducidos corresponden a una ecuación cuadrática con una sola raíz:");
               System.out.println("x = " + r1);
               System.out.println("Adiós Nacho :)");
           }
           if(d>0)
           {
               r1 = (((-1)*b)+(Math.sqrt(d)))/(2*a);
               r2 = (((-1)*b)-(Math.sqrt(d)))/(2*a);
               System.out.println("Los valores introducidos corresponden a una ecuación cuadrática con dos raíces:");
               System.out.println("x = " + r1);
               System.out.println("x = " + r2);
               System.out.println("Adiós Nacho :)");
           }
       }
    } // fin de main
} // fin de la clase