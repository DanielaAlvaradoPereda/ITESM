public class Soya extends DecoradorCondimento {
	Bebida bebida;
	
	public Soya (Bebida bebida) {
		this.bebida = bebida;
		}
		
	public String getDescripcion() {
		return bebida.getDescripcion() + ", Soya";
		}
		
	public double costo() {
		return 12 + bebida.costo();
		}
}