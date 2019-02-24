package util;

import java.util.ArrayList;

import dao.GetStore;
import dao.UpdateLog;
import dao.UpdateStore;
import domain.Store;

public class SellBook {
	public static void sellBook() throws Exception{
		System.out.println("欢迎进入售书界面");
		ArrayList<Store> list = GetStore.storeList;                //获取书店全部书对象
		showBook(list);                                                       //输出全部书信息
		System.out.println("请输入所要购买书的id号");
		int id=getID();                                                       //获取id
		int amount=getamount(id);                                                     //获取库存量
		System.out.println("请输入所要购买的数量");
		int num = getNum(amount);                                              //获取数量
		String sql = "update store set number=? where id=?"; 
		UpdateStore.update(sql, -num, id);                                   //修改书店信息
		
		String date = GetDate.getDate();                                         //获取当前时间
		String sql1 = "insert into selllog values(null,?,?,?)";
		String bookName = list.get(id-1).getName();                  //获得书名
		String content = "顾客买书：《".concat(bookName).concat("》");
		UpdateLog.update(sql1, date, content, num);              //修改卖书日志
	}

	private static int getamount(int id) {
		int num = GetStore.storeList.get(id-1).getNumber();
		return num;
	}

	private static int getNum(int amount) {
		String nums=null;
		int num = 0;
		while(true){
			nums=ScannString.scannString();
			try {
				num=Integer.parseInt(nums);
			} catch (NumberFormatException e) {
				
			}
			if (num <= 0 ) {
				System.out.println("不能输入零或者负数，请重新输入");
			} else if (num> amount) {
				System.out.println("库存不足，请重新输入");
			} else {
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

	private static void showBook(ArrayList<Store> list) {
		for (Store store : list) {
			System.out.println(store.getId()+"\t"+store.getName()+"\t"+"库存："+store.getNumber()+"\t"+
		"单价："+store.getPrice()+"元");
		}
	}


}
