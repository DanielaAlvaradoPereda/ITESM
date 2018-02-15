/*
 * Daniela Alvarado Pereda A01329233
 * 14/09/2017
 * This class creates an array of objects of the class Fraction and demonstrates different sorting algorithms.
 */
import java.util.Arrays;
import java.util.Scanner;

public class FracArray{
	// attributes
	private Fraction[] fractions;

	// constructor
	public FracArray(Scanner sc){
		int length = sc.nextInt();
		fractions = new Fraction[length];

		for(int i = 0; i < length; i++){
			int num = sc.nextInt();
			int den = sc.nextInt();
			fractions[i] = new Fraction(num, den);
		}
	}
	public FracArray(Fraction[] fractions){
		this.fractions = fractions;
	}

	// gets
	public Fraction[] getFractions(){
		return fractions;
	}

	// methods
	public String toString(){
		if(fractions.length == 0){
			throw new IllegalStateException("No fractions were introduced");
		}
		
		String string = "";
		int field = maxLength();
		for(int i = 0; i < fractions.length; i++){
			string += (i == 0 ? "" : "\n") + fractions[i].toString(field);
		}
		return string;
	}
	public int maxLength(){
		int max = 0;
		for(Fraction fraction : fractions){
			fraction.simplify();
			max = Math.max(Math.max(Integer.toString(fraction.getNum()).length(), Integer.toString(fraction.getDen()).length()), max);
		}
		return max;
	}
	public FracArray selectionSort(){
		Fraction[] sorted = fractions.clone();
		for(int i = 0; i < sorted.length; i++){
			int min = i;
			for(int j = i + 1; j < sorted.length; j++){
				if(sorted[j].compareTo(sorted[min]) == -1){
					min = j;
				}
			}
			Fraction temp = sorted[i];
			sorted[i] = sorted[min];
			sorted[min] = temp;
		}
		return new FracArray(sorted);
	}
	public FracArray insertionSort(){
		Fraction[] sorted = fractions.clone();
		for(int i = 1; i < sorted.length; i++){
			Fraction temp = sorted[i];
			int j;
			for(j = i - 1; j >= 0 && temp.compareTo(sorted[j]) == -1; j--){
				sorted[j + 1] = sorted[j];
			}
			sorted[j + 1] = temp;
		}
		return new FracArray(sorted);
	}
	public FracArray bubbleSort(){
		Fraction[] sorted = fractions.clone();
		boolean swap;
		int length = sorted.length - 1;
		do{
			swap = false;
			for(int i = 0; i < length; i++){
				if(sorted[i].compareTo(sorted[i + 1]) == 1){
					Fraction temp = sorted[i];
					sorted[i] = sorted[i + 1];
					sorted[i + 1] = temp;
					swap = true;
				}
			}
			length--;
		}while(swap);
		return new FracArray(sorted);
	}
	public FracArray mergeSort(){
		Fraction[] sorted = fractions.clone();
		if(sorted.length == 1){
			return new FracArray(sorted);
		}

		int midpoint = sorted.length / 2;
		Fraction[] half1 = new FracArray(Arrays.copyOfRange(sorted, 0, midpoint)).mergeSort().getFractions();
		Fraction[] half2 = new FracArray(Arrays.copyOfRange(sorted, midpoint, sorted.length)).mergeSort().getFractions();

		int i = 0;
		int j = 0;
		int k = 0;
		for(; j < half1.length && k < half2.length; i++){
			if(half1[j].compareTo(half2[k]) == -1){
				sorted[i] = half1[j];
				j++;
			}
			else{
				sorted[i] = half2[k];
				k++;
			}
		}

		for(; j < half1.length; i++, j++){
			sorted[i] = half1[j];
		}
		for(; k < half2.length; i++, k++){
			sorted[i] = half2[k];
		}

		return new FracArray(sorted);
	}
	public FracArray quickSort(Fraction[] sorted, int start, int end){
		Fraction temp;
		if(start >= end){
			return new FracArray(sorted);
		}
		Fraction pivot = sorted[end];
		int j = start;
		for(int i = start; i  < end; i++){
			if(sorted[i].compareTo(pivot) == -1){
				temp = sorted[j];
				sorted[j] = sorted[i];
				sorted[i] = temp;
				j++;
			}
		}

		sorted[end] = sorted[j];
		sorted[j] = pivot;

		quickSort(sorted, start, j - 1);
		quickSort(sorted, j + 1, end);

		return new FracArray(sorted);
	}
}