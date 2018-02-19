/*
 * Daniela Alvarado Pereda A01329233
 * 01/02/2018
 * Compara 4 algoritmos de ordenamiento segun el numero de comparaciones que realizan para arreglos ordenados y desordenados de diferentes tamanos.
 */
import java.security.SecureRandom;
import java.util.Arrays;

public class ComparacionAlgoritmos{
	private static int BScounter;
	private static int HScounter;
	private static int MScounter;
	private static int QScounter;

	public static void main(String[] args){
		SecureRandom rand = new SecureRandom();
		int[][] arrays = new int[12][];
		boolean overflow = false;

		for(int i = 0; i < 3; i++){
			System.out.printf(i == 0 ? "Orden ascendente:%n" : i == 1 ? "Orden descendente%n" : "Orden aleatorio%n");
			for(int row = i * 4; row < i * 4 + 4; row++){
				overflow = false;
				BScounter = HScounter = MScounter = QScounter = 0;
				arrays[row] = new int[(int)Math.pow(10, row - 4 * i + 1)];
				for(int col = 0; col < arrays[row].length; col++){
					arrays[row][col] = i == 0 ? col : i == 1 ? arrays[row].length - 1 - col : rand.nextInt(100000);
				}
				bubbleSort(arrays[row].clone());
				heapSort(arrays[row].clone());
				mergeSort(arrays[row].clone());
				try{
					quickSort(arrays[row].clone(), 0, arrays[row].length - 1);
				}
				catch(StackOverflowError e){
					overflow = true;
				}
				System.out.printf("\tTamano %d%n\t\tBubble sort: %d%n\t\tHeap sort: %d%n\t\tMerge sort: %d%n\t\tQuick sort: %d " +
					(overflow ? "(antes de causar stack overflow)%n" : "%n"), arrays[row].length, BScounter, HScounter, MScounter, QScounter);
			}
		}
	}

	public static int[] bubbleSort(int[] array){
		int length = array.length - 1;
		int counter = 0;
		boolean swap = true;

		while(swap && length != 0){
			swap = false;
			for(int i = 0; i < length; i++){
				BScounter++;
				if(array[i] > array[i + 1]){
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swap = true;
				}
			}
			length--;
		}
		return array;
	}

	public static int[] heapSort(int[] array){
		int length = array.length;
		int counter = 0;

		for(int i = length / 2 - 1; i >= 0; i--){
			fixHeap(array, length, i);
		}

		for(int i = 0; i < array.length - 1; i++){
			int temp = array[0];
			array[0] = array[length - 1];
			array[length - 1] = temp;
			length--;
			fixHeap(array, length, 0);
		}

		return array;
	}

	public static void fixHeap(int[] array, int length, int i){
		if(2 * i + 1 >= length){
			return;
		}
		int max = 2 * i + 1;
		HScounter++;
		if(max + 1 < length && array[max + 1] > array[max]){
			max++;
		}
		HScounter++;
		if(array[max] > array[i]){
			int temp = array[max];
			array[max] = array[i];
			array[i] = temp;
			fixHeap(array, length, max);
		}
	}

	public static int[] mergeSort(int[] array){
		if(array.length == 1){
			return array;
		}
		merge(array, mergeSort(Arrays.copyOfRange(array, 0, array.length / 2)), mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length)));
		return array;
	}

	public static void merge(int[] array, int[] array1, int[] array2){
		int i = 0;
		int j = 0;
		while(i < array1.length && j < array2.length){
			MScounter++;
			if(array1[i] <= array2[j]){
				array[i + j] = array1[i];
				i++;
			}
			else{
				array[i + j] = array2[j];
				j++;
			}
		}

		while(i < array1.length){
			array[i + j] = array1[i];
			i++;
		}

		while(j < array2.length){
			array[i + j] = array2[j];
			j++;
		}
	}

	public static int[] quickSort(int[] array, int start, int end){
		if(start >= end){
			return array;
		}
		int j = start;
		for(int i = start; i < end; i++){
			QScounter++;
			if(array[i] < array[end]){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j++;
			}
		}
		int temp = array[j];
		array[j] = array[end];
		array[end] = temp;

		quickSort(array, start, j - 1);
		quickSort(array, j + 1, end);

		return array;
	}
}