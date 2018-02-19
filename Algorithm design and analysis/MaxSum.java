/*
 * Daniela Alvarado Pereda A01329233
 * 12/02/2018
 * Obtiene la suma maxima contigua de un arreglo.
 */
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSum{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.printf("Ingrese el numero de elementos del arreglo: ");
		int n = sc.nextInt();

		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			System.out.printf("Ingrese el elemento %d: ", i);
			array[i] = sc.nextInt();
		}

		int[] result = maxSum(array, 0, array.length - 1);
		System.out.printf("%nSuma maxima: %d%nIndice inicial: %d%nIndice final: %d", result[0], result[1], result[2]);
	}

	public static int[] maxSum(int[] array, int first, int last){
		int[] result = new int[3];
		if(first == last){
			result[0] = array[first];
			result[1] = first;
			result[2] = last;
			return result;
		}

		int[] left = maxSum(array, first, (last - first + 1) / 2 - 1 + first);
		int[] right = maxSum(array, (last - first + 1) / 2 + first, last);
		int[] middle = middleSum(array, first, (last - first + 1) / 2 - 1 + first, (last - first + 1) / 2 + first, last);

		result = left[0] >= right[0] ? (left[0] >= middle[0] ? left : middle) : (right[0] >= middle[0] ? right : middle);
		return result;

	}

	public static int[] middleSum(int[] array, int lFirst, int lLast, int rFirst, int rLast){
		int[] result = new int[3];
		int i = lLast;
		int lMax = Integer.MIN_VALUE;
		int lSum = 0;
		result[1] = lLast;
		while(i >= lFirst){
			lSum += array[i];
			if(lSum > lMax){
				lMax = lSum;
				result[1] = i;
			}
			i--;
		}

		i = rFirst;
		int rMax = Integer.MIN_VALUE;
		int rSum = 0;
		result[2] = rFirst;
		while(i <= rLast){
			rSum += array[i];
			if(rSum > rMax){
				rMax = rSum;
				result[2] = i;
			}
			i++;
		}

		result[0] = lMax + rMax;
		return result;
	}
}