package CoffeeTrain;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Bill {
	ChooseCoffee chooseCoffee = new ChooseCoffee();                               //�������
	ChooseSeat chooseSeat = new ChooseSeat();
	SetCoffee setCoffee = new SetCoffee();
	
	Object[] arr = setCoffee.set();
	
	public void show(){
		
		//Arrays.copyOf(chooseCoffee.numa, cutArr());
		
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("��λ�ţ�"+chooseSeat.a);
		
		for(int i = 0 ;i<chooseCoffee.num.length;i++){                                                          //���ɶ���
			Coffee c = (Coffee) arr[chooseCoffee.num[i]-1];
			System.out.println(c.getName()+".........����:"+chooseCoffee.amo[i]+".........������Ʒ�۸�"+c.getPrice());
			//System.out.println(chooseCoffee.numa[i]+",,,,,,,,,,,,");
		}
		
		System.out.println("��Ʒ�ܼۣ�"+chooseCoffee.money);
		
		System.out.println("--------------------------------------------------");
		
	}

	public void time() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");          // ����ʱ��
		System.out.println("�µ�ʱ�䣺"+df.format(new Date()));
	}
}
