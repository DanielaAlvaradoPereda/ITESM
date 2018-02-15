public class Principal {
 
public static void main(String[] args) {
 
 	Chocolatina c= new Chocolatina("milka");
	Chocolatina c1= new Chocolatina("milka");
	Chocolatina c2= new Chocolatina("ferrero");
	Bolsa<Chocolatina> bolsa= new Bolsa<Chocolatina>(c);
	
	 
	bolsa.TipoClase();
	 
	}
 
}