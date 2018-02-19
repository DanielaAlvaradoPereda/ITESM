import java.util.Scanner;

public class RecursiveFibonacci{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.printf("Enter a number: ");
		int n = sc.nextInt();

		System.out.printf("Postion %d of fibonacci is %d", n, fibonacci(n));
	}

	public static int fibonacci(int n){
		if(n < 3){
			return 1;
		}
		return fibonacci(n - 1) + fibonacci (n - 2);
	}
}