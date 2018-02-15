import java.util.ArrayList;
import java.util.Iterator;

public class Usuario
{
	// atributos
	private String nombre;
	private String identificador;
	private ArrayList<Usuario> seguidores;
	private ArrayList<Usuario> siguiendo; 

	// constructores
	public Usuario(String nombre, String identificador)
	{
		this.nombre = nombre;
		this.identificador = identificador;
		seguidores = new ArrayList<Usuario>();
		siguiendo = new ArrayList<Usuario>();
	}

	// sets
	private void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	private void setIdentificador(String identificador)
	{
		this.identificador = identificador;
	}
	private void setSeguidores(ArrayList<Usuario> seguidores)
	{
		this.seguidores = seguidores;
	}
	private void setSiguiendo(ArrayList<Usuario> siguiendo)
	{
		this.siguiendo = siguiendo;
	}

	// gets
	private String getNombre()
	{
		return nombre;
	}
	private String getIdentificador()
	{
		return identificador;
	}
	private ArrayList<Usuario> getSeguidores()
	{
		return seguidores;
	}
	private ArrayList<Usuario> getSiguiendo()
	{
		return siguiendo;
	}

	// metodos varios
	public String toString()
	{
		return "@" + identificador + " (" + nombre + ")";
	}
	public ArrayList<Usuario> obtenerSeguidores()
	{
		return getSeguidores();
	}
	public ArrayList<Usuario> obtenerSiguiendo()
	{
		return getSiguiendo();
	}
	public String obtenerIdentificador()
	{
		return getIdentificador();
	}
	public void seguir(Usuario usuario)
	{
		if(this.equals(usuario))
		{
			System.out.println("Un usuario no se puede seguir a si mismo");
		}
		else
			if(siguiendo.contains(usuario))
			{
				System.out.println("El usuario activo ya sigue a este usuario");
			}
			else
			{
				siguiendo.add(usuario);
				usuario.seguidores.add(this);
			}
	}
	public void borrarDatos(ArrayList<Tweet> listaTweets)
	{	
		for(int i = 0; i < seguidores.size(); i++)
		{
			seguidores.get(i).siguiendo.remove(this);
		}
		for(int i = 0; i < siguiendo.size(); i++)
		{
			siguiendo.get(i).seguidores.remove(this);
		}
		for(int i = 0; i < listaTweets.size(); i++)
		{
			if(this.equals(listaTweets.get(i).obtenerUsuario()))
			{
				listaTweets.remove(listaTweets.get(i));
			}
		}
		for(Iterator<Tweet> itTweets = listaTweets.iterator(); itTweets.hasNext();)
		{
			if(this.equals(itTweets.next().obtenerUsuario()))
			{
				itTweets.remove();
			}
		}
		for(Iterator<Tweet> itTweets = listaTweets.iterator(); itTweets.hasNext();)
		{
			for(Iterator<Usuario> itLikes = itTweets.next().obtenerLikes().iterator(); itLikes.hasNext();)
			{
				if(this.equals(itLikes.next()))
				{
					itLikes.remove();
				}
			}
		}
	}
	public void mostrarTweets(Usuario usuario, ArrayList<Tweet> listaTweets, boolean mostrarPH)
	{
		if(siguiendo.contains(usuario) && this != usuario)
		{
			boolean tieneTweets = false;
			int i = 0;
			for(Tweet tweet : listaTweets)
			{
				if(usuario.equals(tweet.obtenerUsuario()))
				{
					tieneTweets = true;
					System.out.println(i + ":\n\tTexto:");
					tweet.mostrarTexto();
					if(mostrarPH)
					{
						System.out.println("\tPalabras:");
						tweet.mostrarPalabras(true);
						System.out.println("\tHashtags:");
						tweet.mostrarHashtags(true);
					}
					i++;
				}
			}
			if(!tieneTweets)
			{
				System.out.println("Este usuario no tiene tweets");
			}
		}
		else
		{
			System.out.println("El usuario activo no sigue al usuario ingresado o se ingreso el mismo usuario");
		} // fin del else
	} // fin del metodo
} // fin de la clase