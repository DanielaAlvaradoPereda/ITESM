import java.util.Scanner;

public class RecursiveFactorial{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.printf("Enter a number: ");
		int n = sc.nextInt();

		System.out.printf("Factorial of %d is %d", n, factorial(n));
	}

	public static int factorial(int n){
		if(n <= 1){
			return 1;
		}
		return n * factorial(n - 1);
	}
}