package DaDa;

public class ThingCar extends Car{
	private int thing;
	
	public ThingCar(){
		
	}
	public ThingCar(String name,double prise,int thing){
		super(name,prise);
		this.thing = thing;
	}
	public int getThing() {
		return thing;
	}
	public void setThing(int thing) {
		this.thing = thing;
	}
}
