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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");            //����ģ��
		 
		today = sdf.format(new Date());                              //��ȡ��������
			
		System.out.println("������������գ���ʽ��xxxx��xx��xx�գ�");
		
		birthday = sc.nextLine();                                          //��ȡ��������
		
		Date d1 = sdf.parse(birthday);                             //���ַ���ת����Date
		Date d2 = sdf.parse(today);
		
		long time = d2.getTime()-d1.getTime();                 //��ȡ����ֵ
		
		System.out.println("�����"+time/1000/60/60/24/365+"��   /   "+time/1000/60/60/24/30+"��   /   "
		+time/1000/60/60/24/7+"��   /   "+time/1000/60/60/24+"��");	
	}

}
