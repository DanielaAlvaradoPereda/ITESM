public class Punto3D extends Punto
{
	// atributos
	private double z;

	// constructores
	public Punto3D()
	{
		x = 0;
		y = 0;
		z = 0;
	}
	public Punto3D(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// sets y gets
	public void setz(double z)
	{
		this.z = z;
	}
	public double getz()
	{
		return z;
	}

	// métodos varios
	public void modificar(double x, double y, double z)
	{
		setx(x);
		sety(y);
		setz(z);
	}
	public void mover(double x, double y, double z)
	{
		setx(this.x + x);
		sety(this.y + y);
		setz(this.z + z);
	}
	public void mostrar()
	{
		System.out.println("(" + x + ", " + y + ", " + z + ")");
	}
}