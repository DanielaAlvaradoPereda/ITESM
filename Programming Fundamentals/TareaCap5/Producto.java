/**
 * Este programa muestra el producto de los enteros impares del 1 al 15
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 10/10/16
 * 
 * Entradas: Ninguna
 * Proceso: Loop que multiplica los enteros impares del 1 al 15
 * Salidas: Producto de los enteros impares del 1 al 15
 */
public class Producto
{
    public static void main()
    {
        // declaracion de variable
        int producto = 1;
        
        // proceso
        for(int i = 1; i<=15; i += 2)
        {
            producto *= i;
        }
        
        // salida
        System.out.println("El producto de los enteros impares del 1 al 15 es: " + producto);
    } // fin de main
} // fin de la clase
