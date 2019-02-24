package DaDa;

import java.util.Scanner;

public class Demo_show {
		public static void show(){
			Scanner scanner=new Scanner(System.in);
			System.out.println("欢迎使用达达租车系统：");
			System.out.println("您是否要租车：1 是 0 否");
			int sc0 = scanner.nextInt();
			
			if(sc0==0){
				System.out.println("感谢您的使用");
				System.exit(0);
			}
			
			System.out.println("您可租车的类型及其价格表");
			System.out.println("序号      汽车名称           租金             容量");
			
		}
}







