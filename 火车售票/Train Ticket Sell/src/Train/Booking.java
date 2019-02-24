package Train;

import java.util.Scanner;

public class Booking {                                         //本类功能：订票
	
	Place place = new Place();
	SetTrain sTrain = new SetTrain();
	TicketMassage ticketMassage = new TicketMassage();
	Text text = new Text();
	Train train = new Train();
	
	SetTrain setTrain = new SetTrain();
	Object[] arr = setTrain.add();                                          //声明集合
	
	private static int num;
	private String name;
	private  static double price;
	
	public double getPrice(){
		return price;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public int getNum(){
		return num;
	}
	public String getName(){
		return name;
	}
	
	private static int Tnum;                               //设置座位号，将随机产生一个座位号
	
	public int getTnum() {
		return Tnum;
	}
	public void setTnum(){                                    //产生一个座位号
		Tnum = 1+(int)(Math.random() * 99);
	}
	
	public void book(){
		
		Object[] arr = sTrain.add();
		
		System.out.println("**********订票窗口**********");
		System.out.print("请输入目的地：");
		
		Train t = (Train) arr[place.place()];                                //输入目的地
		
		System.out.println("请输入票数:");                            //输入票数
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();    
		while(true){
			if(num<1 || num>100){
				System.out.println("重新输入");
				num = sc.nextInt();
			}
			else break;
		}
		price = t.getPrice()*num;

		System.out.println("请输入您的姓名:");                          //输入姓名
		name = sc.next();
		
		System.out.println("请问您是否是学生？(是请按1，不是请按2)");
		int i = sc.nextInt();
		if(i==1){
			price = price/2;
		}
		while(true){
			if(i<1 || i>2){
				System.out.println("输入错误      ，请重新输入");
				i = sc.nextInt();
			}
			break;
		}
		
		System.out.println("请核对您的信息");
		
		ticketMassage.massage(num(t.getPlace()),num,0);
		
		System.out.println("订票数:     "+num);
		setTnum();
		System.out.println("座位号:     "+getTnum());
		System.out.println("需付金额:     "+price);
		System.out.println("");
		System.out.println("按1返回主菜单，按2继续订票");
		int a1 = sc.nextInt();
		while(true){                                        //判断是否合格
			if(a1< 1 || a1 >2){
				System.out.println("请重新输入");
				a1=sc.nextInt();
			}
			else break;
		}
		ifOver(a1);
	}
	
	public void ifOver(int a ){
		if (a==1) {
			text.main(null);
		}else{
			book();
		}
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
}
