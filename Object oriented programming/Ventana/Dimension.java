public class Dimension
{
	// atributos
	private double largo;
	private double ancho;

	// constructor
	public Dimension()
	{
		largo = 700;
		ancho = 400;
	}

	// sets y gets
	private void setLargo(double largo)
	{
		this.largo = largo;
	}
	private void setAncho(double ancho)
	{
		this.ancho = ancho;
	}
	public double getLargo()
	{
		return largo;
	}
	public double getAncho()
	{
		return ancho;
	}

	// metodos varios
	public void redimensionar(double largo, double ancho)
	{
		setLargo(largo);
		setAncho(ancho);
	}
}