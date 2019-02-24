package CoffeeTrain;

public class ShowCoffee {
	
	SetCoffee setCoffee = new SetCoffee();

	public  void show(){
		
		Object[] arr = setCoffee.set();
		for(int i = 0 ; i <arr.length ; i ++){
			Coffee c = (Coffee) arr[i];
			System.out.println((i+1)+"."+c.getName()+".........."+c.getPrice());
		}			
	}
}
