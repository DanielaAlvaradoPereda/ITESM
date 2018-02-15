/**
 * Este programa muestra 4 diseños diferentes de triangulos con asteriscos
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 10/10/16
 * 
 * Entradas: Ninguna
 * Proceso: Loops para imprimir los triangulos
 * Salidas: 4 diseños diferentes de triangulos con asteriscos
 */
public class FigurasTriangulares
{
    public static void main()
    {
        // declaracion de variables
        int renglon;
        int columna;
        
        // proceso y salidas
        for(renglon = 1; renglon <= 10; renglon++)
        {
            for(columna = 1; columna <= renglon; columna++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for(renglon = 1; renglon <= 10; renglon++)
        {
            for(columna =  10; columna >= renglon; columna--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for(renglon = 1; renglon <= 10; renglon++)
        {
            for(columna = 10; columna > renglon; columna--)
            {
                System.out.print(" ");
            }
            for(columna = 1; columna <= renglon; columna++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for(renglon = 1; renglon <= 10; renglon++)
        {
            for(columna = 1; columna < renglon; columna++)
            {
                System.out.print(" ");
            }
            for(columna = 10; columna >= renglon; columna--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    } // fin de main
} // fin de la clase