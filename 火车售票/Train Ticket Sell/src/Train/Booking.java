package Train;

import java.util.Scanner;

public class Booking {                                         //���๦�ܣ���Ʊ
	
	Place place = new Place();
	SetTrain sTrain = new SetTrain();
	TicketMassage ticketMassage = new TicketMassage();
	Text text = new Text();
	Train train = new Train();
	
	SetTrain setTrain = new SetTrain();
	Object[] arr = setTrain.add();                                          //��������
	
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
	
	private static int Tnum;                               //������λ�ţ����������һ����λ��
	
	public int getTnum() {
		return Tnum;
	}
	public void setTnum(){                                    //����һ����λ��
		Tnum = 1+(int)(Math.random() * 99);
	}
	
	public void book(){
		
		Object[] arr = sTrain.add();
		
		System.out.println("**********��Ʊ����**********");
		System.out.print("������Ŀ�ĵأ�");
		
		Train t = (Train) arr[place.place()];                                //����Ŀ�ĵ�
		
		System.out.println("������Ʊ��:");                            //����Ʊ��
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();    
		while(true){
			if(num<1 || num>100){
				System.out.println("��������");
				num = sc.nextInt();
			}
			else break;
		}
		price = t.getPrice()*num;

		System.out.println("��������������:");                          //��������
		name = sc.next();
		
		System.out.println("�������Ƿ���ѧ����(���밴1�������밴2)");
		int i = sc.nextInt();
		if(i==1){
			price = price/2;
		}
		while(true){
			if(i<1 || i>2){
				System.out.println("�������      ������������");
				i = sc.nextInt();
			}
			break;
		}
		
		System.out.println("��˶�������Ϣ");
		
		ticketMassage.massage(num(t.getPlace()),num,0);
		
		System.out.println("��Ʊ��:     "+num);
		setTnum();
		System.out.println("��λ��:     "+getTnum());
		System.out.println("�踶���:     "+price);
		System.out.println("");
		System.out.println("��1�������˵�����2������Ʊ");
		int a1 = sc.nextInt();
		while(true){                                        //�ж��Ƿ�ϸ�
			if(a1< 1 || a1 >2){
				System.out.println("����������");
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
	
	public int num(String s){                             //�ҵ�Ŀ�ĵص���ŵĺ���
		for(int i = 0 ;i<arr.length ;i++){
			Train t =  (Train) arr[i];                         //����ת��ΪTrain
			if(s.equals(t.getPlace())){
				return i;
			}
		}
		return -1;
	}
}
