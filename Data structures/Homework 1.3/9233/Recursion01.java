/*
 * Daniela Alvarado Pereda A01329233
 * 31/08/2017
 * This class uses recursion to determine wether two strings are equal or not.
 */
import java.util.Scanner;

public class Recursion01{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		System.out.printf(equal(s1, s2));
	}

	public static String equal(String s1, String s2){
		if(s1.charAt(0) == s2.charAt(0) && s1.length() == s2.length()){
			if(s1.length() == 1 && s2.length() == 1){
				return "YES";
			}
			return equal(s1.substring(1), s2.substring(1));
		}
		return "NO";
	}
}