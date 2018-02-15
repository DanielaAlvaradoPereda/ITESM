/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to reverse the digits of an integer.
 */
import java.util.Scanner;

public class Recursion07{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.printf("%d", reverse(n));
	}

	public static int reverse(int n){
		if(n / 10 < 1){
			return n;
		}
		return Integer.parseInt((Integer.toString(n % 10) + reverse(n / 10)));
	}
}