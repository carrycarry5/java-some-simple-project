package CoffeeTrain;

public class Seat {

		public void showSeat() {
			ChooseSeat cSeat = new ChooseSeat();
			
			int sn = 5;
			int a=0;
			int s[] = new int[]{1,2,3,4,5};
			
		    if (cSeat.a!=0) {
				a=1;
			}
			System.out.println("��λ������"+sn );
			System.out.println("��λʣ��������"+(sn-a));
			System.out.println("��ʹ��������"+a);
			
			System.out.print("������λ�ţ�");
			for(int i=0; i<s.length ;i++){
				if(s[i] != cSeat.a){
					System.out.print("("+(i+1) +")"+ "  ");
				}
			}
			
			System.out.println();
			System.out.println("����������Ҫ����λ�ţ�");
			cSeat.choose();
			
			
		}
}
