package domain;

public class Market2 {
	public int id;
	public String name;
	public double price;
	public int number;
	
	public  Market2(){
		
	}
	
	public Market2(int id, String name, double price, int number) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
	}
	


	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", price=" + price + ", number=" + number + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
