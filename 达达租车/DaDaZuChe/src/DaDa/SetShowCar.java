package DaDa;

public class SetShowCar {
	 static ManCar c1 = new ManCar("奥迪A4",500,4);
	 static ManCar c2 = new ManCar("马自达6", 400 ,4);
	 static ManThing c3 = new ManThing("皮卡雪", 450 , 4 , 2);
	 static ManCar c4 = new ManCar("金龙", 800 ,20);
	 static ThingCar c5= new ThingCar("松花江" , 400 ,4); 
	 static ThingCar c6 = new ThingCar("依维柯", 1000 ,20);
	
			 public static void show(){

				 System.out.println("1.          "+ c1.getName() + "             " +c1.getPrise() +"元/天"+ "         "+"载人:"+c1.getMan() + "人");
				 System.out.println("2.          "+ c2.getName() + "             " +c2.getPrise() +"元/天"+ "         "+"载人:"+c2.getMan() + "人");
				 System.out.println("3.          "+ c3.getName() + "             " +c3.getPrise() +"元/天"+ "         "+"载人:"+c3.getMan() + "人"+c3.getThing()+"吨");
				 System.out.println("4.          "+ c4.getName() + "                 " +c4.getPrise() +"元/天"+ "         "+"载人:"+c4.getMan() + "人");
				 System.out.println("5.          "+ c5.getName() + "             " +c5.getPrise() +"元/天"+ "         "+"载货:"+c5.getThing() + "吨");
				 System.out.println("6.          "+ c6.getName() + "             " +c6.getPrise() +"元/天"+ "         "+"载货:"+c6.getThing() + "吨");
				
			 }
			 
			 public static void pill(int[] a, int day){
					int money=0;
					int nump=0;
					int numt=0;
					
					for(int i = 0 ;i <a.length ; i ++){
						switch(a[i]){
						case 1 : {
							System.out.print(c1.getName()+"   ");
							nump +=c1.getMan();
							money +=c1.getPrise();
							break;
						}
						case 2 : {
							System.out.print(c2.getName()+"   ");
							nump +=c2.getMan();
							money +=c2.getPrise();
							break;
						}
						case 3 : {
							System.out.print(c3.getName()+"   ");
							nump +=c3.getMan();
							money +=c3.getPrise();
							numt +=c3.getThing();
							break;
						}
						case 4 : {
							System.out.print(c1.getName()+"   ");
							numt +=c4.getMan();
							money +=c4.getPrise();
							break;
						}
						
						}		
				 }
					System.out.println("   共载人:"+nump);
					
					System.out.println("***载货的车有：");
					for(int i = 0 ;i <a.length ; i ++){
						switch (a[i]) {
							case 3 : {
								System.out.print(c3.getName()+"   ");
								/*nump +=c3.getMan();
								money +=c3.getPrise();
								numt +=c3.getThing();*/
								break;
							}
							case 5 : {
								System.out.print(c1.getName()+"   ");
								numt +=c5.getThing();
								money +=c5.getPrise();
								break;
							}
							case 6 : {
								System.out.print(c1.getName()+"   ");
								nump +=c6.getThing();
								money +=c6.getPrise();
								break;
							}
						}
				 }
					System.out.println("共载货：");
					
					System.out.println("***租车总价格："+money*day);
			 }
		
}
