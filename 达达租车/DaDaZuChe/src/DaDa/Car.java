package DaDa;

public  class Car {
	private String name;
	private double prise;
	
	public Car(){
		
	}

	public Car(String name, double prise) {
		this.name = name ; 
		this.prise = prise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrise() {
		return prise;
	}

	public void setPrise(double prise) {
		this.prise = prise;
	}




}
