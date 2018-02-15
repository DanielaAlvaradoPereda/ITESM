
public class Bolsa<T> 
{
	private T objeto;
	 
	public Bolsa(T objeto)
	{
		this.objeto = objeto;
	}

	public void TipoClase()
	{
    	System.out.println("El tipo de T es " + objeto.getClass().getName());
  	}
 
}