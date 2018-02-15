/**
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 28/10/16
 */
import java.util.Scanner;
public class Potencias
{
    public static void main(String args[])
    {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese el primer número:");
        int numero1 = entrada.nextInt();
        System.out.println("Ingrese el segundo número:");
        int numero2 = entrada.nextInt();
        
        cuadrado(numero1);
        cubo(numero2);
    }
    public static void cuadrado(int numero)
    {
        System.out.println("El cuadrado del primer número es: " + Math.pow(numero, 2));
    }
    public static void cubo(int numero)
    {
        System.out.println("El cubo del segundo número es: " + Math.pow(numero, 3));
    }
}
