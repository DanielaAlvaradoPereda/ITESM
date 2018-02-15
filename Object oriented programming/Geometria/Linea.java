public class Linea
{
	// atributos
	private Punto p1;
	private Punto p2;

	// constructores
	public Linea()
	{
		p1 = new Punto();
		p2 = new Punto();
	}
	public Linea(Punto p1, Punto p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	public Linea(double x1, double y1, double x2, double y2)
	{
		p1 = new Punto(x1, y1);
		p2 = new Punto(x2, y2);
	}

	// sets y gets
	public void setp1(Punto p1)
	{
		this.p1 = p1;
	}
	public void setp2(Punto p2)
	{
		this.p2 = p2;
	}
	public Punto getp1()
	{
		return p1;
	}
	public Punto getp2()
	{
		return p2;
	}

	// metodos varios
	public void modificar(Punto p1, Punto p2)
	{
		setp1(p1);
		setp2(p2);
	}
	public void mover(double x, double y)
	{
		p1.mover(x, y);
		p2.mover(x, y);
	}
	public void mostrar()
	{
		p1.mostrar();
		System.out.print(", ");
		p2.mostrar();
	} // fin del metodo muestra
} 