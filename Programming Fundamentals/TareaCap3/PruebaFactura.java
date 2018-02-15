/**
 * Este programa permite al usuario crear facturas con los atributos de numero, descripción, precio y cantidad de piezas.
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 05/09/16
 * 
 * Entradas: Numero, descripción, precio y cantidad de piezas.
 * Proceso: Llama a los metodos set y get de la clase para establecer y obtener los atributos, obtiene el monto llamando un metodo especial que lo calcula
 * Salidas: Los atributos ingresados y el monto calculado
 */
import java.util.Scanner;
public class PruebaFactura
{
    public static void main(String args[])
    {
        // crear scanner
        Scanner entrada = new Scanner(System.in);
        
        // crear objeto Factura usando el constructor
        Factura factura1 = new Factura("729", "Tornillo hexagonal", 50, 15.5);
        
        // establecer atributos de factura1 mediante metodos set
        System.out.print("Ingrese el número de pieza: ");
        String numero = entrada.nextLine();
        factura1.establecerNumero(numero);
        System.out.print("Ingrese la descripción de la pieza: ");
        String descripcion = entrada.nextLine();
        factura1.establecerDescripcion(descripcion);
        System.out.print("Ingrese la cantidad de piezas: ");
        int cantidad = entrada.nextInt();
        factura1.establecerCantidad(cantidad);
        System.out.print("Ingrese el precio de la pieza: ");
        double precio = entrada.nextDouble();
        factura1.establecerPrecio(precio);
        
        // obtener atributos de factura1 mediante metodos get
        System.out.println("\nUsted a ingresado:\nNúmero de pieza: " + factura1.obtenerNumero() +
                           "\nDescripción de la pieza: " + factura1.obtenerDescripcion() +
                           "\nCantidad de piezas: " + factura1.obtenerCantidad() +
                           "\nPrecio de la pieza: " + factura1.obtenerPrecio());
        // obtener monto llamando al metodo obtenerMontoFactura
        System.out.println("\nEl monto es: " + factura1.obtenerMontoFactura());
    } // fin de main
} // fin de la clase
