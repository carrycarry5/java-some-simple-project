package util;

import java.util.Scanner;

public class ScannString {
	public static String scannString(){
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		sc.close();
		return string;
	}
}
