/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to reverse the order of an integer array.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Recursion05{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int length = sc.nextInt();
		int[] numbers = new int[length];
		for(int i = 0; i < length; i++){
			numbers[i] = sc.nextInt();
		}

		System.out.printf(reverse(numbers));
	}

	public static String reverse(int[] numbers){
		if(numbers.length == 1){
			return Integer.toString(numbers[0]);
		}
		return String.format("%d%n%s", numbers[numbers.length - 1], reverse(Arrays.copyOfRange(numbers, 0, numbers.length - 1)));
	}
}