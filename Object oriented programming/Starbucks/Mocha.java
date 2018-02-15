public class Mocha extends DecoradorCondimento {
	Bebida bebida;
	
	public Mocha (Bebida bebida) {
		this.bebida = bebida;
		}
		
	public String getDescripcion() {
		return bebida.getDescripcion() + ", Mocha";
		}
		
	public double costo() {
		return 5 + bebida.costo();
		}
}