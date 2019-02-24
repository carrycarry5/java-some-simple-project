package DaDa;

import java.util.Scanner;

public class ChooseCar {
		public static void choose(){
			Scanner scanner= new Scanner(System.in);
			System.out.println("请输入您要租车的数量");
			
			int amount = scanner.nextInt();
			int[] a = new int [amount];
			for(int i = 0  ; i < amount ; i++){
				System.out.println("请输入第"+i + "辆车的序号");
				a[i] = scanner.nextInt();
			}
			
			//测试
			/*for(int i = 0 ; i<a.length ; i++){
				System.out.println(a[i]);
			}*/
			
			System.out.println("请输入租车天数:");
			int day  = scanner.nextInt();
			
			 System.out.println("您的账单：");
				System.out.println("***可载人的车有：");
			
			//调用SetShowCar方法
			SetShowCar.pill(a, day);
		}
}
