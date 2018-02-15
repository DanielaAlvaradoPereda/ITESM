import java.util.ArrayList;
import java.util.Date;

public abstract class Publicacion
{
	// atributos
	private String titulo;
	private Date fecha;
	private String texto;
	private ArrayList<String> etiquetas;

	// sets y gets
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
	public void setTexto(String texto)
	{
		this.texto = texto;
	}
	public void setEtiquetas(ArrayList<String> etiquetas)
	{
		this.etiquetas = etiquetas;
	}
	public String getTitulo()
	{
		return titulo;
	}
	public Date getFecha()
	{
		return fecha;
	}
	public String getTexto()
	{
		return texto;
	}
	public ArrayList<String> getEtiquetas()
	{
		return etiquetas;
	}
}