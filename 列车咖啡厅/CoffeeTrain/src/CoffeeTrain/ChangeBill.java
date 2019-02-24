package CoffeeTrain;

import java.util.Scanner;

public class ChangeBill {
	AddBill addBill = new AddBill();
	ModifyAmount modifyAmount = new ModifyAmount();
	DeleteBill deleteBill = new DeleteBill();
	//Bill bill = new Bill();
	public void change(){
		Bill bill = new Bill();
		System.out.println("这是您之前的账单：");
		bill.show();
		
		System.out.println("删除订单请按1，修改数量请按2，添加订单请按3");
		System.out.println("------------------------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		switch(a){                                                        //选择操作
		case 1: deleteBill.delete(); 
			break;
		case 2: modifyAmount.modify(); 
			break;
		case 3: addBill.add();
		}
	}
}
