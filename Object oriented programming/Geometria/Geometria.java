/*
 * Este programa prueba las clases Punto y Linea, requiere que el usario cree una linea y un punto al iniciar la ejecución
 * 
 * Daniela Alvarado Pereda A01329233
 * Ricardo Hernández Morales A01329376
 *
 * 02/02/17
 */
import java.util.Scanner;

public class Geometria
{
    public static void main(String args[])
    {
    	// creación de variables
        boolean estado = true;
        Punto p0 = new Punto();
        Linea l1 = new Linea();

        // creación de objeto Punto inicial
        menu(3);
        if(validarOpcion(2) == 1)
        {
        	p0 = new Punto();
        	limpiarPantalla();
        }
        else
        {
        	p0 = new Punto(leerEntrada("la coordenada x del punto"), leerEntrada("la coordenada y del punto"));
        	limpiarPantalla();
        }

        // creación de objeto Linea inicial
        menu(4);
		switch(validarOpcion(3))
		{
			case 1:
				l1 = new Linea();
				limpiarPantalla();
				break;
			case 2:
				Punto p1 = new Punto(leerEntrada("la coordenada x para crear el punto 1"), leerEntrada("la coordenada y para crear el punto 1"));
				Punto p2 = new Punto(leerEntrada("la coordenada x para crear el punto 2"), leerEntrada("la coordenada y para crear el punto 2"));
				l1 = new Linea(p1, p2);
				limpiarPantalla();
				break;
			case 3:
				l1 = new Linea(leerEntrada("la coordenada x del punto 1"), leerEntrada("la coordenada y del punto 1"),
							   leerEntrada("la coordenada x del punto 2"), leerEntrada("la coordenada y del punto 2"));
				limpiarPantalla();
				break;
        }

        // loop principal
        do
        {
        	menu(0);
        	int opcion = validarOpcion(3);
        	switch(opcion)
        	{
        		case 1:
        			do
        			{
        				limpiarPantalla();
        				menu(1);
        			}while(opciones(validarOpcion(5) * -1, p0, l1));
        			break;
        		case 2:
        			do
        			{
        				limpiarPantalla();
        				menu(2);
        			}while(opciones(validarOpcion(5), p0, l1));
        			break;
        		case 3:
        			estado = false;
        			break;
        	}
        }while(estado);
    }

    // contiene todos los menús
    public static void menu(int opcion)
    {
        switch(opcion)
        {
            case 0:
                System.out.println("\nTrabajar con:\n" +
                                   "1) Punto\n" +
                                   "2) Linea\n" +
                                   "3) Terminar");
                break;
            case 1:
                System.out.println("\nMenu:\n" +
                                   "1) Modificar valor x del punto\n" +
                                   "2) Modificar valor y del punto\n" +
                                   "3) Mostar coordenada del punto\n" +
                                   "4) Mover punto\n" +
                                   "5) Regresar");
                break;
            case 2:
                System.out.println("\nMenu:\n" +
                                   "1) Modificar punto 1 de la linea\n" +
                                   "2) Modificar punto 2 de la linea\n" +
                                   "3) Mostar puntos de la linea\n" +
                                   "4) Mover linea\n" +
                                   "5) Regresar");
                break;
            case 3:
                System.out.println("\nElija una opcion para crear un punto:\n" +
                                   "1) Crear con cordenadas por default (0,0)\n" +
                                   "2) Ingresar coordenadas");
                break;
            case 4:
                System.out.println("\nElija una opcion para crear una linea:\n" +
                                   "1) Crear con puntos por default (0,0), (0,0)\n" +
                                   "2) Crear con puntos nuevos\n" +
                                   "3) Ingresar coordenadas");
                break;
        }
    }

    // valida que la opción elegida por el usuario esté en el rango adecuado
    public static int validarOpcion(int opciones)
    {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do
        {
            System.out.print("\nIntroduzca una opcion valida: ");
            opcion = sc.nextInt();
        }
        while(opcion < 1 || opcion > opciones);
        return opcion;
    }

    // lleva a cabo las diferentes acciones del menú
    public static boolean opciones(int opcion, Punto p0, Linea l1)
    {
        switch(opcion)
        {
            case -1:
                p0.setx(leerEntrada("la nueva coordenada x del punto"));
                break;
            case -2:
                p0.sety(leerEntrada("la nueva coordenada y del punto"));
                break;
            case -3:
                System.out.print("Las coordenadas del punto son: ");
                p0.muestra();
                System.out.println();
                break;
            case -4:
                p0.mueve(leerEntrada("el desplazamiento en el eje x"), leerEntrada("el desplazamiento en el eje y"));
                break;
            case -5:
            	limpiarPantalla();
                return false;
            case 1:
                Punto temp = new Punto(leerEntrada("la nueva coordenada x del punto 1"), leerEntrada("la nueva coordenada y del punto 1"));
                l1.setp1(temp);
                break;
            case 2:
                Punto temp2 = new Punto(leerEntrada("la nueva coordenada x del punto 2"), leerEntrada("la nueva coordenada y del punto 2"));
                l1.setp2(temp2);
                break;
            case 3:
                System.out.print("Las coordenadas de los puntos de la linea son: ");
                l1.muestra();
                System.out.println();
                break;
            case 4:
                l1.mueve(leerEntrada("el desplazamiento en el eje x"), leerEntrada("el desplazamiento en el eje y"));
                break;
            case 5:
            	limpiarPantalla();
                return false;
        }
        return true;
    }

    // lee entrada del usuario
    public static double leerEntrada(String dato)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese %s: ", dato);
        double entrada = sc.nextDouble();
        return entrada;
    }

    // limpia la pantalla
    public static void limpiarPantalla()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Presione enter para continuar");
        sc.nextLine();
        for(int i = 1; i <= 50; i++)
        {
            System.out.println();
        }
    }
}