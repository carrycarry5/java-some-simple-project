package utils;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentTime {
	public static String  getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
}
