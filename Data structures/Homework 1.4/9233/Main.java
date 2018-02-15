/*
 * Daniela Alvarado Pereda A01329233
 * 14/09/2017
 * This class demonstrates different sorting algorithms and compares their execution times.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		FracArray array = new FracArray(sc);
		String[] sorted = new String[5];
		long start;
		long end;
		long[] times = new long[5];

		start = System.nanoTime();
		sorted[0] = array.selectionSort().toString();
		end = System.nanoTime();
		times[0] = end - start;
		
		start = System.nanoTime();
		sorted[1] = array.insertionSort().toString();
		end = System.nanoTime();
		times[1] = end - start;

		start = System.nanoTime();
		sorted[2] = array.bubbleSort().toString();
		end = System.nanoTime();
		times[2] = end - start;
		
		start = System.nanoTime();
		sorted[3] = array.mergeSort().toString();
		end = System.nanoTime();
		times[3] = end - start;

		start = System.nanoTime();
		sorted[4] = array.quickSort(array.getFractions(), 0, array.getFractions().length - 1).toString();
		end = System.nanoTime();
		times[4] = end - start;

		System.out.printf("selection sort:%n%s%ninsertion sort:%n%s%nbubble sort:%n%s%nmerge sort:%n%s%nquick sort:%n%s%n%n", sorted[0], sorted[1], sorted[2],
			sorted[3], sorted[4]);

		long[] sortedTimes = times.clone();
		Arrays.sort(sortedTimes);
		for(long sortedTime : sortedTimes){
			for(int i = 0; i < times.length; i++){
				if(sortedTime == times[i]){
					switch(i){
						case 0:
							System.out.printf("selection sort: ");
							break;
						case 1:
							System.out.printf("insertion sort: ");
							break;
						case 2:
							System.out.printf("bubble sort: ");
							break;
						case 3:
							System.out.printf("merge sort: ");
							break;
						case 4:
							System.out.printf("quick sort: ");
							break;
					}
					System.out.println(sortedTime / Math.pow(10, 9));
					break;
				}
			}
		}
	}
}