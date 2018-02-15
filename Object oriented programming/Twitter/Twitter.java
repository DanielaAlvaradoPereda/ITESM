/*
 * Este programa administra las clases Usuario y Tweet, simulando la red social Twitter.
 * 
 * Daniela Alvarado Pereda A01329233
 * Ricardo Hernández Morales A01329376
 *
 * 23/03/17
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Twitter
{
	// administra los menus
	public static void main(String[] args)
	{
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		ArrayList<Tweet> listaTweets = new ArrayList<Tweet>();
		boolean estado = true;

		do
		{
			limpiarPantalla();
			menu(0);
			int opcion = leerInt(1, 3, "una opcion");
			if(opcion == 3)
				break;
			do
			{
				limpiarPantalla();
				menu(opcion);
				switch(opcion)
				{
					case 1:
						estado = menuUsuarios(listaUsuarios, listaTweets, leerInt(1, 7, "una opcion"));
						break;
					case 2:
						estado = menuTweets(listaUsuarios, listaTweets, leerInt(1, 8, "una opcion"));
						break;
				}
			}while(estado);
		}while(true);
	}
	// muestra los diferentes menu
    public static void menu(int opcion)
	{
		switch(opcion)
		{
			case 0:
				System.out.println("Administrar:\n" +
								   "1. Usuarios\n" +
								   "2. Tweets\n" +
								   "3. Terminar\n");
				break;
			case 1:
				System.out.println("Menu para usuarios:\n" +
								   "1. Crear usuario\n" +
								   "2. Borrar usuario\n" +
								   "3. Mostrar todos los usuarios\n" +
								   "4. Seguir usuario\n" +
								   "5. Mostrar seguidores de un usuario\n" +
								   "6. Mostrar usuarios que sigue un usuario\n" +
								   "7. Regresar\n");
				break;
			case 2:
				System.out.println("Menu para tweets:\n" +
							   	   "1. Escribir tweet\n" +
								   "2. Mostrar todos los tweets con palabras y con hashtags de un usuario seguido\n" +
								   "3. Mostrar todos los tweets sin palabras ni hashtags de un usuario seguido\n" +
								   "4. Mostrar palabras de un tweet\n" +
								   "5. Mostrar hashtags de un tweet\n" +
								   "6. Dar like a un tweet\n" +
								   "7. Mostrar likes de un tweet\n" +
								   "8. Regresar\n");
				break;
		}
	}
	// menu para administrar usuarios
	public static boolean menuUsuarios(ArrayList<Usuario> listaUsuarios, ArrayList<Tweet> listaTweets, int opcion)
	{
		switch(opcion)
		{
			case 1:
				String identificador = leerString("el identificador del usuario");
				if(estaDisponible(identificador, listaUsuarios))
				{
					Usuario usuario = new Usuario(leerString("el nombre del usuario"), identificador);
					listaUsuarios.add(usuario);
				}
				break;
			case 2:
				if(tieneElementos(listaUsuarios, "usuarios", 1))
				{
					int indice = leerInt(0, listaUsuarios.size() - 1, "el indice del usuario");				
					listaUsuarios.get(indice).borrarDatos(listaTweets);
					listaUsuarios.remove(indice);
				}
				break;
			case 3:
				if(tieneElementos(listaUsuarios, "usuarios", 1))
				{
					imprimirLista(listaUsuarios);
				}
				break;
			case 4:
				if(tieneElementos(listaUsuarios, "usuarios", 2))
				{
					listaUsuarios.get(leerInt(0, listaUsuarios.size() - 1, "el indice del usuario activo")).seguir(listaUsuarios.get(leerInt(0,
						listaUsuarios.size() - 1, "el indice del usuario a seguir")));
				}
				break;
			case 5:
				if(tieneElementos(listaUsuarios, "usuarios", 1))
				{
					int indice = leerInt(0, listaUsuarios.size() - 1, "el indice del usuario");	
					System.out.println("Numero de seguidores: " + listaUsuarios.get(indice).obtenerSeguidores().size());
					imprimirLista(listaUsuarios.get(indice).obtenerSeguidores());
				}
				break;
			case 6:
				if(tieneElementos(listaUsuarios, "usuarios", 1))
				{
					int indice = leerInt(0, listaUsuarios.size() - 1, "el indice del usuario");	
					System.out.println("Numero de usuarios que sigue: " + listaUsuarios.get(indice).obtenerSiguiendo().size());
					imprimirLista(listaUsuarios.get(indice).obtenerSiguiendo());
				}
				break;
			case 7:
				return false;
		}
		return true;
	}
	// meno para administrar tweets
	public static boolean menuTweets(ArrayList<Usuario> listaUsuarios, ArrayList<Tweet> listaTweets, int opcion)
	{
		switch(opcion)
		{
			case 1:
				if(tieneElementos(listaUsuarios, "usuarios", 1))
				{
					int id;
					if(listaTweets.isEmpty())
					{
						id = 0;
					}
					else
					{
						id = listaTweets.get(listaTweets.size() - 1).obtenerId() + 1;
					}
					Tweet tweet = new Tweet(id, listaUsuarios.get(leerInt(0, listaUsuarios.size() - 1,
						"el indice del usuario que lo escribe")), leerString("el texto del tweet"));
					listaTweets.add(tweet);
				}
				break;
			case 2:
				if(tieneElementos(listaUsuarios, "usuarios", 2))
				{
					listaUsuarios.get(leerInt(0, listaUsuarios.size() - 1, "el indice del usuario activo")).mostrarTweets(listaUsuarios.get(leerInt(0,
						listaUsuarios.size() - 1, "el indice del usuario autor de los tweets")), listaTweets, true);
				}
				break;
			case 3:
				if(tieneElementos(listaUsuarios, "usuarios", 2))
				{
					listaUsuarios.get(leerInt(0, listaUsuarios.size() - 1, "el indice del usuario activo")).mostrarTweets(listaUsuarios.get(leerInt(0,
						listaUsuarios.size() - 1, "el indice del usuario autor de los tweets")), listaTweets, false);
				}
				break;
			case 4:
				if(tieneElementos(listaTweets, "tweets", 1))
				{
					listaTweets.get(leerInt(0, listaTweets.size() - 1, "el indice del tweet")).mostrarPalabras(false);
				}
				break;
			case 5:
				if(tieneElementos(listaTweets, "tweets", 1))
				{
					listaTweets.get(leerInt(0, listaTweets.size() - 1, "el indice del tweet")).mostrarHashtags(false);
				}
				break;
			case 6:
				if(tieneElementos(listaUsuarios, "usuarios", 2) && tieneElementos(listaTweets, "tweets", 1))
				{
					listaTweets.get(leerInt(0, listaTweets.size() - 1, "el indice del tweet")).agregarLike(listaUsuarios.get(leerInt(0,
						listaUsuarios.size() - 1, "el indice del usuario activo")));
				}
				break;
			case 7:
				if(tieneElementos(listaTweets, "tweets", 1))
				{
					int indice = leerInt(0, listaTweets.size() - 1, "el indice del tweet");	
					System.out.println("Numero de likes: " + listaTweets.get(indice).obtenerLikes().size());
					imprimirLista(listaTweets.get(indice).obtenerLikes());
				}
				break;
			case 8:
				return false;
		}
		return true;
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
    // recibe int del usuario y lo valida
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
	// recibe String del usuario y lo valida
	public static String leerString(String dato)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Ingrese %s: ", dato);
		String entrada = scanner.nextLine();
		while(entrada.isEmpty() || entrada.length() > 140)
		{
			System.out.printf("Entrada muy corta o muy larga, ingrese un dato valido: ");
			entrada = scanner.nextLine();
		}
		return entrada;
	}
	// imprime ArrayList de tipo generico
	public static void imprimirLista(ArrayList lista)
	{
		for(int i = 0; i < lista.size(); i++)
		{
			System.out.println(i + " - " + lista.get(i));
		}
	}
	// verifica si un ArrayList tiene elementos suficientes para realizar cierta acción
	public static boolean tieneElementos(ArrayList lista, String tipo, int min)
	{
		if(lista.size() >= min)
		{
			return true;
		}
		else
		{
			System.out.println("No hay suficientes " + tipo + " para la accion solicitada");
			return false;
		}
	}
	// verifica si el identificador ingresado está en uso
	public static boolean estaDisponible(String identificador, ArrayList<Usuario> listaUsuarios)
	{
		for(Usuario usuario : listaUsuarios)
		{
			if(identificador.equals(usuario.obtenerIdentificador()))
			{
				System.out.println("El identificador ingresado ya esta en uso");
				return false;
			}
		}
		return true;
	} // fin del metodo
} // fin de la clase