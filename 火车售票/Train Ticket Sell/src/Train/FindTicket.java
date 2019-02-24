package Train;

import java.util.Scanner;

public class FindTicket {                                          //本类功能：查票

	TicketMassage ticketMassage = new TicketMassage(); 
	Place place = new Place();
	Booking booking = new Booking();
	ReturnTicket returnTicket = new ReturnTicket();

	public void find(){
		System.out.println("**********查票窗口**********");
		System.out.print("请输入目的地：");
		
		ticketMassage.massage(place.place(), booking.getNum(),returnTicket.getRenum());                          //输出车票信息
		
		ifOver();                                                                    //是否结束
	}

	public void ifOver(){                                                       
		System.out.println("按1返回主菜单，按2继续查票");
		Scanner s1 = new Scanner(System.in);
		int a = s1.nextInt();
		while(true){
			if(a< 1 || a >2){
				System.out.println("请重新输入");
				a=s1.nextInt();
			}
			else break;
		}
		if(a==1){                                                          //如果按1，则返回到主函数
			Text text = new Text();
			text.main(null);
		}
		else{
			find();
		}
	}

}
