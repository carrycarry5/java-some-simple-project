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
		
		
		System.out.println("��������Ҫ�޸���Ʒ����ţ�");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		Coffee c = (Coffee) arr[a-1];
		
		System.out.println("�������޸ĺ��������");
		
		int b = sc.nextInt();
		
		System.out.println("��ȷ��Ҫ�޸�\""+c.getName()+"\"            ����Ϊ��"+b+"?");
		System.out.println("�޸��밴1�����޸��밴�����");
		
		int d = sc.nextInt();
		
		if(d==1){
			
			changemon(a,b,c);
			
			System.out.println("�µ��˵���");
			bill.show();
		}
		else{
			System.out.println("�����Ƿ�Ҫ�����޸��˵���");
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
