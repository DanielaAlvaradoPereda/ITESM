public class Azucar extends DecoradorCondimento
{
	Bebida bebida;
	
	public Azucar (Bebida bebida)
	{
		this.bebida = bebida;
	}
		
	public String getDescripcion()
	{
		return bebida.getDescripcion() + ", Azucar";
	}
	public double costo()
	{
		return 2 + bebida.costo();
	}
}