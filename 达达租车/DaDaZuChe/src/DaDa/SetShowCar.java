package DaDa;

public class SetShowCar {
	 static ManCar c1 = new ManCar("�µ�A4",500,4);
	 static ManCar c2 = new ManCar("���Դ�6", 400 ,4);
	 static ManThing c3 = new ManThing("Ƥ��ѩ", 450 , 4 , 2);
	 static ManCar c4 = new ManCar("����", 800 ,20);
	 static ThingCar c5= new ThingCar("�ɻ���" , 400 ,4); 
	 static ThingCar c6 = new ThingCar("��ά��", 1000 ,20);
	
			 public static void show(){

				 System.out.println("1.          "+ c1.getName() + "             " +c1.getPrise() +"Ԫ/��"+ "         "+"����:"+c1.getMan() + "��");
				 System.out.println("2.          "+ c2.getName() + "             " +c2.getPrise() +"Ԫ/��"+ "         "+"����:"+c2.getMan() + "��");
				 System.out.println("3.          "+ c3.getName() + "             " +c3.getPrise() +"Ԫ/��"+ "         "+"����:"+c3.getMan() + "��"+c3.getThing()+"��");
				 System.out.println("4.          "+ c4.getName() + "                 " +c4.getPrise() +"Ԫ/��"+ "         "+"����:"+c4.getMan() + "��");
				 System.out.println("5.          "+ c5.getName() + "             " +c5.getPrise() +"Ԫ/��"+ "         "+"�ػ�:"+c5.getThing() + "��");
				 System.out.println("6.          "+ c6.getName() + "             " +c6.getPrise() +"Ԫ/��"+ "         "+"�ػ�:"+c6.getThing() + "��");
				
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
					System.out.println("   ������:"+nump);
					
					System.out.println("***�ػ��ĳ��У�");
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
					System.out.println("���ػ���");
					
					System.out.println("***�⳵�ܼ۸�"+money*day);
			 }
		
}
