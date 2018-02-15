public class Punto
{
	// atributos
	private double x;
	private double y;

	// constructores
	public Punto()
	{
		x = 0;
		y = 0;
	}
	public Punto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	// sets y gets
	public void setx(double x)
	{
		this.x = x;
	}
	public void sety(double y)
	{
		this.y = y;
	}
	public double getx()
	{
		return x;
	}
	public double gety()
	{
		return y;
	}

	// metodos varios
	public void mueve(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public void muestra()
	{
		System.out.println("(" + x + ", " + y + ")");
	} // fin del metodo muestra
} // fin de la clase
