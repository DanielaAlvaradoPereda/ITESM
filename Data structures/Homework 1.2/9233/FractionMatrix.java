/*
 * Daniela Alvarado Pereda A01329233
 * 24/08/2017
 * This class represents a matrix of fractions as an object.
 */
import java.util.Scanner;

public class FractionMatrix{
	// attributes
	private Fraction[][] matrix;

	// constructors
	public FractionMatrix(int rows, int cols){
		matrix = new Fraction[rows][cols];
	}
	public FractionMatrix(int rows, int cols, Scanner sc, String tag){
		matrix = new Fraction[rows][cols];
		for(int row = 0; row < rows; row++){
			for(int column = 0; column < cols; column++){
				System.out.printf("Enter numerator for fraction in postion (%d, %d) of matrix %s: ", row, column, tag);
				int num = sc.nextInt();
				System.out.printf("Enter denominator for fraction in postion (%d, %d) of matrix %s: ", row, column, tag);
				int den = sc.nextInt();
				matrix[row][column] = new Fraction(num, den);
			}
		}
	}

	// other methods
	public static boolean mulIsPossible(int colsA, int rowsB){
		return colsA == rowsB ? true : false;
	}
	public FractionMatrix multiply(FractionMatrix matrixB){
		FractionMatrix result = new FractionMatrix(matrix.length, matrixB.matrix[0].length);

		for(int i = 0; i < result.matrix.length; i++){
			for(int j = 0; j < result.matrix[i].length; j++){
				result.matrix[i][j] = new Fraction(0, 1);
				for(int k = 0; k < matrix[i].length; k++){
					result.matrix[i][j] = result.matrix[i][j].add(matrix[i][k].mul(matrixB.matrix[k][j]));
				}
			}
		}
		return result;
	}
	public int maxLength(){
		int max = 0;
		for(Fraction[] row : matrix){
			for(Fraction fraction : row){
				fraction.simplify();
				max = Math.max(Math.max(Integer.toString(fraction.getNum()).length(), Integer.toString(fraction.getDen()).length()), max);
			}		
		}
		return max;
	}
	public void print()
	{
		int field = maxLength();
		for(Fraction[] row : matrix){
			for(Fraction fraction : row){
				System.out.printf("%s  ", fraction.toString(field));
			}
			System.out.println();
		}
	}
}