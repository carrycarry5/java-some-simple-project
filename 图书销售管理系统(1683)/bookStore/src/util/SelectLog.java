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
		System.out.println("��ӭ�����ѯ��־����");
		System.out.println("��ѯ������־�밴1����ѯ�˻���־�밴2����ѯ������־�밴3");
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
		System.out.println("*****������־*****");
		ArrayList<SellLog> list =GetSellLog.SellLogList;
		for (SellLog Log : list) {
			System.out.println(Log.getId()+"\t" +Log.getTime()+Log.getContent()+"\t"+"������"+Log.getNum()+"��");
		}
	}

	private static void showLogBack() {
		System.out.println("*****�˻���־*****");
		ArrayList<BackLog> list =GetBackLog.BackLogList;
		for (BackLog Log : list) {
			System.out.println(Log.getId()+"\t" +Log.getTime()+Log.getContent()+"\t"+"������"+Log.getNum()+"��");
		}
	}

	private static void showLogin() {
		System.out.println("*****������־*****");
		ArrayList<InLog> list =GetInLog.inLogList;
		for (InLog inLog : list) {
			System.out.println(inLog.getId()+"\t" +inLog.getTime()+inLog.getContent()+"\t"+"������"+inLog.getNum()+"��");
		}
	}

	private static int select() {
		String s =ScannString.scannString();
		while(true){
			if (s.equals("1") || s.equals("2") || s.equals("3")) {
				break;
			} else{
				System.out.println("�����������������");
				s=ScannString.scannString();
			}
		}
		return Integer.parseInt(s);
	}
}
