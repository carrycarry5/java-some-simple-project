package bean;

public class liujiStudent extends Student{

	public liujiStudent(String name, String id, double pingshi, double kaoshi) {
		super(name, id, pingshi, kaoshi);
		
	}

	public liujiStudent() {
	}	
	
	public double score() {
		return super.getKaoshi();
	}
	
	
}
