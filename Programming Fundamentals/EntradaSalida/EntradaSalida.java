
/**
 * Write a description of class EntradaSalida here.
 * 
 * @author Daniela Alvarado Pereda
 * @version v1.0
 */

import java.util.Scanner;

public class EntradaSalida
{
    public static void main (String args[])
    {
        double x;
        Scanner entrada = new Scanner(System.in);
        
        // lee valor de la consola
        System.out.print("Escribe un valor real: ");
        x = entrada.nextDouble();
        
        // imprime valor introducido
        System.out.println("Escribiste: " + x);
    }// fin de main
}// fin de la clase
