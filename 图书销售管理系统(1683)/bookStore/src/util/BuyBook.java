package util;



import java.util.ArrayList;

import dao.GetMarket1;
import dao.GetMarket2;
import dao.UpdateLog;
import dao.UpdateMarket;
import dao.UpdateStore;
import domain.Market1;
import domain.Market2;

public class BuyBook {
	public static void buyBook() throws Exception{
		System.out.println("欢迎进入进货界面：");
		System.out.println("请选择供应商。");
		ArrayList<Market1> list1= GetMarket1.market1List;             //获取两家供应商的商品信息
		ArrayList<Market2> list2 = GetMarket2.market2List; 
		System.out.println("**********当当网**********");
		for (Market1 market1 : list1) {
			System.out.println(market1.getId()+"\t《" +market1.getName()+"》\t      " +market1.getPrice()+"元\t      " +market1.getNumber()+"本");
		}
		System.out.println("**********喜马拉雅**********");
		for (Market2 market2 : list2) {
			System.out.println(market2.getId()+"\t《" +market2.getName()+"》\t      " +market2.getPrice()+"元\t      " +market2.getNumber()+"本");
		}
		
		System.out.println("当当网请按1，喜马拉雅请按2");
		String s = ScannString.scannString();
		select(s);                 //选择
	}
	
	public static void select(String s) throws Exception{                                //选择供应商
		while(true){
			switch(s){
			case "1" :
				select1();
				break;
			case "2":
				select2();
				break;
			}
			if (s.equals("1") || s.equals("2")) {
				break;
			} else{
				System.out.println("输入错误，请重新输入");
			}
			s=ScannString.scannString();
		}
	}
	//选择了供应商一
	public static void select1() throws Exception{
		System.out.println("您选择了当当网进货");
		System.out.println("请选择所需书的id");
		ArrayList<Integer> idlist = new ArrayList<>();              //定义集合用于存id
		ArrayList<Market1> list = GetMarket1.market1List;       //获取全部对象
		for (Market1 market1 : list) {
			idlist.add(market1.getId());
		}
		int id = getID(idlist);                                      //获得id
		int num= list.get(id-1).getNumber();                 //获取库存
		System.out.println("请选择数量：");
		int change = getNum1(list, id);                            //获得购买数目
		String sql = "update market1 set number=? where id=?";             //创建sql语句
		UpdateMarket.update(sql, num-change,id);            //更新进货商数据
		String sql1 = "update store set number=? where id=?";
		UpdateStore.update(sql1, change, id);                     //更新书店数据
		String time = GetDate.getDate();                           //获取当前时间
		
		String sql2 = "insert into inLog values(null,?,?,?)";
		String bookName = list.get(id-1).getName();                      //获得书名
		String content  = "从当当网购买《".concat(bookName).concat("》");
		UpdateLog.update(sql2, time, content, change);         //更新购买日志
	}
	//选择了供应商二
	public static void select2() throws Exception{
		System.out.println("您选择了喜马拉雅进货");
		System.out.println("请选择所需书的id");
		ArrayList<Integer> idlist = new ArrayList<>();            //定义集合用于存id
		ArrayList<Market2> list = GetMarket2.market2List;    //获取全部对象
		for (Market2 market2 : list) {
			idlist.add(market2.getId());
		}
		int id = getID(idlist);                                         //获得id
		int num = list.get(id-1).getNumber();              //获得库存
		System.out.println("请输入数量：");
		int change = getNum2(list, id);                                          //获得购买数目
		String sql = "update market2 set number=? where id=?";         //创建语句
		UpdateMarket.update(sql, num-change, id);             //更新进货商数据
		String sql1 = "update store set number=? where id=?";
		UpdateStore.update(sql1, change, id);                            //更新书店数据
		
		String time = GetDate.getDate();                                //获取当前时间
		String sql2 = "insert into inLog values(null,?,?,?)";
		String bookName = list.get(id-1).getName(); 
		String content  = "从喜马拉雅网购买《".concat(bookName).concat("》");
		UpdateLog.update(sql2, time, content, change);
	}
		//获取购书的数目
	public static int getNum1(ArrayList<Market1> list, int id) {
		int num=0;                                             //购书数量
		while(true){
			String nums = ScannString.scannString();
			try {
				num=Integer.parseInt(nums);
			} catch (Exception e) {
				System.out.println("输入错误，请重新输入");
			}
			int amount = list.get(id-1).getNumber();            //获取该书的库存
			if (num>amount) {
				System.out.println("库存不足，请重新输入");
			} else if (num<=0) {
				System.out.println("不能输入零或负数，请重新输入");
			} else {
				break;
			}
		}
		return num;
	}
	//获取购书的数目
	public static int getNum2(ArrayList<Market2> list, int id) {
		int num=0;                                             //购书数量
		while(true){
			String nums = ScannString.scannString();
			try {
				num=Integer.parseInt(nums);
			} catch (Exception e) {
				System.out.println("输入错误，请重新输入");
			}
			int amount = list.get(id-1).getNumber();            //获取该书的库存
			if (num>amount) {
				System.out.println("库存不足，请重新输入");
			} else if (num<=0) {
				System.out.println("不能输入零或负数，请重新输入");
			} else {
				break;
			}
		}
		return num;
	}
	//获取所购书的id号
	public static int getID(ArrayList<Integer> idlist) {
		String ids = null;
		int id=0;                                                     //购书id号
		while(true){
			ids = ScannString.scannString();
			try {
				id = Integer.parseInt(ids);                   //如果输入的是字母就抓
			} catch (NumberFormatException e) {
				
			}
			if (idlist.contains(id)) {
				break;                    //如果输入的id号存在就退出循环
			} else {
				System.out.println("未找到该id的书，请重新输入");
			}
		}
		return id;
	}

	
	
}



