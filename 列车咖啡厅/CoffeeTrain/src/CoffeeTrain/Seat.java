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
			System.out.println("座位总数："+sn );
			System.out.println("座位剩余数量："+(sn-a));
			System.out.println("已使用数量："+a);
			
			System.out.print("现有座位号：");
			for(int i=0; i<s.length ;i++){
				if(s[i] != cSeat.a){
					System.out.print("("+(i+1) +")"+ "  ");
				}
			}
			
			System.out.println();
			System.out.println("请输入您想要的座位号：");
			cSeat.choose();
			
			
		}
}
