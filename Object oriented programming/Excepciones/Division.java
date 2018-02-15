import java.util.Scanner;

public class Division
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el dividendo: ");
		int dividendo = sc.nextInt();
		System.out.print("Ingrese el divisor: ");
		int divisor = sc.nextInt();

		try
		{
			System.out.printf("El resultado de la division entera es: %d", dividendo / divisor);
		}
		catch(ArithmeticException e)
		{
			System.out.print("Excepcion, division entre cero: " + e);
		}
	}
}