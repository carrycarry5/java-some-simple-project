package CoffeeTrain;

import java.util.Arrays;
import java.util.Scanner;

public class ModifyAmount {
	SetCoffee setCoffee = new SetCoffee();
	Object[] arr = setCoffee.set();
	
	//ChangeBill changeBill = new ChangeBill();
	
	ChooseCoffee chooseCoffee = new ChooseCoffee();
	Bill bill = new Bill();
	
	public void modify(){
		
		ChangeBill changeBill = new ChangeBill();
		
		
		System.out.println("请输入您要修改商品的序号：");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		Coffee c = (Coffee) arr[a-1];
		
		System.out.println("请输入修改后的数量：");
		
		int b = sc.nextInt();
		
		System.out.println("您确定要修改\""+c.getName()+"\"            数量为："+b+"?");
		System.out.println("修改请按1，不修改请按任意键");
		
		int d = sc.nextInt();
		
		if(d==1){
			
			changemon(a,b,c);
			
			System.out.println("新的账单：");
			bill.show();
		}
		else{
			System.out.println("请问是否还要继续修改账单？");
			changeBill.change();
		}

	}
	
	public int which(int a){
		for(int i =0 ;i<chooseCoffee.num.length ; i++){
			if(chooseCoffee.num[i]==a){
				return i;
			}	
		}
		return -1;
	}
	
	public void changemon(int a,int b , Coffee c){
		if(chooseCoffee.amo[which(a)] < b){
			chooseCoffee.money += (b-chooseCoffee.amo[which(a)]) * c.getPrice();
		}
		else{
			chooseCoffee.money -= (chooseCoffee.amo[which(a)] - b) * c.getPrice();
		}
		chooseCoffee.amo[which(a)]=b;
	}
}
