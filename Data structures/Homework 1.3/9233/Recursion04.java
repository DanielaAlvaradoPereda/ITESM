/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to determine the sum of all the elements of an integer array.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Recursion04{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int length = sc.nextInt();
		int[] numbers = new int[length];
		for(int i = 0; i < length; i++){
			numbers[i] = sc.nextInt();
		}

		System.out.printf("%d", sum(numbers));
	}

	public static int sum(int[] numbers){
		if(numbers.length == 1){
			return numbers[0];
		}
		return numbers[0] + sum(Arrays.copyOfRange(numbers, 1, numbers.length));
	}
}