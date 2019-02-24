package util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
	public static String getTime() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String date = sdf.format(new Date());
		ioStudent.saveLog(date);                   //每次显示时间都被记录到txt文件
		return date;
	}
}
