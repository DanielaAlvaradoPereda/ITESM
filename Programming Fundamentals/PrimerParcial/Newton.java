/**
 * Este programa permite al usuario ingresar las masas de dos cuerpos y la distancia entre ellos y calcula la fuerza de atracción entre ambos cuerpos
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 06/09/16
 * 
 * Entradas: Masa de los cuerpos y distancia entre ellos
 * Proceso: Calcula la fuerza de atracción entre los cuerpos con la formula de Newton
 * Salidas: Fuerza de atracción entre los cuerpos ingresados
 */
import java.util.Scanner;
public class Newton
{
   public static void main(String args[])
   {
       // crear scanner
       Scanner entrada = new Scanner(System.in);
       
       // entradas
       System.out.print("Ingrese la masa en gramos del cuerpo 1: ");
       double masa1 = entrada.nextDouble();
       System.out.print("Ingrese la masa en gramos del cuerpo 2: ");
       double masa2 = entrada.nextDouble();
       System.out.print("Ingrese la distancia entre los cuerpos en centimetros: ");
       double distancia = entrada.nextDouble();
       
       // proceso
       double fuerza = (6.67E-8)*(masa1 * masa2)/Math.pow(distancia, 2);
       
       // salida
       System.out.println("La fuerza de atracción entre los cuerpos es: " + fuerza);
   }
}
