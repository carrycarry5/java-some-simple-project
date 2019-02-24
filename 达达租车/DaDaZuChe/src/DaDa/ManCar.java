package DaDa;

public class  ManCar extends Car{
	private int man;
	
	public ManCar(){
		
	}
	
	public ManCar(String name,double prise,int man){
		super(name , prise);
		this.man=man;
	}

	public int getMan() {
		return man;
	}

	public void setMan(int man) {
		this.man = man;
	}
}
