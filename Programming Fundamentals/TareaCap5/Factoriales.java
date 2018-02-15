/**
 * Este programa muestra los factoriales de los números del 1 al 20 en una tabla
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 10/10/16
 * 
 * Entradas: Ninguna
 * Proceso: Loop que calcula los factoriales del 1 al 20
 * Salidas: Tabla con facotriales de los números del 1 al 20
 */
public class Factoriales
{
    public static void main()
    {
        // declaracion de variable
        long factorial = 1;
        
        // proceso y salida
        System.out.println("n\tFactorial");
        for(int i = 1; i <= 20; i++)
        {
            factorial *= i;
            System.out.println(i + "\t" + factorial);
        }
    } // fin de main
} // fin de la clase
