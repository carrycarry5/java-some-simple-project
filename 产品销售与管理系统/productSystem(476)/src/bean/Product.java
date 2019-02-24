package bean;

public class Product {
	private String name;
	private int num;
	private int outnum;
	private String inTime;
	private String outString;
	private String category;   //Àà±ð
	
	public Product(String name, int num, String inTime, String outString, String category , int outnum) {
		super();
		this.name = name;
		this.num = num;
		this.inTime = inTime;
		this.outString = outString;
		this.category = category;
		this.outnum = outnum;
	}
	
	public Product(){
		
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", num=" + num + ", inTime=" + inTime + ", outString=" + outString
				+ ", category=" + category + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutString() {
		return outString;
	}

	public void setOutString(String outString) {
		this.outString = outString;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getOutnum() {
		return outnum;
	}

	public void setOutnum(int outnum) {
		this.outnum = outnum;
	}
	
	
}
