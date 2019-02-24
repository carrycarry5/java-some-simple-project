package CoffeeTrain;

import java.util.Scanner;

public class IfChangeBill {
	ChangeBill changeBill = new ChangeBill();
	
	public void change(){
		Scanner sc= new Scanner(System.in);
		String a;
		a= sc.nextLine();
		
		if (a.equals("1")) {
			changeBill.change();
		}
		else {
			System.out.println("好的，账单已确认。");
		}
	}
}
