package Train;

import java.util.Scanner;

public class ReturnTicket {                                   //���๦�ܣ���Ʊ
	Place place = new Place();
	SetTrain sTrain = new SetTrain();
	Booking booking = new Booking();
	TicketMassage ticketMassage = new TicketMassage();
	Text text = new Text();

	
	SetTrain setTrain = new SetTrain();
	Object[] arr = setTrain.add();                                          //��������
	
	private static  int renum;                                 //������Ʊ����
	
	public int getRenum() {
		return renum;
	}
	public void setRenum(int renum) {
		this.renum = renum;
	}

	public void returnt(){
		System.out.println("**********��Ʊ����**********");
		System.out.print("������Ŀ�ĵأ�");
		
		Object[] arr = sTrain.add();
		
		Train t = (Train) arr[place.place()];                                //����Ŀ�ĵ�
		
		System.out.println("��������Ʊ��:");                            //����Ʊ��
		Scanner sc = new Scanner(System.in);
		 renum = sc.nextInt();                                      //��ȡ��Ʊ��
		 while(true){
				if(renum<1 || renum>100){
					System.out.println("��������");
					renum = sc.nextInt();
				}
				else break;
			}
		
		double reprice = booking.getPrice() - renum*t.getPrice()/2;     //��ȡ�ܼ۸�
		
		System.out.println();
		System.out.println("��˶�������Ϣ");
		
		ticketMassage.massage(num(t.getPlace()),booking.getNum(),renum);
		
		System.out.println("��Ʊ��:     "+(booking.getNum()-renum));
		
		System.out.println("��λ��:     "+booking.getTnum());
		System.out.println("�踶���:     "+reprice);
		System.out.println("");
		System.out.println("��1�������˵�����2������Ʊ");
		int a1 = sc.nextInt();
		while(true){
			if(a1<1 || a1>2){
				System.out.println("����������");
				a1=sc.nextInt();
			}
			else break;
		}
		ifOver(a1);
	}
	
	public int num(String s){                             //�ҵ�Ŀ�ĵص���ŵĺ���
		for(int i = 0 ;i<arr.length ;i++){
			Train t =  (Train) arr[i];                         //����ת��ΪTrain
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
