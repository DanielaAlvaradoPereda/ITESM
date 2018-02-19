import java.util.Scanner;

public class RecursiveTriangle
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter a number: ");
		System.out.printf(triangle(sc.nextInt()));
	}

	public static String triangle(int n)
	{
		if(n == 1)
		{
			return "* ";
		}
		return line(n) + "\n" + triangle(n - 1);
	}

	public static String line(int n)
	{
		if(n == 1)
		{
			return "* ";
		}
		return "* " + line(n - 1);
	}
}