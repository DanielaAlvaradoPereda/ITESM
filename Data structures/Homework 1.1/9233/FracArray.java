/*
 * Daniela Alvarado Pereda A01329233
 * 24/08/2017
 * This class creates an array of objects of the class Fraction and uses its methods.
 */
import java.util.Arrays;
import java.util.Scanner;

public class FracArray{
	// attributes
	private Fraction[] fractions;

	// constructor
	public FracArray(){
		fractions = new Fraction[0];
	}

	// methods
	public void read(Scanner sc){
		System.out.printf("Enter the number of fractions: ");
		int length = sc.nextInt();
		fractions = new Fraction[length];

		for(int i = 0; i < length; i++){
			System.out.printf("Enter fraction %d numerator: ", i);
			int num = sc.nextInt();
			System.out.printf("Enter fraction %d denominator: ", i);
			int den = sc.nextInt();
			fractions[i] = new Fraction(num, den);
		}
	}
	public Fraction getSum(){
		if(fractions.length == 0){
			throw new IllegalStateException("No fractions were introduced");
		}

		Fraction sum = new Fraction(0, 1);
		for(Fraction fraction : fractions){
			sum = sum.add(fraction);
		}

		return sum;
	}
	public Fraction getAverage(){
		if(fractions.length == 0){
			throw new IllegalStateException("No fractions were introduced");
		}

		Fraction average = getSum().mul(new Fraction(1, fractions.length));
		return average;
	}
	public void showSorted(){
		if(fractions.length == 0){
			throw new IllegalStateException("No fractions were introduced");
		}
		
		int field = maxLength();
		Arrays.sort(fractions);
		for(Fraction fraction : fractions){
			System.out.printf("%s%n", fraction.toString(field));
		}
	}
	public int maxLength(){
		int max = 0;
		for(Fraction fraction : fractions){
			fraction.simplify();
			max = Math.max(Math.max(Integer.toString(fraction.getNum()).length(), Integer.toString(fraction.getDen()).length()), max);
		}
		return max;
	}
}