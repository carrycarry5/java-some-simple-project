package Train;

import java.util.Scanner;

public class ReturnTicket {                                   //本类功能：退票
	Place place = new Place();
	SetTrain sTrain = new SetTrain();
	Booking booking = new Booking();
	TicketMassage ticketMassage = new TicketMassage();
	Text text = new Text();

	
	SetTrain setTrain = new SetTrain();
	Object[] arr = setTrain.add();                                          //声明集合
	
	private static  int renum;                                 //设置退票数量
	
	public int getRenum() {
		return renum;
	}
	public void setRenum(int renum) {
		this.renum = renum;
	}

	public void returnt(){
		System.out.println("**********退票窗口**********");
		System.out.print("请输入目的地：");
		
		Object[] arr = sTrain.add();
		
		Train t = (Train) arr[place.place()];                                //输入目的地
		
		System.out.println("请输入退票数:");                            //输入票数
		Scanner sc = new Scanner(System.in);
		 renum = sc.nextInt();                                      //获取退票数
		 while(true){
				if(renum<1 || renum>100){
					System.out.println("重新输入");
					renum = sc.nextInt();
				}
				else break;
			}
		
		double reprice = booking.getPrice() - renum*t.getPrice()/2;     //获取总价格
		
		System.out.println();
		System.out.println("请核对您的信息");
		
		ticketMassage.massage(num(t.getPlace()),booking.getNum(),renum);
		
		System.out.println("订票数:     "+(booking.getNum()-renum));
		
		System.out.println("座位号:     "+booking.getTnum());
		System.out.println("需付金额:     "+reprice);
		System.out.println("");
		System.out.println("按1返回主菜单，按2继续退票");
		int a1 = sc.nextInt();
		while(true){
			if(a1<1 || a1>2){
				System.out.println("请重新输入");
				a1=sc.nextInt();
			}
			else break;
		}
		ifOver(a1);
	}
	
	public int num(String s){                             //找到目的地的序号的函数
		for(int i = 0 ;i<arr.length ;i++){
			Train t =  (Train) arr[i];                         //向下转型为Train
			if(s.equals(t.getPlace())){
				return i;
			}
		}
		return -1;
	}
	public void ifOver(int a ){
		if (a==1) {
			text.main(null);
		}else{
			returnt();
		}
	}
}
