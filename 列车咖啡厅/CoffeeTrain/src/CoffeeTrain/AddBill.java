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
		
		System.out.println("���ʻ�Ҫ��ʲô��");
		System.out.println("�����뿧�ȵ���ţ�");
		
		int a = sc.nextInt();
		
		chooseCoffee.num=Arrays.copyOf(chooseCoffee.num, (ChooseCoffee.num.length+1));
		chooseCoffee.num[chooseCoffee.num.length-1]=a;
		
		Coffee c = (Coffee) arr[a-1];
		
		System.out.println("��ѡ����"+c.getName());
		System.out.println("��ѡ������");
		
		int b = sc.nextInt();
		
		chooseCoffee.amo=Arrays.copyOf(chooseCoffee.amo, ChooseCoffee.amo.length+1);
		chooseCoffee.amo[chooseCoffee.amo.length-1]=b;
		
		changemon(c,b);
		
		System.out.println("���˵���");
		bill.show();
	}
	
	public void changemon(Coffee c ,int b){
		chooseCoffee.money += c.getPrice()*b;
	}
}
