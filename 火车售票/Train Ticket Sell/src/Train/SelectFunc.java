package Train;

import java.util.Scanner;

public class SelectFunc {                                          //本类功能：选择要执行的操作
	FindTicket findTicket = new FindTicket();
	Booking booking = new Booking() ;
	ReturnTicket returnTicket = new ReturnTicket();
	
	public void select(){

		Scanner scanner=new Scanner(System.in);
		
		int a = scanner.nextInt();
		
		while(true){                                                        //判断输入是否合格
			if(a<1 || a >4){ 
				System.out.println("输入错误，请重新输入：");
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
			System.out.println("欢迎您的使用。");
			break;
		}
		}
	}
}
