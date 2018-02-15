/*
 * Este programa prueba la clase Usuario
 * 
 * Daniela Alvarado Pereda A01329233
 *
 * 23/01/17
 */
import java.util.Scanner;

public class PruebaUsuario
{
    public static void main(String args[])
    {   // creación de variables y objetos
        Scanner sc = new Scanner(System.in);
        String nombre = recibeEntrada("nombre", sc);
        String apellido = recibeEntrada("apellido", sc);
        String cuenta = recibeEntrada("cuenta", sc);
        String clave = recibeEntrada("clave", sc);
        boolean estado = true;
        Usuario usuario1 = new Usuario(nombre, apellido, cuenta, clave);

        // loop del menú
        do
        {
            mostrarMenu();
            int opcion = validarOpcion(sc);
            switch(opcion)
            {
                case 1:
                    System.out.printf("\nEl nombre completo del usuario es: %s%n",
                                      usuario1.getNombreCompleto());
                    limpiarPantalla(sc);
                    break;
                case 2:
                    System.out.printf("\nEl nombre completo inverso del usuario es: %s%n",
                                      usuario1.getNombreInverso());
                    limpiarPantalla(sc);
                    break;
                case 3:
                    System.out.printf("\nEl nombre y cuenta del usuario son: %s%n",
                                      usuario1.getNombreCuenta());
                    limpiarPantalla(sc);
                    break;
                case 4:
                    mostrarDatos(usuario1);
                    limpiarPantalla(sc);
                    break;
                case 5:
                    System.out.println();
                    usuario1.setNombre(recibeEntrada("nuevo nombre", sc));
                    limpiarPantalla(sc);
                    break;
                case 6:
                    System.out.println();
                    usuario1.setApellido(recibeEntrada("nuevo apellido", sc));
                    limpiarPantalla(sc);
                    break;
                case 7:
                    System.out.println();
                    usuario1.setCuenta(recibeEntrada("nueva cuenta", sc));
                    limpiarPantalla(sc);
                    break;
                case 8:
                    System.out.println();
                    usuario1.setClave(recibeEntrada("nueva clave", sc));
                    limpiarPantalla(sc);
                    break;
                case 9:
                    estado = false;
                    break;
            }
        }while(estado);
    }

    // lee entrada del usuario
    public static String recibeEntrada(String dato, Scanner sc)
    {
        System.out.printf("Ingrese su %s: ", dato);
        return sc.next();
    }

    // imprime el menú en pantalla
    public static void mostrarMenu()
    {
        System.out.println("\nMenu:\n" +
                           "1) Mostrar nombre completo\n" +
                           "2) Mostrar el nombre completo inverso\n" +
                           "3) Mostrar el nombre y cuenta\n" +
                           "4) Mostrar todos los datos\n" +
                           "5) Modificar nombre\n" +
                           "6) Modificar apellido\n" +
                           "7) Modificar cuenta\n" +
                           "8) Modificar clave\n" +
                           "9) Terminar");
    }

    // verfica que la opción elegida esté dentro del rango adecuado
    public static int validarOpcion(Scanner sc)
    {
        int opcion = 0;
        do
        {
            System.out.println("\nIntroduzca una opcion:");
            opcion = sc.nextInt();
        }while(opcion < 1 || opcion > 9);
        return opcion;
    }

    // limpia la consola insertando líneas en blanco
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

    // imprime todos los datos del usuario
    public static void mostrarDatos(Usuario usuario1)
    {
        System.out.println("\nLos datos del usuario son:" + 
                           "\nNombre: " + usuario1.getNombre() +
                           "\nApellido: " + usuario1.getApellido() +
                           "\nCuenta: " + usuario1.getCuenta() +
                           "\nClave: " + usuario1.getClave());
    } // fin del método
} // fin de la clase