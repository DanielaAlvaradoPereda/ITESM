import java.util.Scanner;

public class RecursiveMult{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.printf("Enter the first number ");
		int a = sc.nextInt();
		System.out.printf("Enter the second number ");
		int b = sc.nextInt();

		System.out.printf("%n%d * %d = %d", a, b, multiply(a, b));
	}

	public static int multiply(int a, int b){
		if(b == 1){
			return a;
		}
		return a + multiply(a, b - 1);
	}
}