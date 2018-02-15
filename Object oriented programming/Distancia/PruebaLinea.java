import java.util.Scanner;

public class PruebaLinea
{
    public static void main(String args[])
    {
		double x1 = leerValor("x1");
		double y1 = leerValor("y1");
		double x2 = leerValor("x2");
		double y2 = leerValor("y2");
		
		Linea linea1 = new Linea(x1, y1, x2, y2);
		linea1.imprimirLongitud();
    }
    public static double leerValor(String etiqueta)
	{
		Scanner entrada = new Scanner(System.in);
		double valor;
		
		System.out.printf("Valor de %s: ", etiqueta);
		valor = entrada.nextDouble();

		return valor;
	}
}