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
			System.out.println("һ��"+chooseCoffee.money+"Ԫ");
					
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("����ʱ�䣺"+df.format(new Date()));
			
			System.out.println("��ӭ�����ٴι���");
		}
		else{
			System.out.println("�������á�");
			System.out.println("--------------------------------------------------");
			System.out.println("�����Ƿ�����أ������밴1���������밴�����");
			pay();
		}
	}
}
