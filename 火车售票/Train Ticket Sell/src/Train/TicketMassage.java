package Train;

public class TicketMassage {                      //���๦�ܣ� �����Ʊ��Ϣ

	public void massage(int a,int num,int renum){
		Booking booking = new Booking();
		SetTrain setTrain = new SetTrain();
		ReturnTicket returnTicket = new ReturnTicket();
		GetTrainnum getTrainnum = new GetTrainnum();
		Train train = new Train();
		
		Object[] arr = setTrain.add();                                          //��������
		
		booking.setNum(num);                            //������Ʊ��
		returnTicket.setRenum(renum);              //������Ʊ��
		
		Train t =  (Train) arr[a];                   //tΪarr[0]
		System.out.println("");
		System.out.println("*****��Ʊ��Ϣ*****");
		System.out.println("�ϲ�->"+t.getPlace());                       //��Ʊ����
		System.out.println("����:     "+t.getMonth()+"��"+t.getDay()+"��");
		System.out.println("����:     "+t.getNumber());
		getTrainnum.setTnum();
		int a1 = getTrainnum.getTnum();
		System.out.println("�����:     "+a1);
		System.out.println("Ʊ��:     "+t.getPrice());
		System.out.println("ѧ����:     "+t.getPrice()/2);
		System.out.println("��Ʊ��:     100��");
		train.setTicket(t.getTicket()-booking.getNum()+returnTicket.getRenum());
		System.out.println("��Ʊ��:     "+(train.getTicket())+"��");
		System.out.println("*******************");
	}
}
