package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public static String getDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日-hh:mm:ss");
		String time=format.format(new Date());                      //获取当前时间
		return time;
	}
}
