package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public static String getDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��-hh:mm:ss");
		String time=format.format(new Date());                      //��ȡ��ǰʱ��
		return time;
	}
}
