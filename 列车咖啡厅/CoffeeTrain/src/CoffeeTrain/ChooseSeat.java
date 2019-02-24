package CoffeeTrain;

import java.util.Scanner;

public class ChooseSeat {
	Limit limit = new Limit();
	
	static public int a;
	
	public void choose() {
	
		Scanner sc=new Scanner(System.in);
		a = sc.nextInt(); 
		while(limit.lim(a, 1, 5)){
			a = sc.nextInt(); 
		}
	}
}
