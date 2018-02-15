
// descripcion de la clase Punto
public class Punto
{	
	// definicion de atributos de la clase
	protected double x;
	protected double y;

	// definicion de constructores
	public Punto()
	{
		x = 0;
		y = 0;
	}
	public Punto(double xa, double ya)
	{
		x = xa;
		y = ya;
	}

	// definicion de getters
	private double getX()
	{
		return this.x;
	}
	private double getY()
	{

		return this.y;
	}

	// definicion de setters
	private void setX(double x)
	{
		this.x = x;
	}
	private void setY(double y) {

		this.y = y;
	}

	// definicion de metodos
	// reemplaza el valor del punto por lo propocionado por el usuario
	public double leeX()
	{
		return getX();
	}
	public double leeY()
	{
		return getY();
	}

	// definicion de setters
	public void modificaX(double x)
	{
		setX(x);
	}
	public void modificaY(double y)
	{
		setY(y);
	}
	public void modificaPunto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	// incrementa los valores de x e y con los proporcionados
	// por el usuario
	public void muevePunto(double x, double y)
	{
		this.x = this.x + x;
		this.y = this.y + y;
	}
}