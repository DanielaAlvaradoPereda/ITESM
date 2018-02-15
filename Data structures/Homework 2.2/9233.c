/*
 * Daniela Alvarado Pereda A01329233
 * 12/10/2017
 * This program calculates the result of a matrix multiplication using pointers.
 */
#include <stdio.h>
#include <stdlib.h>

struct fraction{
	int num;
	int den;
};

void simplify(struct fraction* fraction){
	int gcd = abs(fraction -> num);
	int mod = abs(fraction -> den);

	while(mod != 0){
		int temp = gcd % mod;
		gcd = mod;
		mod = temp;
	}

	int num = fraction -> num;
	int den = fraction -> den;

	if(num > 0 && den > 0 || num < 0 && den < 0){
		fraction -> num = abs(num) / gcd;
	}
	else{
		fraction -> num = -abs(num) / gcd;
	}
	fraction -> den = abs(den) / gcd;
}

int maxLength(struct fraction* matrix, int size){
	int max = 0;
	for(int i = 0; i < size; i++){
		int digits = 0;
		int number = (matrix + i) -> num > (matrix + i) -> den ? (matrix + i) -> num : (matrix + i) -> den;

		while(number != 0){
			number /= 10;
			digits++;
		}
		if(digits > max){
			max = digits;
		}
	}
	return max;
}

void print(struct fraction* matrix, int rows, int cols){
	int field = maxLength(matrix, rows * cols);
	for(int row = 0; row < rows; row++){
		for(int col = 0; col < cols; col ++){
			printf("%*d/%*d  ", field, (matrix + cols * row + col) -> num, field, (matrix + cols * row + col) -> den);
		}
		printf("\n");
	}
}

struct fraction multiply(struct fraction fraction1, struct fraction fraction2){
	struct fraction result;
	result.num = fraction1.num * fraction2.num;
	result.den = fraction1.den * fraction2.den;

	simplify(&result);
	return result;
}

struct fraction add(struct fraction fraction1, struct fraction fraction2){
	int num;
	int den;

	if(fraction1.den == fraction2.den){
		num = fraction1.num + fraction2.num;
		den = fraction1.den;
	}
	else{
		num = fraction2.den * fraction1.num + fraction1.den * fraction2.num;
		den = fraction1.den * fraction2.den;
	}

	struct fraction result;
	result.num = num;
	result.den = den;

	simplify(&result);
	return result;
}

void multiplyMatrix(struct fraction* matrixA, struct fraction* matrixB, struct fraction* result, int rows, int cols, int colsA){
	for(int i = 0; i < rows; i++){
		for(int j = 0; j < cols; j++){
			(*(result + cols * i + j)).num = 0;
			(*(result + cols * i + j)).den = 1;
			for(int k = 0; k < colsA; k++){
				*(result + cols * i + j) = add(*(result + cols * i + j), multiply(*(matrixA + colsA * i + k), *(matrixB + cols * k + j)));
			}
		}
	}
}

void read(struct fraction* matrix, int rows, int cols, char tag){
	for(int row = 0; row < rows; row++){
		for(int col = 0; col < cols; col++){
			printf("Enter numerator for fraction in postion (%d, %d) of matrix %c: ", row, col, tag);
			scanf("%d", &((matrix + cols * row + col) -> num));

			printf("Enter denumerator for fraction in postion (%d, %d) of matrix %c: ", row, col, tag);
			scanf("%d", &((matrix + cols * row + col) -> den));

			simplify((matrix + cols * row + col));
		}
	}
}

int mulIsPossible(int colsA, int rowsB){
	return colsA == rowsB ? 1 : 0;
}

int main(){
	printf("Enter the number of rows for matrix A: ");
	int rowsA;
	scanf("%d", &rowsA);
	printf("Enter the number of columns for matrix A: ");
	int colsA;
	scanf("%d", &colsA);
	printf("Enter the number of rows for matrix B: ");
	int rowsB;
	scanf("%d", &rowsB);
	printf("Enter the number of columns for matrix B: ");
	int colsB;
	scanf("%d", &colsB);

	if(mulIsPossible(colsA, rowsB)){
		struct fraction matrixA[rowsA][colsA];
		struct fraction* pma = *matrixA;
		read(pma, rowsA, colsA, 'A');
		struct fraction matrixB[rowsB][colsB];
		struct fraction* pmb = *matrixB;
		read(pmb, rowsB, colsB, 'B');
		struct fraction result[rowsA][colsB];
		struct fraction* pmr = *result;
		multiplyMatrix(pma, pmb, pmr, rowsA, colsB, colsA);

		printf("\n");
		print(pma, rowsA, colsA);
		printf("\nX\n\n");
		print(pmb, rowsB, colsB);
		printf("\n=\n\n");
		print(pmr, rowsA, colsB);
	}
	else{
		printf("\nthe operation is impossible\n");
	}

	return 0;
}