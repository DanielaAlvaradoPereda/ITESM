/**
 * Este programa prueba la clase Punto
 * 
 * Daniela Alvarado Pereda A01329233
 * Ricardo Hernández Morales A01329376
 * 23/01/17
 */
import java.util.Scanner;

public class PruebaPunto
{
    public static void main(String args[])
    {
    	// creación de variables y objetos
    	Scanner sc = new Scanner(System.in);
        double x = recibeEntrada("valor x", sc);
        double y = recibeEntrada("valor y", sc);
        boolean estado = true;

        Punto punto1 = new Punto(x, y);

        // loop del menú
        do
        {
            mostrarMenu();
            int opcion = validarOpcion(sc);
            switch(opcion)
            {
                case 1:
                    System.out.printf("\nEl valor x del punto es: %s%n", punto1.getx());
                    limpiarPantalla(sc);
                    break;
                case 2:
                    System.out.printf("\nEl valor y del punto es: %s%n", punto1.gety());
                    limpiarPantalla(sc);
                    break;
                case 3:
                    System.out.println();
                    punto1.setx(recibeEntrada("nuevo valor x", sc));
                    limpiarPantalla(sc);
                    break;
                case 4:
                    System.out.println();
                    punto1.sety(recibeEntrada("nuevo valor y", sc));
                    limpiarPantalla(sc);
                    break;
                case 5:
                    System.out.print("La coordenada del punto es: ");
                    punto1.muestra();
                    limpiarPantalla(sc);
                    break;
                case 6:
                	System.out.println();
                    modificarCoordenada(punto1, sc);
                    limpiarPantalla(sc);
                    break;
                case 7:
                    estado = false;
                    break;
            }
        }while(estado);
    }

    // lee entradas del usuario
    public static double recibeEntrada(String dato, Scanner sc)
    {
        System.out.printf("Ingrese el %s del punto: ", dato);
        return sc.nextDouble();
    }

    // imprime el menú en pantalla
    public static void mostrarMenu()
    {
        System.out.println("\nMenu:\n" +
                           "1) Mostrar el valor x del punto\n" +
                           "2) Mostrar el valor y del punto\n" +
                           "3) Modificar el valor x del punto\n" +
                           "4) Modificar el valor y del punto\n" +
                           "5) Mostrar la coordenada del punto\n" +
                           "6) Modificar la coordenada del punto\n" +
                           "7) Terminar");
    }

    // valida que la opción esté en el rango adecuado
    public static int validarOpcion(Scanner sc)
    {
        int opcion = 0;
        do
        {
            System.out.println("\nIntroduzca una opcion:");
            opcion = sc.nextInt();
        }while(opcion < 1 || opcion > 7);
        return opcion;
    }

    // imprime lineas en blanco para limpiar la pantalla
    public static void limpiarPantalla(Scanner sc)
    {
        sc = new Scanner(System.in);
        System.out.print("Presione enter para continuar");
        sc.nextLine();
        for(int i = 1; i <= 50; i++)
        {
            System.out.println();
        }
    }

    // modifica la coordenada del punto
    public static void modificarCoordenada(Punto punto1, Scanner sc)
    {
        double x = recibeEntrada("nuevo valor x", sc);
        double y = recibeEntrada("nuevo valor y", sc);
        punto1.mueve(x, y);
    } // fin del metodo
} // fin de la clase