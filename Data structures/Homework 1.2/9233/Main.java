/*
 * Daniela Alvarado Pereda A01329233
 * 24/08/2017
 * This class demonstrates the classes Fraction and FractionMatrix using them to calculate the result of a matrix multiplication.
 */
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.printf("Enter the number of rows for matrix A: ");
		int rowsA = sc.nextInt();
		System.out.printf("Enter the number of columns for matrix A: ");
		int colsA = sc.nextInt();
		System.out.printf("Enter the number of rows for matrix B: ");
		int rowsB = sc.nextInt();
		System.out.printf("Enter the number of columns for matrix B: ");
		int colsB = sc.nextInt();

		if(FractionMatrix.mulIsPossible(colsA, rowsB)){
			FractionMatrix matrixA = new FractionMatrix(rowsA, colsA, sc, "matrix A");
			FractionMatrix matrixB = new FractionMatrix(rowsB, colsB, sc, "matrix B");
			FractionMatrix result = matrixA.multiply(matrixB);

			System.out.println();
			matrixA.print();
			System.out.printf("%nX%n%n");
			matrixB.print();
			System.out.printf("%n=%n%n");
			result.print();
		}
		else{
			System.out.printf("The operation is not possible");
		}
	}
}