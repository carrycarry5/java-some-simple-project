package DaDa;

import java.util.Scanner;

public class ChooseCar {
		public static void choose(){
			Scanner scanner= new Scanner(System.in);
			System.out.println("��������Ҫ�⳵������");
			
			int amount = scanner.nextInt();
			int[] a = new int [amount];
			for(int i = 0  ; i < amount ; i++){
				System.out.println("�������"+i + "���������");
				a[i] = scanner.nextInt();
			}
			
			//����
			/*for(int i = 0 ; i<a.length ; i++){
				System.out.println(a[i]);
			}*/
			
			System.out.println("�������⳵����:");
			int day  = scanner.nextInt();
			
			 System.out.println("�����˵���");
				System.out.println("***�����˵ĳ��У�");
			
			//����SetShowCar����
			SetShowCar.pill(a, day);
		}
}
