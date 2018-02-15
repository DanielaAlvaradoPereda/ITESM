public class Punto
{
	// atributos
	protected double x;
	protected double y;

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
	public void modificar(double x, double y)
	{
		setx(x);
		sety(y);
	}
	public void mover(double x, double y)
	{
		this.x += x;
		this.y += y;
	}
	public void mostrar()
	{
		System.out.println("(" + x + ", " + y + ")");
	} // fin del metodo muestra
} // fin de la clase