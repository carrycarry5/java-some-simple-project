package util;

import java.util.ArrayList;


import dao.GetStore;
import dao.UpdateLog;
import dao.UpdateStore;
import domain.Store;

public class BackBook {
	public static void backBook() throws Exception{
		System.out.println("欢迎进入退书界面：");
		System.out.println("请输入所退书对应的id号");
		ArrayList<Store> list = GetStore.storeList;                  //获取书店全部书对象
		for (Store store : list) {
			System.out.println(store.getId()+"\t" +store.getName());
		}
		int id=getID();                                        //获取id
		System.out.println("请问要退几本？");
		int num = getNum();                             //获得数量
		String sql = "update store set number=? where id=?";
		UpdateStore.update(sql, num, id);                //修改书店数据库信息
		
		String sql1 = "insert into backlog values(null,?,?,?)";
		String time = GetDate.getDate();                 //获取当前时间
		String bookName = list.get(id-1).getName();    //获取书名
		String content = "顾客退书：《".concat(bookName).concat("》");
		UpdateLog.update(sql1, time, content, num);             //更新退货库信息
	}

	private static int getNum() {
		String nums=null;
		int num = 0;
		while(true){
			nums=ScannString.scannString();
			try {
				num=Integer.parseInt(nums);
			} catch (NumberFormatException e) {
				
			}
			if (num <= 0 ) {
				System.out.println("不能输入零或负数，请重新输入");
			} else{
				break;
			}
		}
		return num;
	}

	private static int getID() {
		String id=null;
		while(true){
			id = ScannString.scannString();              //输入id
			if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
				break;
			} else{
				System.out.println("输入错误，请重新输入");
			}
		}
		return Integer.parseInt(id);
	}
}
