/**
 * Este programa pide al usuario que ingrese el radio de un círculo e imprime en la pantalla su diámetro, circunferencia y área
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 25/08/16
 * 
 * Entradas: Magnitud del radio de un círculo ingresada por el usuario a través del teclado
 * Proceso: Calcular diámetro, circunferencia y área para el radio ingresado
 * Salidas: Imprimir en la pantalla diámetro, circunferencia y área para el radio ingresado
 */
import java.util.Scanner;
public class Ejercicio228
{
    public static void main(String args[])
    {
        // declaración de variables y creación de scanner
        double radio;
        Scanner entrada = new Scanner(System.in);
        
        // entrada
        System.out.print("Ingrese el radio de un círculo: ");
        radio = entrada.nextDouble();
        
        // salidas y proceso, cálculo de diámetro, circunferencia y área
        System.out.print("El díametro del círculo correspondiente al radio ingresado es: " + (2 * radio) + 
                         "\nLa circunferencia del círculo correspondiente al radio ingresado es: " + (2 * Math.PI * radio) +
                         "\nEl área del círculo correspondiente al radio ingresado es: " + (Math.PI * Math.sqrt(radio)));
    } // fin de main
} // fin de la clase
