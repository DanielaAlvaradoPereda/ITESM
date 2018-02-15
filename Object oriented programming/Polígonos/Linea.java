public class Linea
{
	// atributos
	private Punto p1;
	private Punto p2;

	// constructores
	public Linea(Punto p1, Punto p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}

	// sets
	private void setP1(Punto p1)
	{
		this.p1 = p1;
	}
	private void setP2(Punto p2)
	{
		this.p2 = p2;
	}

	// gets
	public Punto getP1()
	{
		return p1;
	}
	public Punto getP2()
	{
		return p2;
	}

	// metodos varios
	public void mover(double x, double y)
	{
		p1.mover(x, y);
		p2.mover(x, y);
	}
	public double calcularLongitud()
	{
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
	}
	public String toString()
	{
		return p1.toString() + ", " + p2.toString();
	}
}