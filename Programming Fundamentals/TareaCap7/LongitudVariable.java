/**
 * Este programa prueba un método que acepta una longitud variable de parámetros como argumentos
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 31/10/16
 * 
 * Entradas: ninguna
 * Proceso: métodos que calcula el producto de los números mandados
 * Salidas: producto de los números mandados al método
 */
import java.util.Scanner;
public class LongitudVariable
{
    public static void main(String[] args)
    {
        // salida
        System.out.println("El producto de 2 es " + producto(2));
        System.out.println("El producto de 2 * 3 es " + producto(2, 3));
        System.out.println("El producto de 4 * 6 * 5 es " + producto(4, 6, 5));
        System.out.println("El producto de 2 * 4 * 3 * 9 es " + producto(2, 4, 3, 9));
        System.out.println("El producto de 5 * 1 * 3 * 2 * 7 es " + producto(5, 1, 3, 2, 7));
        
    }
    
    // proceso
    public static int producto(int... numeros)
    {
        int total = 1;
        for(int i : numeros)
        {
            total *= i;
        }
        return total;
    }
}
