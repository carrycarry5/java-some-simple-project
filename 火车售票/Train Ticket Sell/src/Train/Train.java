package Train;

public class Train {                                                 //本类功能：创建一个Train类
	private int month;
	private int day;
	private String place;
	private String number;
	private double price;
	private static int ticket;
	
	public Train(){
		
	}
	
	public Train(int month, int day, String place, String number, double price) {
		super();
		this.month = month;
		this.day = day;
		this.place = place;
		this.number = number;
		this.price = price;
		ticket = 100;
	}
	
	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
