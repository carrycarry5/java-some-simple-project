package util;

import java.util.ArrayList;

import dao.GetBackLog;
import dao.GetInLog;
import dao.GetSellLog;
import domain.BackLog;
import domain.InLog;
import domain.SellLog;

public class SelectLog {
	public static void selectLog(){
		System.out.println("欢迎进入查询日志界面");
		System.out.println("查询进货日志请按1，查询退货日志请按2，查询销售日志请按3");
		int i = select();
		switch (i) {
		case 1:
			showLogin();
			break;
		case 2:
			showLogBack();
			break;
		case 3:
			showLogSell();
			break;
		default:
			break;
		}
	}
	
	private static void showLogSell() {
		System.out.println("*****销售日志*****");
		ArrayList<SellLog> list =GetSellLog.SellLogList;
		for (SellLog Log : list) {
			System.out.println(Log.getId()+"\t" +Log.getTime()+Log.getContent()+"\t"+"数量："+Log.getNum()+"本");
		}
	}

	private static void showLogBack() {
		System.out.println("*****退货日志*****");
		ArrayList<BackLog> list =GetBackLog.BackLogList;
		for (BackLog Log : list) {
			System.out.println(Log.getId()+"\t" +Log.getTime()+Log.getContent()+"\t"+"数量："+Log.getNum()+"本");
		}
	}

	private static void showLogin() {
		System.out.println("*****进货日志*****");
		ArrayList<InLog> list =GetInLog.inLogList;
		for (InLog inLog : list) {
			System.out.println(inLog.getId()+"\t" +inLog.getTime()+inLog.getContent()+"\t"+"数量："+inLog.getNum()+"本");
		}
	}

	private static int select() {
		String s =ScannString.scannString();
		while(true){
			if (s.equals("1") || s.equals("2") || s.equals("3")) {
				break;
			} else{
				System.out.println("输入错误，请重新输入");
				s=ScannString.scannString();
			}
		}
		return Integer.parseInt(s);
	}
}
