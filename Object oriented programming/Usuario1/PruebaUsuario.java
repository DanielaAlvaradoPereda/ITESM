import java.util.Scanner;

public class PruebaUsuario
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String nombre = recibeEntrada("nombre", sc);
        String apellido = recibeEntrada("apellido", sc);
        String cuenta = recibeEntrada("cuenta", sc);
        String clave = recibeEntrada("clave", sc);
        boolean estado = true;

        Usuario usuario1 = new Usuario(nombre, apellido, cuenta, clave);

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
                    usuario1.setNombre(recibeEntrada("nombre", sc));
                    limpiarPantalla(sc);
                    break;
                case 6:
                    System.out.println();
                    usuario1.setApellido(recibeEntrada("apellido", sc));
                    limpiarPantalla(sc);
                    break;
                case 7:
                    System.out.println();
                    usuario1.setCuenta(recibeEntrada("cuenta", sc));
                    limpiarPantalla(sc);
                    break;
                case 8:
                    System.out.println();
                    usuario1.setClave(recibeEntrada("clave", sc));
                    limpiarPantalla(sc);
                    break;
                case 9:
                    estado = false;
                    break;
            }
        }while(estado);
    }
    public static String recibeEntrada(String dato, Scanner sc)
    {
        System.out.printf("Ingrese su %s: ", dato);
        return sc.next();
    }
    public static void mostrarMenu()
    {
        System.out.println("\nMenú:\n" +
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
    public static int validarOpcion(Scanner sc)
    {
        int opcion = 0;
        do
        {
            System.out.println("\nIntroduzca una opción:");
            opcion = sc.nextInt();
        }while(opcion < 1 || opcion > 9);
        return opcion;
    }
    public static void limpiarPantalla(Scanner sc)
    {
        sc = new Scanner(System.in);
        System.out.print("Presione enter para continuar");
        sc.nextLine();
        for(int i = 1; i <= 20; i++)
        {
            System.out.println();
        }
    }
    public static void mostrarDatos(Usuario usuario1)
    {
        System.out.println("\nLos datos del usuario son:" + 
                           "\nNombre: " + usuario1.getNombre() +
                           "\nApellido: " + usuario1.getApellido() +
                           "\nCuenta: " + usuario1.getCuenta() +
                           "\nClave: " + usuario1.getClave());
    }
}