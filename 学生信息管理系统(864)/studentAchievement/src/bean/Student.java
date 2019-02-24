package bean;
//学生的枚举类
public enum Student {
	miku("1","miku",100,90,80,2),
	rin("2","rin",90,100,95,1),
	lin("3","lin",80,90,70,4),
	luck("4","luck",100,70,80,3);
	private String id;             //id
	private String name;          //姓名
	private double japan;        //日语成绩
	private double math;         //数学成绩
	private double english;     //英语成绩
	private double sum;         //总成绩
	private int rank;               //班级排名
	private Student(String id, String name, double japan, double math, double english,int rank) {
		this.id = id;
		this.name = name;
		this.japan = japan;
		this.math = math;
		this.english = english;
		this.rank=rank;
		this.sum = japan+math+english;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getJapan() {
		return japan;
	}
	public void setJapan(double japan) {
		this.japan = japan;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}

}
