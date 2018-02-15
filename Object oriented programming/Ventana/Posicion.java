public class Posicion
{
	// atributos
	private double x;
	private double y;

	// constructor
	public Posicion()
	{
		x = 200;
		y = 50;
	}

	// sets y gets
	private void setx(double x)
	{
		this.x = x;
	}
	private void sety(double y)
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
	public void mover(double x, double y)
	{
		setx(x);
		sety(y);
	}
}