package domain;

public class SellLog {
	private String time;
	private String content;
	private int num;
	private int id;
	public SellLog(){
		
	}
	public SellLog(String time, String content, int num,int id) {
		super();
		this.time = time;
		this.content = content;
		this.num = num;
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "SellLog [time=" + time + ", content=" + content + ", num=" + num + ", id=" + id + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
