package bean;

public class techangStudent extends Student{

	public techangStudent(String name, String id, double pingshi, double kaoshi) {
		super(name, id, pingshi, kaoshi);
		
	}
	public techangStudent(){
		
	}

	public double score() {
		return super.getKaoshi()*0.7 + super.getPingshi()*0.3 + 10;
	}
	
}
