/**
 * Este programa muestra las ternas de pitágoras con lados de 1 a 500 de longitud
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 10/10/16
 * 
 * Entradas: Ninguna
 * Proceso: Loops para calcular las diferentes ternas
 * Salidas: Tabla con las ternas de pitágoras con lados de 1 a 500 de longitud
 */
public class TriplesDePitagoras
{
    public static void main()
    {
        // declaración de variables
        int lado1;
        int lado2;
        int hipotenusa;
        
        // proceso y salidas
        System.out.println("Lado 1\tLado 2\tHipotenusa");
        for(lado1 = 1; lado1 <= 500; lado1++)
        {
            for(lado2 = 1; lado2 <= 500; lado2++)
            {
                for(hipotenusa = 1; hipotenusa <= 500; hipotenusa++)
                {
                    if(lado1 * lado1 + lado2 * lado2 == hipotenusa * hipotenusa)
                    {
                        System.out.println(lado1 + "\t" + lado2 + "\t" + hipotenusa);
                    }
                }
            }
        }
    } // fin de main
} // fin de la clase
