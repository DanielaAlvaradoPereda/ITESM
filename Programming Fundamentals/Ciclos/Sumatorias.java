/**
 * Write a description of class Sumatorias here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Sumatorias
{
    public static void main()
    {
        int valor, contador = 1, suma = 0;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Hasta que valor desea sumar desde el 1?");
        valor = entrada.nextInt();
        
        while(contador <= valor)
        {
            suma += contador;
            contador++;
        }
        
        System.out.println("La suma del 1 al " + valor + " es: " + suma);
    }
}
