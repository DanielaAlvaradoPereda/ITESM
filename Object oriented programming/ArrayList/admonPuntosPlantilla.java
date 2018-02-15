import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class admonPuntosPlantilla {
	
	public static void main(String args[]) {

		double x,y;
		Punto p;
		int opt,cual,dimLista;
		boolean seguir;
		ArrayList<Punto> ListaPuntos;

		ListaPuntos = new ArrayList<Punto>();

		seguir = true;

		do {

			menuPuntos();
			opt = leeOpcion(8);

			switch (opt) {

				case 1:
				{
					x = leeDouble("Valor de x ");
					y = leeDouble("Valor de y ");
					p = new Punto(x,y);
					ListaPuntos.add(p);
					break;
				}
				case 2:
				{
					ListaPuntos.clear();
					break;
				}
				case 3: 
				{
					cual = leeInteger("Indice para leer punto ");
					if(cual < ListaPuntos.size())
					{
						p = ListaPuntos.get(cual);
						imprimeObjetoPunto(p);
					}
					else
					{
						System.out.println("Indice fuera de rango");
					}
					break;
				}
				case 4:
				{
					dimLista = ListaPuntos.size();
					System.out.println("La dimension de la lista es " + dimLista);
					break;
				}
				case 5:
				{
					imprimePuntos(ListaPuntos);
					break;
				}
				case 6:
				{
					x = leeDouble("Valor de x ");
					y = leeDouble("Valor de y ");
					p = new Punto(x,y);
					cual = leeInteger("Indice donde se agrega el punto");
					if(cual < ListaPuntos.size())
					{
						ListaPuntos.add(cual, p);
					}
					else
					{
						System.out.println("Indice fuera de rango");
					}
					break;
				}
				case 7:
				{
					x = leeDouble("Valor de x ");
					y = leeDouble("Valor de y ");
					p = new Punto();
					Punto pQuita = encuentraPunto(x, y, ListaPuntos);
					if(p != pQuita)
					{
						ListaPuntos.remove(pQuita);
					}
					else
					{
						System.out.println("El punto no se encuetra");
					}
					break;
				}
				case 8:
				{
					cual = leeInteger("Indice para eliminar punto ");
					if(cual < ListaPuntos.size())
					{
						ListaPuntos.remove(cual);
					}
					else
					{
						System.out.println("Indice fuera de rango");
					}
					break;
				}
				case 9:
				{
					seguir = false;
					break;
				}
			}


		} while (seguir);



	}


	// metodo de lectura de valores tipo String

	public static double leeDouble (String etiqueta) {

		double valor;
		Scanner s;

		System.out.print(etiqueta);
		s = new Scanner(System.in);
		valor = s.nextDouble();
		
		return valor;

	}

	// menu para leer una opcion, es un valor entero

	public static int leeOpcion(int numopciones) {

		int opcion;
		Scanner s;

		opcion = 0;

		do {
			System.out.println("Proporciona la opcion correcta");
			s = new Scanner(System.in);
			opcion = s.nextInt();

		} while (opcion < 1 || opcion > numopciones);

		return opcion;

	}

	public static void menuPuntos () {

		System.out.println("Gestion de puntos");
		System.out.println("");
		System.out.println("Opciones posibles");
		System.out.println("1. Crear punto");
		System.out.println("2. Limpiar lista");
		System.out.println("3. Mostrar punto");
		System.out.println("4. Dimension de la lista");
		System.out.println("5. Mostrar todos los puntos");
		System.out.println("6. Crear punto en indice especificado");
		System.out.println("7. Eliminar punto con coordenadas especificadas");
		System.out.println("8. Eliminar punto en índice especificado");
		System.out.println("9. Terminar");


	}

	public static void imprimeObjetoPunto (Punto p) {

		double x,y;

		x = p.leeX();
		y = p.leeY();

		System.out.println("Datos del punto");
		System.out.println("x: " + x);
		System.out.println("y: " + y);

	}	

	public static void imprimePuntos(ArrayList<Punto> ListaPuntos){

		/*int dim, i;
		Punto p;

		dim = ListaPuntos.size();
		i = 0;

		while (i < dim) {

			p = ListaPuntos.get(i);
			imprimeObjetoPunto(p);
			i++;

		}*/
		Iterator<Punto> iterator = ListaPuntos.iterator();
		while(iterator.hasNext())
		{
			imprimeObjetoPunto(iterator.next());
		}
	}


		// metodo para leer un valor entero

	public static int leeInteger (String etiqueta) {

		int valor;
		Scanner v1;

		System.out.print(etiqueta);
		v1 = new Scanner(System.in);
		valor = v1.nextInt();

		return valor;

	}
	public static Punto encuentraPunto(double x, double y, ArrayList<Punto> ListaPuntos)
	{
		Iterator<Punto> iterator = ListaPuntos.iterator();
		Punto p = new Punto();
		while(iterator.hasNext())
		{
			p = iterator.next();
			if(x == p.leeX() && y == p.leeY())
			{
				return p;
			}
		}
		return p;
	}
}