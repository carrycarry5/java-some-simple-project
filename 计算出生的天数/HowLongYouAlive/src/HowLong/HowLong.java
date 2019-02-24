package HowLong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HowLong {

	public static void main(String[] args) throws ParseException {
		String birthday;
		String today;
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");            //设置模版
		 
		today = sdf.format(new Date());                              //获取现在日期
			
		System.out.println("请输入你的生日（格式：xxxx年xx月xx日）");
		
		birthday = sc.nextLine();                                          //获取出生日期
		
		Date d1 = sdf.parse(birthday);                             //将字符串转换成Date
		Date d2 = sdf.parse(today);
		
		long time = d2.getTime()-d1.getTime();                 //获取毫秒值
		
		System.out.println("你活了"+time/1000/60/60/24/365+"年   /   "+time/1000/60/60/24/30+"月   /   "
		+time/1000/60/60/24/7+"周   /   "+time/1000/60/60/24+"天");	
	}

}
