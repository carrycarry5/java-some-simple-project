package Train;

import java.util.Scanner;

public class FindTicket {                                          //���๦�ܣ���Ʊ

	TicketMassage ticketMassage = new TicketMassage(); 
	Place place = new Place();
	Booking booking = new Booking();
	ReturnTicket returnTicket = new ReturnTicket();

	public void find(){
		System.out.println("**********��Ʊ����**********");
		System.out.print("������Ŀ�ĵأ�");
		
		ticketMassage.massage(place.place(), booking.getNum(),returnTicket.getRenum());                          //�����Ʊ��Ϣ
		
		ifOver();                                                                    //�Ƿ����
	}

	public void ifOver(){                                                       
		System.out.println("��1�������˵�����2������Ʊ");
		Scanner s1 = new Scanner(System.in);
		int a = s1.nextInt();
		while(true){
			if(a< 1 || a >2){
				System.out.println("����������");
				a=s1.nextInt();
			}
			else break;
		}
		if(a==1){                                                          //�����1���򷵻ص�������
			Text text = new Text();
			text.main(null);
		}
		else{
			find();
		}
	}

}
