package CoffeeTrain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IfPay {
	ChooseCoffee chooseCoffee = new ChooseCoffee();
	
	public void pay(){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if(a==1){
			System.out.println("一共"+chooseCoffee.money+"元");
					
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("结账时间："+df.format(new Date()));
			
			System.out.println("欢迎您的再次光临");
		}
		else{
			System.out.println("请您慢用。");
			System.out.println("--------------------------------------------------");
			System.out.println("请问是否结账呢？结账请按1，不结账请按任意键");
			pay();
		}
	}
}
