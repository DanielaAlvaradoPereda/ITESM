/**
 * Este programa muestra los primeros 200,000 terminos de una aproximacion a Pi en una tabla
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 10/10/16
 * 
 * Entradas: Ninguna
 * Proceso: Loops para aproximar el valor de Pi
 * Salidas: Tabla con los primeros 200,000 términos de la aproximación
 */
public class AproximacionPi
{
    public static void main()
    {
        // declaración de variable
        double pi = 0;
        
        // proceso y salida
        System.out.println("Termino\tPi");
        for(int i = 1; i <= 200000; i++)
        {
            if(i == 1)
            {
                pi = 4 / i;
                System.out.println(i + "\t" + pi);
            }else if(i % 2 == 0)
                {
                    pi -= 4.0 / ((2 * i) - 1);
                    System.out.println(i + "\t" + pi);
                }
                else
                {
                    pi += 4.0 / ((2 * i) - 1);
                    System.out.println(i + "\t" + pi);
                }
        }
    } // fin de main
} // fin de la clase
