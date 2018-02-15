/**
 * Este programa puede convertir grados Fahrenheit a centigrados y viceversa
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 17/10/16
 * 
 * Entradas: Unidad de temperatura y magnitud de la misma
 * Proceso: Conversión mediante fórmulas
 * Salidas: Temperatura convertida
 */
import java.util.Scanner;
public class Temperaturas
{
    public static void main(String args[])
    {
        // creación de Scanner
        Scanner entrada = new Scanner(System.in);
        // entradas
        System.out.println("Ingrese f si desea convertir grados Centígrados a Fahrenheit, ingrese c si desea convertir grados Fahrenheit a Centígrados: ");
        String unidad = entrada.next();
        System.out.println("Ingrese la cantidad a ser convertida: ");
        // decisión, salida
        switch(unidad)
        {
            case "f":
                System.out.println(fahrenheit(entrada.nextDouble()));
                break;
            case "c":
                System.out.println(centigrados(entrada.nextDouble()));
                break;
        }
    }
    // proceso
    public static double centigrados(double gradosf)
    {
        return 5.0 / 9.0 * (gradosf - 32);
    }
    public static double fahrenheit(double gradosc)
    {
        return (9.0 / 5.0 * gradosc) + 32;

    }
}
