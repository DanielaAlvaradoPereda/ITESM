/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to convert a number from base 10 to base 2.
 */
import java.util.Scanner;

public class Recursion09{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.printf(binary(n));
	}

	public static String binary(int n){
		if(n == 1){
			return "1";
		}
		return binary(n / 2) + n % 2;
	}
}