package Train;

import java.util.Scanner;

public class SelectFunc {                                          //���๦�ܣ�ѡ��Ҫִ�еĲ���
	FindTicket findTicket = new FindTicket();
	Booking booking = new Booking() ;
	ReturnTicket returnTicket = new ReturnTicket();
	
	public void select(){

		Scanner scanner=new Scanner(System.in);
		
		int a = scanner.nextInt();
		
		while(true){                                                        //�ж������Ƿ�ϸ�
			if(a<1 || a >4){ 
				System.out.println("����������������룺");
				a = scanner.nextInt();
			}
			else break;
		}
		switch(a){
		case 1 :{
			findTicket.find();
			break;
		}
		case 2 :{
			booking.book();
			break;
		}
		case 3 :{
			returnTicket.returnt();
			break;
		}
		case 4:{
			System.out.println("��ӭ����ʹ�á�");
			break;
		}
		}
	}
}
