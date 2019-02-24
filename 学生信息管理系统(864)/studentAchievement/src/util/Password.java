package util;

import java.util.Scanner;

public class Password {
	public static void pass(){
		Scanner sc = new Scanner(System.in);
		String password = "123";
		while (true){
			String string = sc.nextLine();
			if (password.equals(string)) {
				break;
			}
			else{
				System.out.println("输入错误，请重新输入.");
			}
		}
	}
}
