/*
 * Este programa prueba las clases Punto, Linea y Polígono. En el ArrayList que contiene los puntos de un polígono no se repite el primer punto al final,
 * se asume que el último punto siempre va conectado al primero y esto se toma en cuenta para calcular el perímetro. Tomamos esta decisión ya que
 * finalmente es el mismo punto.
 * 
 * Daniela Alvarado Pereda A01329233
 * Ricardo Hernández Morales A01329376
 *
 * 10/03/17
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Geometria
{
	public static void main(String[] args)
	{
		ArrayList<Punto> listaPuntos = new ArrayList<Punto>();
		ArrayList<Linea> listaLineas = new ArrayList<Linea>();
		ArrayList<Poligono> listaPoligonos = new ArrayList<Poligono>();
		boolean estado = true;
		do
		{
			limpiarPantalla();
			menu(0);
			int opcion = leerEntrada(1, 4, "una opcion");
			if(opcion == 4)
				break;
			do
			{
				limpiarPantalla();
				menu(opcion);
				switch(opcion)
				{
					case 1:
						estado = menuPuntos(listaPuntos, leerEntrada(1, 7, "una opcion"));
						break;
					case 2:
						estado = menuLineas(listaPuntos, listaLineas, leerEntrada(1, 7, "una opcion"));
						break;
					case 3:
						estado = menuPoligonos(listaPuntos, listaPoligonos, leerEntrada(1, 7, "una opcion"));
				}
			}while(estado);
		}while(true);
	}
	// muestra el menu elegido
	public static void menu(int opcion)
	{
		switch(opcion)
		{
			case 0:
				System.out.println("Trabajar con:\n" +
								   "1. Puntos\n" +
								   "2. Lineas\n" +
								   "3. Poligonos\n" +
								   "4. Terminar\n");
				break;
			case 1:
				System.out.println("Menu para puntos:\n" +
								   "1. Crear punto\n" +
								   "2. Modificar punto\n" +
								   "3. Mover punto\n" +
								   "4. Mostrar punto\n" +
								   "5. Mostrar todos los puntos\n" +
								   "6. Mostrar dimension de la lista de puntos\n" +
								   "7. Regresar\n");
				break;
			case 2:
				System.out.println("Menu para lineas:\n" +
							   	   "1. Crear linea\n" +
								   "2. Mover linea\n" +
								   "3. Mostrar linea\n" +
								   "4. Mostrar todas las lineas\n" +
								   "5. Mostrar longitud\n" +
								   "6. Mostrar dimension de la lista de lineas\n" +
								   "7. Regresar\n");
				break;
			case 3:
				System.out.println("Menu para poligonos:\n" +
								   "1. Crear poligono\n" +
								   "2. Mover poligono\n" +
								   "3. Mostrar poligono\n" +
								   "4. Mostrar todos los poligonos\n" +
								   "5. Mostrar perimetro\n" +
								   "6. Mostrar dimension de la lista de poligonos\n" +
								   "7. Regresar\n");
				break;
		}
	}
	// recibe un entero del usuario
	public static int leerEntrada(int inf, int sup, String dato)
	{
		Scanner sc = new Scanner(System.in);
		int entrada;
		System.out.printf("Ingrese %s: ", dato);
		entrada = sc.nextInt();
		while(entrada < inf || entrada > sup)
		{
			System.out.printf("Ingrese un dato valido: ");
			entrada = sc.nextInt();
		}
		return entrada;
	}
	// menu para manejar puntos
	public static boolean menuPuntos(ArrayList<Punto> listaPuntos, int opcion)
	{
		switch(opcion)
		{
			case 1:
				Punto punto = new Punto(leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE, "el valor x del punto"),
					leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE, "el valor y del punto"));
				listaPuntos.add(punto);
				break;
			case 2:
				if(tieneElementos(listaPuntos, "puntos", 1))
					break;
				listaPuntos.get(leerEntrada(0, listaPuntos.size() - 1, "el indice del punto")).modificar(leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE,
					"el nuevo valor x del punto"), leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE, "el nuevo valor y del punto"));
				break;
			case 3:
				if(tieneElementos(listaPuntos, "puntos", 1))
					break;
				listaPuntos.get(leerEntrada(0, listaPuntos.size() - 1, "el indice del punto")).mover(leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE,
					"el desplazamiento en x del punto"), leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE, "el desplazamiento en y del punto"));
				break;
			case 4:
				if(tieneElementos(listaPuntos, "puntos", 1))
					break;
				System.out.println(listaPuntos.get(leerEntrada(0, listaPuntos.size() - 1, "el indice del punto")).toString());
				break;
			case 5:
				if(tieneElementos(listaPuntos, "puntos", 1))
					break;
				imprimirLista(listaPuntos);
				break;
			case 6:
				System.out.println(listaPuntos.size());
				break;
			case 7:
				return false;
		}
		return true;
	}
	// menu para manejar lineas
	public static boolean menuLineas(ArrayList<Punto> listaPuntos, ArrayList<Linea> listaLineas, int opcion)
	{
		switch(opcion)
		{
			case 1:
				if(tieneElementos(listaPuntos, "puntos", 2))
					break;
				Linea linea = new Linea(listaPuntos.get(leerEntrada(0, listaPuntos.size() - 1,"el indice del primer punto de la linea")),
					listaPuntos.get(leerEntrada(0, listaPuntos.size() - 1,"el indice del segundo punto de la linea")));
				listaLineas.add(linea);
				break;
			case 2:
				if(tieneElementos(listaLineas, "lineas", 1))
					break;
				listaLineas.get(leerEntrada(0, listaLineas.size() - 1, "el indice de la linea")).mover(leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE,
					"el desplazamiento en x de la linea"), leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE, "el desplazamiento en y de la linea"));
				break;
			case 3:
				if(tieneElementos(listaLineas, "lineas", 1))
					break;
				System.out.println(listaLineas.get(leerEntrada(0, listaLineas.size() - 1, "el indice de la linea")).toString());
				break;
			case 4:
				if(tieneElementos(listaLineas, "lineas", 1))
					break;
				imprimirLista(listaLineas);
				break;
			case 5:
				if(tieneElementos(listaLineas, "lineas", 1))
					break;
				System.out.println(listaLineas.get(leerEntrada(0, listaLineas.size() - 1, "el indice de la linea")).calcularLongitud());
				break;
			case 6:
				System.out.println(listaLineas.size());
				break;
			case 7:
				return false;
		}
		return true;
	}
	// menu para manejar poligonos
	public static boolean menuPoligonos(ArrayList<Punto> listaPuntos, ArrayList<Poligono> listaPoligonos, int opcion)
	{
		switch(opcion)
		{
			case 1:
				if(tieneElementos(listaPuntos, "puntos", 3))
					break;
				Poligono poligono = new Poligono(obtenerPuntos(listaPuntos, leerEntrada(3, listaPuntos.size(), "el numero de lados del poligono")));
				listaPoligonos.add(poligono);
				break;
			case 2:
				if(tieneElementos(listaPoligonos, "poligonos", 1))
					break;
				listaPoligonos.get(leerEntrada(0, listaPoligonos.size() - 1, "el indice del poligono")).mover(leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE,
					"el desplazamiento en x del poligono"), leerEntrada(Integer.MIN_VALUE, Integer.MAX_VALUE, "el desplazamiento en y del poligono"));
				break;
			case 3:
				if(tieneElementos(listaPoligonos, "poligonos", 1))
					break;
				System.out.println(listaPoligonos.get(leerEntrada(0, listaPoligonos.size() - 1, "el indice del poligono")).toString());
				break;
			case 4:
				if(tieneElementos(listaPoligonos, "poligonos", 1))
					break;
				imprimirLista(listaPoligonos);
				break;
			case 5:
				if(tieneElementos(listaPoligonos, "poligonos", 1))
					break;
				System.out.println(listaPoligonos.get(leerEntrada(0, listaPoligonos.size() - 1, "el indice del poligono")).calcularPerimetro());
				break;
			case 6:
				System.out.println(listaPoligonos.size());
				break;
			case 7:
				return false;
		}
		return true;
	}
	// imprime todos los objetos de una lista
	public static void imprimirLista(ArrayList lista)
	{
		for(int i = 0; i < lista.size(); i++)
		{
			System.out.println(i + " - " + lista.get(i).toString());
		}
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
    // pide al usuario los puntos para crear un polígono
    public static ArrayList<Punto> obtenerPuntos(ArrayList<Punto> listaPuntos, int cantidad)
    {
    	ArrayList<Punto> puntos = new ArrayList<Punto>();
    	for(int i = 1; i <= cantidad; i++)
    	{
    		puntos.add(listaPuntos.get(leerEntrada(0, listaPuntos.size(), "el indice del punto " + i + " para el poligono")));
    	}
    	return puntos;
    }
    // comprueba si hay elementos en una lista
    public static boolean tieneElementos(ArrayList lista, String tipo, int min)
    {
    	if(lista.size() < min)
    	{
    		System.out.println("Opcion invalida, no se han creado suficientes " + tipo);
    		return true;
    	}
    	return false;
    }
}