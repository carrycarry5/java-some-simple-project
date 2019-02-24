package DaDa;

public class ManThing extends ManCar{
		private int thing;
		
		public ManThing(){
			
		}
		
		public ManThing(String name,double prise,int man,int thing){
			super(name, prise, man);
			this.thing = thing;
		}

		public int getThing() {
			return thing;
		}

		public void setThing(int thing) {
			this.thing = thing;
		}
}
