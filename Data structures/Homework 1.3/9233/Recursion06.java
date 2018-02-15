/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to reverse the characters of a string.
 */
import java.util.Scanner;

public class Recursion06{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		System.out.printf(reverse(s));
	}

	public static String reverse(String s){
		if(s.length() == 1){
			return s;
		}
		return s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
	}
}