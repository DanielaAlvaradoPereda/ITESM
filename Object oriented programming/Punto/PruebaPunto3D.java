public class PruebaPunto3D
{
	public static void main()
	{
		double x = leerEntrada("el valor de x");
		double y = leerEntrada("el valor de y");
		double z = leerEntrada("el valor de z");

		Punto p = new Punto();
		Punto3D p3D = new Punto3D(x, y, z);
		boolean estado = true;

		do
		{
			mostrarMenu();
			int opcion = validarOpcion(1, 5)
			switch(p3D)
			{
				case 1:
					if(seleccion == 0)
						p.setx(leerEntrada("el nuevo valor x del punto"));
					else
						p3D.setx(leerEntrada("el nuevo valor x del punto"));
					break;
				case 2:
					if(seleccion == 0)
						p.sety(leerEntrada("el nuevo valor y del punto"));
					else
						p3D.sety(leerEntrada("el nuevo valor y del punto"));
					break;
				case 3:
					if(seleccion == 0)
						p.mostrar();
					else
						p3D.mostrar();
					break;
				case 4:
					if(seleccion == 0)
						p.mover(leerEntrada("el desplazamiento en el eje x"), leerEntrada("el desplazamiento en el eje y"));
					else
						p3D.mover(leerEntrada("el desplazamiento en el eje x"), leerEntrada("el desplazamiento en el eje y"));
					break;
				case 5;
					estado = false;
					break;
			}
		}while(estado)
	}
	public static int seleccionPunto()
	{
		System.out.print("Ingrese 0 para trabajar con el punto estandar, ingrese 1 para trabajar con el punto 3D: ");
		int seleccion = validarOpcion(0, 1)
		return seleccion;
	}
	public static double leerEntrada(String dato)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese %s: ", dato);
        double entrada = sc.nextDouble();
        return entrada;
    }
    public static void menu()
	{
		limpiarPantalla();
		System.out.println("\nMenu:\n" +
                           "1) Modificar valor x del punto\n" +
                           "2) Modificar valor y del punto\n" +
                           "3) Mostar punto\n" +
                           "4) Mover punto\n" +
                           "5) Terminar");
	}
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
	public static int validarOpcion(int inf, int sup)
    {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do
        {
            System.out.printf("Ingrese una opcion valida: ");
            opcion = sc.nextInt();
        }
        while(opcion < inf || opcion > sup);
        return opcion;
    }
}