/*
 * Daniela Alvarado Pereda A01329233
 * 09/10/2017
 * This program uses pointers to determine wether a string is a palindrome or not.
 */
#include <stdio.h>
 
int main (){
	int n;
	scanf("%d\n", &n);

	for(int i = 0; i < n; i++){
		char string[1026]; // 1024 + '\n' + '\0'
		fgets(string, 1026, stdin);
		char* ptc1 = string;

		int size = 0;
		while(*(ptc1 + size) != '\n'){
			size++;
		}
		char* ptc2 = ptc1 + --size;

		int p = 1;
		while(ptc1 < ptc2){
			if(*ptc1 != *ptc2){
				p = 0;
				break;
			}
			ptc1++;
			ptc2--;
		}

		printf("%s\n", p ? "YES" : "NO");
	}
}