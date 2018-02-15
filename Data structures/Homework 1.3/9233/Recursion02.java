/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to count the occurrences of a character in a string.
 */
import java.util.Scanner;

public class Recursion02{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		char c = sc.nextLine().charAt(0);
		String s = sc.nextLine();

		System.out.printf("%d", countChar(c, s));
	}

	public static int countChar(char c, String s){
		if(s.length() == 1){
			return s.charAt(0) == c ? 1 : 0;
		}
		return (s.charAt(0) == c ? 1: 0) + countChar(c, s.substring(1));
	}
}