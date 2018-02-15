public class Canela extends DecoradorCondimento
{
	Bebida bebida;
	
	public Canela (Bebida bebida)
	{
		this.bebida = bebida;
	}
		
	public String getDescripcion()
	{
		return bebida.getDescripcion() + ", Canela";
	}
	public double costo()
	{
		return 3 + bebida.costo();
	}
}