package CoffeeTrain;

public class Text {
	
	public static  void main(String[] args) {
		Seat seat =new Seat();
		ChooseSeat cs = new ChooseSeat();
		ShowCoffee showCoffee = new ShowCoffee();
		ChooseCoffee chooseCoffee = new ChooseCoffee();
		IfPay ifPay = new IfPay();
		Bill bill = new Bill();
		IfChangeBill ifChangeBill = new IfChangeBill();
		
		System.out.println("��ӭ�����г�������~");
		System.out.println("��ѡ��������λ��");
		
		seat.showSeat();
		
		System.out.println("�õģ��뵽"+cs.a+"����λ����");
		System.out.println("--------------------------------------------");
		System.out.println("������Ҫ��ʲô��");
		System.out.println("���������У�");
		
		showCoffee.show();
		
		System.out.println("��㵥��");
		
		
		chooseCoffee.choose();
		
		System.out.println("�㵥��ϣ���鿴�˵���");
		
		bill.show();
		bill.time();
		
		System.out.println("�����Ƿ�Ҫ�޸��˵��أ��޸��밴1�����޸��밴�����");
		
		ifChangeBill.change();
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("�����Ƿ�����أ������밴1���������밴�����");
		
		ifPay.pay();
	}

}
