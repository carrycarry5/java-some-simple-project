package Train;

public class TicketMassage {                      //本类功能： 输出车票信息

	public void massage(int a,int num,int renum){
		Booking booking = new Booking();
		SetTrain setTrain = new SetTrain();
		ReturnTicket returnTicket = new ReturnTicket();
		GetTrainnum getTrainnum = new GetTrainnum();
		Train train = new Train();
		
		Object[] arr = setTrain.add();                                          //声明集合
		
		booking.setNum(num);                            //设置余票数
		returnTicket.setRenum(renum);              //设置退票数
		
		Train t =  (Train) arr[a];                   //t为arr[0]
		System.out.println("");
		System.out.println("*****车票信息*****");
		System.out.println("南昌->"+t.getPlace());                       //车票详情
		System.out.println("日期:     "+t.getMonth()+"月"+t.getDay()+"日");
		System.out.println("车次:     "+t.getNumber());
		getTrainnum.setTnum();
		int a1 = getTrainnum.getTnum();
		System.out.println("车厢号:     "+a1);
		System.out.println("票价:     "+t.getPrice());
		System.out.println("学生价:     "+t.getPrice()/2);
		System.out.println("总票数:     100张");
		train.setTicket(t.getTicket()-booking.getNum()+returnTicket.getRenum());
		System.out.println("余票数:     "+(train.getTicket())+"张");
		System.out.println("*******************");
	}
}
