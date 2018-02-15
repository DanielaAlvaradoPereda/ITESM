/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to determine the minimum value of an array of integers.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Recursion03{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int length = sc.nextInt();
		int[] numbers = new int[length];
		for(int i = 0; i < length; i++){
			numbers[i] = sc.nextInt();
		}

		System.out.printf("%d", min(numbers));
	}

	public static int min(int[] numbers){
		if(numbers.length == 1){
			return numbers[0];
		}
		int min = min(Arrays.copyOfRange(numbers, 1, numbers.length));
		return numbers[0] < min ? numbers[0] : min;
	}
}