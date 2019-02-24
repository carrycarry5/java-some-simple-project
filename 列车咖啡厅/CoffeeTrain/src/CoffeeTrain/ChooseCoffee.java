package CoffeeTrain;

import java.util.Arrays;
import java.util.Scanner;

public class ChooseCoffee {
	SetCoffee setCoffee = new SetCoffee();
	Object[] arr = setCoffee.set();
	Limit limit = new Limit();
	
	public static double money;
	public  int[] numa= new int[10];
	public  int[] amoa=new int[10];
	
	public static int[] num = new int[10];
	public static int[] amo = new int[10];
	
	public  int i =0;                                                 //记录商品
	
	public void choose(){
		while(true){
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入所需咖啡的序号(按0结束点单)");
		int num = sc.nextInt();
		while(limit.lim(num, 0,7)){
			 num = sc.nextInt();
		}
		
		numa[i] = num;

		if(num==0){
			System.out.println("结束点单");
			break;
		}
		
		Coffee c = (Coffee) arr[num-1];
		
		System.out.println("您选择了"+c.getName());
		System.out.println("请选择数量");
		
		int amo = sc.nextInt();
		while(limit.lim(amo, 0, 100)){
			 amo = sc.nextInt();
		}
		amoa[i] = amo;
		
		if(amo==0){
			System.out.println("结束点单");
			break;
		}
	
		money+=c.getPrice()*amo;

		i++;
		}
		changenum();
	
	}
	public void changenum(){
		num = Arrays.copyOfRange(numa, 0,cutArr());               //修改数组的大小
		amo= Arrays.copyOfRange(amoa, 0,cutArr());
	}
	public int cutArr() {                                                      //获取数组长度
		for(int i =0 ;i<numa.length;i++){
			if(numa[i]==0){
				return i;
			}
		}
		return 0;
	}
}
