package CoffeeTrain;

public class Coffee {
	private String name;
	private double price;
	
	public Coffee(String name,double price){
		super();
		this.price = price;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setName(String name){
		this.name = name;
	}
}
