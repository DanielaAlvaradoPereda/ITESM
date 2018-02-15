/*
 * Daniela Alvarado Pereda A01329233
 * 17/08/2017
 * This class creates a FracArray object and allows the user to interact with it.
 */
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		FracArray array = new FracArray();
		boolean state = true;

		do{
			printOptions();
			int option = sc.nextInt();
			switch(option){
				case 1:
					array.read(sc);
					break;
				case 2:
					try{
						System.out.printf("The sum of the fractions is %s%n", array.getSum());
					}
					catch(IllegalStateException e){
						System.out.printf("%s%n", e.getMessage());
					}
					break;
				case 3:
					try{
						System.out.printf("The average of the fractions is %s%n", array.getAverage());
					}
					catch(IllegalStateException e){
						System.out.printf("%s%n", e.getMessage());
					}
					break;
				case 4:
					try{
						array.showSorted();
					}
					catch(IllegalStateException e){
						System.out.printf("%s%n", e.getMessage());
					}
					break;
				case 0:
					state = false;
					break;
				default:
					System.out.printf("Enter a valid option%n");
					break;
			}
		}while(state);
	}

	public static void printOptions(){
		System.out.printf("%n1. Read fractions%n" +
						  "2. Get sum of all the fractions%n" +
						  "3. Get average of all the fractions%n" +
						  "4. Show sorted fractions%n" +
						  "0. Exit%n" +
						  "%nChoose a valid option: ");
	}
}