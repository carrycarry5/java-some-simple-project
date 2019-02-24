package bean;

public  class Student {
	private String name;
	private String id;
	private double pingshi;
	private double kaoshi;
	private String type;       //Œﬁππ‘Ï
	
	public  double sumScore(Student s){
		return score() ;
	}
	
	public double score(){
		return 0;
	}

	public Student(String name, String id, double pingshi, double kaoshi) {
		super();
		this.name = name;
		this.id = id;
		this.pingshi = pingshi;
		this.kaoshi = kaoshi;
	}
	
	public Student(){
		
	}

	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPingshi() {
		return pingshi;
	}

	public void setPingshi(double pingshi) {
		this.pingshi = pingshi;
	}

	public double getKaoshi() {
		return kaoshi;
	}

	public void setKaoshi(double kaoshi) {
		this.kaoshi = kaoshi;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", pingshi=" + pingshi + ", kaoshi=" + kaoshi +"]";
	}
	
	
}
