/**
 * Este programa permite al usuario crear objetos de la clase Empleado y manipular el atributo "sueldo"
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 05/09/16
 * 
 * Entradas: Nombre completo y sueldo del empleado
 * Proceso: Llama a los metodos set y get de la clase para establecer y obtener los atributos, obtiene el salario anual y aumenta 10% a los salarios llamando a metodos especiales
 * Salidas: Los atributos ingresados y el salario anual
 */
import java.util.Scanner;
public class PruebaEmpleado
{
    public static void main(String args[])
    {
        // crear scanner
        Scanner entrada = new Scanner(System.in);
        
        // crear objetos de la clase Empleado usando constructores
        Empleado empleado1 = new Empleado("Daniela", "Alvarado", 8000);
        Empleado empleado2 = new Empleado("Nombre", "Apellido", 0);
        
        // cambiar los atributos de empleado2 usando metodos set
        System.out.print("Ingrese el nombre del empleado2: ");
        String nombre = entrada.nextLine();
        empleado2.establecerNombre(nombre);
        System.out.print("Ingrese el apellido del empleado2: ");
        String apellido = entrada.nextLine();
        empleado2.establecerApellido(apellido);
        System.out.print("Ingrese el salario del empleado2: ");
        double salario = entrada.nextDouble();
        empleado2.establecerSalario(salario);
        
        // obtener atributos de los objetos con metodos get
        System.out.println("\nNombre completo del empleado1: " + empleado1.obtenerNombre() + " " + empleado1.obtenerApellido());
        System.out.println("Salario del empleado1: " + empleado1.obtenerSalario());
        System.out.println("Nombre completo del empleado2: " + empleado2.obtenerNombre() + " " + empleado2.obtenerApellido());
        System.out.println("Salario del empleado2: " + empleado2.obtenerSalario());
        
        // obtener salario anual llamando al mmetodo salarioAnual
        System.out.println("\nSalario anual del empleado1: " + empleado1.salarioAnual());
        System.out.println("Salario anual del empleado2: " + empleado2.salarioAnual());
        
        // aumentar salario 10% llamando al metodo aumentoDiez
        System.out.println("\nAumentando salarios 10%");
        empleado1.aumentoDiez();
        empleado2.aumentoDiez();
        
        // obtener atributos de los objetos con metodos get
        System.out.println("\nNombre completo del empleado1: " + empleado1.obtenerNombre() + " " + empleado1.obtenerApellido());
        System.out.println("Salario del empleado1: " + empleado1.obtenerSalario());
        System.out.println("Nombre completo del empleado2: " + empleado2.obtenerNombre() + " " + empleado2.obtenerApellido());
        System.out.println("Salario del empleado2: " + empleado2.obtenerSalario());
        
        // obtener salario anual llamando al mmetodo salarioAnual
        System.out.println("\nSalario anual del empleado1: " + empleado1.salarioAnual());
        System.out.println("Salario anual del empleado2: " + empleado2.salarioAnual());
    } // fin de main
} // fin de la clase
