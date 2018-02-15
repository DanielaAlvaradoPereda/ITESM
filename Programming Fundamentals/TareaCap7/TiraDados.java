/**
 * Este programa simula el tiro de dos dados 36000000 veces e imprime cuantas veces apareció cada suma posible
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 31/10/16
 * 
 * Entradas: ninguna
 * Proceso: simulación de tiros y acumulación de frecuencias
 * Salidas: numero de veces que aparece cada suma
 */
import java.util.Random;
public class TiraDados
{
    public static void main(String[] args)
    {
        // declaración de variables
        int[] suma = new int[13];
        Random aleatorio = new Random();
        
        // proceso
        for(int i = 1; i < 36000000; i++)
        {
            int numero1 = 1 + aleatorio.nextInt(6);
            int numero2 = 1 + aleatorio.nextInt(6);
            suma[numero1 + numero2]++;
        }
        
        // salida
        System.out.println("Suma\tNumero de veces que apreció");
        for(int i = 2; i <= 12; i++)
        {
            System.out.println(i + "\t" + suma[i]);
        }
    }
}
