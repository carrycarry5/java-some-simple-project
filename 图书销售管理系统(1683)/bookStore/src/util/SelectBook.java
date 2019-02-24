package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.GetStore;
import domain.Store;

public class SelectBook {
	public static void selectBook(){
		ArrayList<Store> list = GetStore.storeList;                    //获取书店全部书对象
		System.out.println("欢迎进入查询界面");
		System.out.println("在这里您可以通过id查询或者通过书名查询");
		System.out.println("id请按1，书名请按2");
		String s = select();              //选择操作
		switch(s){
		case "1" :
			useID(list);
			break;
		case "2":
			useName(list);
			break;
		default :
			break;
		}
	}

	private static void useName(ArrayList<Store> list) {
		ArrayList<String> namelist = new ArrayList<>();                     //用于存全部书名
		Map<String, Integer> map = new HashMap<>();                  //map集合用于存id和对应的名字
		for (Store store : list) {
			map.put(store.getName(),store.getId());     
			namelist.add(store.getName());
		}
		System.out.println("请输入书名");
		String name=null;
		while(true){
			name=ScannString.scannString();
			if (namelist.contains(name)) {
				break;
			} else{
				System.out.println("本店不存在该名字的书，请重新输入");
			}
		}
		int i = map.get(name);              //获得id
		Store store = list.get(i-1);
		System.out.println("id号："+store.getId()+"\t"+"书名《"+
		store.getName()+"》\t价格：" +store.getPrice()+"元\t库存：" +store.getNumber()+"本");
		
	}

	private static void useID(ArrayList<Store> list) {
		
		ArrayList<Integer> ids = new ArrayList<>();                         //用于存id的集合
		for (Store store : list) {
			ids.add(store.getId());
		}
		System.out.println("请输入id号");
		String id = null;
		while(true){
			id=ScannString.scannString();	
			if (ids.contains(Integer.parseInt(id))) {
				break;
			} else{
				System.out.println("输入错误，请重新输入");
			}
		}
		int idi = Integer.parseInt(id);
		Store store = list.get(idi-1);
		System.out.println("id号："+store.getId()+"\t"+"书名《"+
		store.getName()+"》\t价格：" +store.getPrice()+"元\t库存：" +store.getNumber()+"本");
	}

	private static String select() {
		String s =null;
		while(true){
			s= ScannString.scannString();
			if (s.equals("1") || s.equals("2")) {
				break;
			} else{
				System.out.println("输入错误，请重新输入");
			}
		}
		return s;
	}
}
