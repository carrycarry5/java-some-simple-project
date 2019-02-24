package CoffeeTrain;

import java.util.Arrays;
import java.util.Scanner;

public class AddBill {
	SetCoffee setCoffee = new SetCoffee();
	Object[] arr = setCoffee.set();
	
	ShowCoffee showCoffee = new ShowCoffee();
	ChooseCoffee chooseCoffee = new ChooseCoffee();
	Bill bill = new Bill();
	
	public void add(){
		showCoffee.show();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请问还要点什么？");
		System.out.println("请输入咖啡的序号：");
		
		int a = sc.nextInt();
		
		chooseCoffee.num=Arrays.copyOf(chooseCoffee.num, (ChooseCoffee.num.length+1));
		chooseCoffee.num[chooseCoffee.num.length-1]=a;
		
		Coffee c = (Coffee) arr[a-1];
		
		System.out.println("您选择了"+c.getName());
		System.out.println("请选择数量");
		
		int b = sc.nextInt();
		
		chooseCoffee.amo=Arrays.copyOf(chooseCoffee.amo, ChooseCoffee.amo.length+1);
		chooseCoffee.amo[chooseCoffee.amo.length-1]=b;
		
		changemon(c,b);
		
		System.out.println("新账单：");
		bill.show();
	}
	
	public void changemon(Coffee c ,int b){
		chooseCoffee.money += c.getPrice()*b;
	}
}
