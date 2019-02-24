package CoffeeTrain;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Bill {
	ChooseCoffee chooseCoffee = new ChooseCoffee();                               //定义对象
	ChooseSeat chooseSeat = new ChooseSeat();
	SetCoffee setCoffee = new SetCoffee();
	
	Object[] arr = setCoffee.set();
	
	public void show(){
		
		//Arrays.copyOf(chooseCoffee.numa, cutArr());
		
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("座位号："+chooseSeat.a);
		
		for(int i = 0 ;i<chooseCoffee.num.length;i++){                                                          //生成订单
			Coffee c = (Coffee) arr[chooseCoffee.num[i]-1];
			System.out.println(c.getName()+".........数量:"+chooseCoffee.amo[i]+".........单个商品价格："+c.getPrice());
			//System.out.println(chooseCoffee.numa[i]+",,,,,,,,,,,,");
		}
		
		System.out.println("商品总价："+chooseCoffee.money);
		
		System.out.println("--------------------------------------------------");
		
	}

	public void time() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");          // 生成时间
		System.out.println("下单时间："+df.format(new Date()));
	}
}
