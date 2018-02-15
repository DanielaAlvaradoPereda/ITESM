public class Nuez extends DecoradorCondimento {
	Bebida bebida;
	
	public Nuez (Bebida bebida) {
		this.bebida = bebida;
		}
		
	public String getDescripcion() {
		return bebida.getDescripcion() + ", Nuez";
		}
		
	public double costo() {
		return 15 + bebida.costo();
		}
}