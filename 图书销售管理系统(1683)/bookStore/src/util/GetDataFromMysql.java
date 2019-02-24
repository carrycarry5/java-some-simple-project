package util;

import dao.GetBackLog;
import dao.GetInLog;
import dao.GetMarket1;
import dao.GetMarket2;
import dao.GetSellLog;
import dao.GetStore;

public class GetDataFromMysql {
	public static void getData() throws Exception{
		GetSellLog.getBackLog();
		GetMarket1.getMarket1();         	
		GetMarket2.getMarket2();
		GetStore.getStore();	
		GetInLog.getinLog();
		GetBackLog.getBackLog();
	}
}
