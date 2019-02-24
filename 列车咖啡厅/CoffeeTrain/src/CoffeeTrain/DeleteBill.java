package CoffeeTrain;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteBill {
	SetCoffee setCoffee = new SetCoffee();
	Object[] arr = setCoffee.set();
	
	Bill bill = new Bill();
	//ChangeBill changeBill = new ChangeBill();
	ChooseCoffee chooseCoffee = new ChooseCoffee();

	
	public void delete(){
		ChangeBill changeBill = new ChangeBill();
		

		System.out.println("请输入要删除商品的序号：");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		Coffee c = (Coffee) arr[a-1];
		
		System.out.println("您确定要删除\""+c.getName()+"\"                   数量为："+chooseCoffee.amo[which(a)]+"    ?");
		System.out.println("删除请按1，不删除请按任意键");
		
		int b = sc.nextInt();        
		
		if(b==1){                                                       //修改费用
			Coffee d = (Coffee) arr[which(a)];
			chooseCoffee.money-=d.getPrice()*chooseCoffee.amo[which(a)];
			deletenum(a);
			
			System.out.println("新的账单：");
			chooseCoffee.num = Arrays.copyOfRange(chooseCoffee.num, 0,chooseCoffee.num.length-1);
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
	
	public void deletenum(int a){
		for(int i =which(a);i< chooseCoffee.num.length-1;i++){
			chooseCoffee.num[i] = chooseCoffee.num[i+1];
			chooseCoffee.amo[i] = chooseCoffee.amo[i+1];
		}
	}
	
}
