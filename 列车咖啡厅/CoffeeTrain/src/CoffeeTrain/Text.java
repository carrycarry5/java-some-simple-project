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
		
		System.out.println("欢迎来到列车咖啡屋~");
		System.out.println("请选择您的座位。");
		
		seat.showSeat();
		
		System.out.println("好的，请到"+cs.a+"号座位入座");
		System.out.println("--------------------------------------------");
		System.out.println("请问需要点什么？");
		System.out.println("我们这里有：");
		
		showCoffee.show();
		
		System.out.println("请点单：");
		
		
		chooseCoffee.choose();
		
		System.out.println("点单完毕，请查看账单：");
		
		bill.show();
		bill.time();
		
		System.out.println("请问是否要修改账单呢？修改请按1，不修改请按任意键");
		
		ifChangeBill.change();
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("请问是否结账呢？结账请按1，不结账请按任意键");
		
		ifPay.pay();
	}

}
