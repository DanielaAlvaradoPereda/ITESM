import java.util.Scanner;
import java.lang.Math;

public class Distancia
{
	public static void main(String args[])
	{
		double x1 = leerValor("x1");
		double y1 = leerValor("y1");
		double x2 = leerValor("x2");
		double y2 = leerValor("y2");
		
		double distancia = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		System.out.println("La distancia entre los puntos es: " + distancia);
	}
	public static double leerValor(String etiqueta)
	{
		Scanner v1 = new Scanner(System.in);
		double valor;
		System.out.printf("Valor de %s: ", etiqueta);
		valor = v1.nextDouble();

		return valor;
	}
}