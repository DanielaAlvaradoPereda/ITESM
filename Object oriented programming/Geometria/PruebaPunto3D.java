import java.util.Scanner;
public class PruebaPunto3D
{
	public static void main(String[] args)
	{
		double x = leerDouble("el valor de x");
		double y = leerDouble("el valor de y");
		double z = leerDouble("el valor de z");

		Punto p = new Punto();
		Punto3D p3D = new Punto3D(x, y, z);
		boolean estado = true;

		do
		{
			mostrarMenu();
			int opcion = leerInt(1, 6, "una opcion valida");
			switch(opcion)
			{
				case 1:
					if(leerInt(0, 1, "0 para p, 1 para p3D") == 0)
						p.setx(leerDouble("el nuevo valor x del punto"));
					else
						p3D.setx(leerDouble("el nuevo valor x del punto"));
					break;
				case 2:
					if(leerInt(0, 1, "0 para p, 1 para p3D") == 0)
						p.sety(leerDouble("el nuevo valor y del punto"));
					else
						p3D.sety(leerDouble("el nuevo valor y del punto"));
					break;
				case 3:
					if(leerInt(0, 1, "0 para p, 1 para p3D") == 0)
						p.mostrar();
					else
						p3D.mostrar();
					break;
				case 4:
					if(leerInt(0, 1, "0 para p, 1 para p3D") == 0)
						p.mover(leerDouble("el desplazamiento en el eje x"), leerDouble("el desplazamiento en el eje y"));
					else
						p3D.mover(leerDouble("el desplazamiento en el eje x"), leerDouble("el desplazamiento en el eje y"));
					break;
				case 5:
					p3D.mover(leerDouble("el desplazamiento en el eje x"), leerDouble("el desplazamiento en el eje y"),
						leerDouble("el desplazamiento en el eje z"));
					break;
				case 6:
					estado = false;
					break;
			}
		}while(estado);
	}
	public static double leerDouble(String dato)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese %s: ", dato);
        double entrada = sc.nextDouble();
        return entrada;
    }
    public static void mostrarMenu()
	{
		limpiarPantalla();
		System.out.println("\nMenu:\n" +
                           "1) Modificar valor x del punto\n" +
                           "2) Modificar valor y del punto\n" +
                           "3) Mostar punto\n" +
                           "4) Mover punto\n" +
                           "5) Mover punto en 3D\n" +
                           "6) Terminar\n");
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
	public static int leerInt(int inf, int sup, String dato)
    {
        Scanner sc = new Scanner(System.in);
        int entrada;
        do
        {
            System.out.printf("Ingrese %s: ", dato);
            entrada = sc.nextInt();
        }
        while(entrada < inf || entrada > sup);
        return entrada;
    }
}