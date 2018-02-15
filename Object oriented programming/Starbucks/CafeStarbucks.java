/*
 * Daniela Alvarado Pereda A01329233
 * Ricardo Hernández Morales A01329376
 *
 * 04/05/17
 */
import java.util.Scanner;

public class CafeStarbucks
{
	// administra menus y opciones
	public static void main (String args[])
	{
		int estado = 1;
		do
		{
			limpiarPantalla();
			menu(1);
			prepararBebida(leerInt(1, 6, "una opcion"), leerInt(0, Integer.MAX_VALUE, "el numero de condimentos deseados"));
			menu(0);
			estado = leerInt(1, 2, "una opcion");
		}while(estado == 1);
	}
	// limpia la pantalla insertando lineas vacias
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
    // muestra los diferentes menus
    public static void menu(int opcion)
	{
		switch(opcion)
		{
			case 0:
				System.out.println("Elija una opcion:\n" +
								   "1. Elegir otra bebida\n" +
								   "2. Salir\n");
				break;
			case 1:
				System.out.println("Elija una bebida base:\n" +
								   "1. Americano\n" +
								   "2. Capuccino\n" +
						  		   "3. Dark Roast\n" +
								   "4. Expresso\n" +
								   "5. Frappuccino\n" +
								   "6. House Blend\n");
				break;
			case 2:
				System.out.println("Lista de condimentos:\n" +
								   "1. Azucar\n" +
								   "2. Canela\n" +
						  		   "3. Crema\n" +
								   "4. Mocha\n" +
								   "5. Nuez\n" +
								   "6. Soya\n");
				break;
		}
	}
	// recibe y valida entero del usuario
	public static int leerInt(int inf, int sup, String dato)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Ingrese %s: ", dato);
		int entrada = scanner.nextInt();
		while(entrada < inf || entrada > sup)
		{
			System.out.printf("Ingrese un dato valido: ");
			entrada = scanner.nextInt();
		}
		return entrada;
	}
	// crea la bebida base, agrega condimento e imprime descripción y costo
	public static void prepararBebida(int opcion, int condimentos)
	{
		Bebida bebida;
		switch(opcion)
		{
			case 1:
				bebida = new Americano();
				bebida = agregarCondimentos(bebida, condimentos);
				System.out.println("\nBebida: " + bebida.getDescripcion() + "\nCosto: " + bebida.costo() + "\n");
				break;
			case 2:
				bebida = new Capuccino();
				bebida = agregarCondimentos(bebida, condimentos);
				System.out.println("\nBebida: " + bebida.getDescripcion() + "\nCosto: " + bebida.costo() + "\n");
				break;
			case 3:
				bebida = new DarkRoast();
				bebida = agregarCondimentos(bebida, condimentos);
				System.out.println("\nBebida: " + bebida.getDescripcion() + "\nCosto: " + bebida.costo() + "\n");
				break;
			case 4:
				bebida = new Expresso();
				bebida = agregarCondimentos(bebida, condimentos);
				System.out.println("\nBebida: " + bebida.getDescripcion() + "\nCosto: " + bebida.costo() + "\n");
				break;
			case 5:
				bebida = new Frappuccino();
				bebida = agregarCondimentos(bebida, condimentos);
				System.out.println("\nBebida: " + bebida.getDescripcion() + "\nCosto: " + bebida.costo() + "\n");
				break;
			case 6:
				bebida = new HouseBlend();
				bebida = agregarCondimentos(bebida, condimentos);
				System.out.println("\nBebida: " + bebida.getDescripcion() + "\nCosto: " + bebida.costo() + "\n");
				break;
		}
	}
	// crea y agrega cada condimento elegido
	public static Bebida agregarCondimentos(Bebida bebida, int condimentos)
	{
		if(condimentos != 0)
		{
			menu(2);
			for(int i = 1; i <= condimentos; i++)
			{
				int opcion = leerInt(1, 6, String.format("el condimento %d", i));
				switch(opcion)
				{
					case 1:
						bebida = new Azucar(bebida);
						break;
					case 2:
						bebida = new Canela(bebida);
						break;
					case 3:
						bebida = new Crema(bebida);
						break;
					case 4:
						bebida = new Mocha(bebida);
						break;
					case 5:
						bebida = new Nuez(bebida);
						break;
					case 6:
						bebida = new Soya(bebida);
						break;
				}
			}
		}
		return bebida;
	} // fin del método
} // fin de la clase