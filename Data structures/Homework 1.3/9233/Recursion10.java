/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to determine wether a string is a palindrome or not.
 */
import java.util.Scanner;

public class Recursion10{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		System.out.printf(isPalindrome(s));
	}

	public static String isPalindrome(String s){
		s = s.replaceAll(" ", "").toLowerCase();
		if(s.charAt(0) == s.charAt(s.length() - 1)){
			if(s.length() <= 2){
				return "YES";
			}
			return isPalindrome(s.substring(1, s.length() - 1));	
		}
		return "NO";
	}
}