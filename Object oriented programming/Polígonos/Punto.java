public class Punto
{
	// atributos
	private double x;
	private double y;

	//constructores
	public Punto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	// sets
	private void setX(double x)
	{
		this.x = x;
	}
	private void setY(double y)
	{
		this.y = y;
	}

	// gets
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}

	// metodos varios
	public void modificar(double x, double y)
	{
		setX(x);
		setY(y);
	}
	public void mover(double x, double y)
	{
		setX(this.x + x);
		setY(this.y + y);
	}
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
}