/**
 * Este programa permite al usuario imprimir por separado los dígitos de un número
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 17/10/16
 * 
 * Entradas: Entero entre 1 y 99999
 * Proceso: Separación de dígitos con el metodo mostrarDigitos
 * Salidas: Digitos separados por dos espacios
 */
import java.util.Scanner;
public class SeparaDigitos
{
    public static void main(String args[])
    {
         // creación de scanner
        Scanner entrada = new Scanner(System.in);
        
        // primera entrada y validación
        System.out.print("Ingrese un número entero entre 1 y 99999: ");
        int numero = entrada.nextInt();
        while(numero < 1 || numero > 99999)
        {
            System.out.print("Ingrese un número válido: ");
            numero = entrada.nextInt();
        }
        mostrarDigitos(numero);
    }
    public static void mostrarDigitos(int numero)
    {
        // declaración de variables
        String digitos = "";
        // proceso
        while(numero > 0)
        {
            digitos = residuo(numero, 10) + "  " + digitos;
            numero = cociente(numero, 10);
        }
        // salida
        System.out.println(digitos);
    }
    public static int cociente(int a, int b)
    {
        return a / b;
    }
    public static int residuo(int a, int b)
    {
        return a % b;
    }
}
