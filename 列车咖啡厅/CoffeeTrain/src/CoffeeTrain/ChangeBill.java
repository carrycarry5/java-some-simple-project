package CoffeeTrain;

import java.util.Scanner;

public class ChangeBill {
	AddBill addBill = new AddBill();
	ModifyAmount modifyAmount = new ModifyAmount();
	DeleteBill deleteBill = new DeleteBill();
	//Bill bill = new Bill();
	public void change(){
		Bill bill = new Bill();
		System.out.println("������֮ǰ���˵���");
		bill.show();
		
		System.out.println("ɾ�������밴1���޸������밴2����Ӷ����밴3");
		System.out.println("------------------------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		switch(a){                                                        //ѡ�����
		case 1: deleteBill.delete(); 
			break;
		case 2: modifyAmount.modify(); 
			break;
		case 3: addBill.add();
		}
	}
}
