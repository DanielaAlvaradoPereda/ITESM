/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to determine the sum of the digits of an integer.
 */
import java.util.Scanner;

public class Recursion08{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.printf("%d", sum(n));
	}

	public static int sum(int n){
		if(n / 10 < 1){
			return n;
		}
		return n % 10 + sum(n / 10);
	}
}