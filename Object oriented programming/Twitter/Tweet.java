import java.util.ArrayList;
import java.util.Arrays;

public class Tweet
{
	// atributos
	private int id;
	private Usuario usuario;
	private String texto;
	private int longitud;
	private ArrayList<Usuario> likes;
	private ArrayList<String> palabras;
	private ArrayList<String> hashtags;

	// constructores
	public Tweet(int id, Usuario usuario, String texto)
	{
		this.id = id;
		this.usuario = usuario;
		this.texto = texto;
		longitud = texto.length();
		likes = new ArrayList<Usuario>();
		palabras = new ArrayList<String>(Arrays.asList(texto.split("[^\\p{L}0-9#]+")));
		hashtags = separarHashtags();
	}

	// sets
	private void setId(int id)
	{
		this.id = id;
	}
	private void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	private void setTexto(String texto)
	{
		this.texto = texto;
	}
	private void setLongitud(int longitud)
	{
		this.longitud = longitud;
	}
	private void setLikes(ArrayList<Usuario> likes)
	{
		this.likes = likes;
	}
	private void setPalabras(ArrayList<String> palabras)
	{
		this.palabras = palabras;
	}
	private void setHashtags(ArrayList<String> hashtags)
	{
		this.hashtags = hashtags;
	}

	// gets
	private int getId()
	{
		return id;
	}
	private Usuario getUsuario()
	{
		return usuario;
	}
	private String getTexto()
	{
		return texto;
	}
	private int getLongitud()
	{
		return longitud;
	}
	private ArrayList<Usuario> getLikes()
	{
		return likes;
	}
	private ArrayList<String> getPalabras()
	{
		return palabras;
	}
	private ArrayList<String> getHashtags()
	{
		return hashtags;
	}

	// metodos varios
	public ArrayList<String> separarHashtags()
	{
		ArrayList<String> hashtags = new ArrayList<String>();
		for(String palabra : palabras)
		{
			if(palabra.startsWith("#"))
			{
				hashtags.add(palabra);
			}
		}
		return hashtags;
	}
	public Usuario obtenerUsuario()
	{
		return getUsuario();
	}
	public int obtenerId()
	{
		return getId();
	}
	public ArrayList<Usuario> obtenerLikes()
	{
		return getLikes();
	}
	public void agregarLike(Usuario usuario)
	{
		likes.add(usuario);
	}
	public void mostrarTexto()
	{
		System.out.println("\t\t" + texto);
	}
	public void mostrarPalabras(boolean tab)
	{
		for(String palabra : palabras)
		{
			System.out.println((tab ? "\t\t" : "") + palabra);
		}
	}
	public void mostrarHashtags(boolean tab)
	{
		if(hashtags.isEmpty())
		{
			System.out.println((tab ? "\t\t" : "") + "No hay hashtags en este tweet");
		}
		else
		{
			for(String hashtag : hashtags)
			{
				System.out.println((tab ? "\t\t" : "") + hashtag);
			} // fin del for
		} // fin del else
	} // fin del metodo
} // fin de la clase