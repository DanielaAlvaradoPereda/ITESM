public class Crema extends DecoradorCondimento
{
	Bebida bebida;
	
	public Crema (Bebida bebida)
	{
		this.bebida = bebida;
	}
		
	public String getDescripcion()
	{
		return bebida.getDescripcion() + ", Crema";
	}
	public double costo()
	{
		return 4 + bebida.costo();
	}
}