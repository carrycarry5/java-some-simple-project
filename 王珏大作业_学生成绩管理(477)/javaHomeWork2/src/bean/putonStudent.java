package bean;

public class putonStudent extends Student{

	public putonStudent(String name, String id, double pingshi, double kaoshi) {
		super(name, id, pingshi, kaoshi);
		
	}
	
	public putonStudent(){
		
	}
	
	public double score() {
		
		return super.getKaoshi()*0.7 + super.getPingshi()*0.3;
	}


}
