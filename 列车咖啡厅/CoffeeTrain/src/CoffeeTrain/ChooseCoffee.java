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
	
	public  int i =0;                                                 //��¼��Ʒ
	
	public void choose(){
		while(true){
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���������迧�ȵ����(��0�����㵥)");
		int num = sc.nextInt();
		while(limit.lim(num, 0,7)){
			 num = sc.nextInt();
		}
		
		numa[i] = num;

		if(num==0){
			System.out.println("�����㵥");
			break;
		}
		
		Coffee c = (Coffee) arr[num-1];
		
		System.out.println("��ѡ����"+c.getName());
		System.out.println("��ѡ������");
		
		int amo = sc.nextInt();
		while(limit.lim(amo, 0, 100)){
			 amo = sc.nextInt();
		}
		amoa[i] = amo;
		
		if(amo==0){
			System.out.println("�����㵥");
			break;
		}
	
		money+=c.getPrice()*amo;

		i++;
		}
		changenum();
	
	}
	public void changenum(){
		num = Arrays.copyOfRange(numa, 0,cutArr());               //�޸�����Ĵ�С
		amo= Arrays.copyOfRange(amoa, 0,cutArr());
	}
	public int cutArr() {                                                      //��ȡ���鳤��
		for(int i =0 ;i<numa.length;i++){
			if(numa[i]==0){
				return i;
			}
		}
		return 0;
	}
}
