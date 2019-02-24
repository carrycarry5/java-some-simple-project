package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.jdbc_select;
import dao.jdbc_update;

public class Out_product {
	//出货
	public static void out_product() throws FileNotFoundException, IOException, SQLException{
		ArrayList<String > names = jdbc_select.getNames();
		String name = null;
		int outnum =  0 ; 
		String outtime = null;
		int num = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要出货的货品名称");
		name = scanner.next();
		if (!names.contains(name)) {
			System.out.println("不存在该商品，请重新输入");
			out_product();
		}
		System.out.println("请输入出货的数量");
		outnum = scanner.nextInt();
		if (num>jdbc_select.getNum()) {
			System.out.println("仓库里只有"+jdbc_select.getNum()+"件"+name);
			out_product();
		}
		System.out.println("出货成功");
		
		
		num = jdbc_select.getNum()-outnum;        //求得剩余数目
		outtime = GetCurrentTime.getTime();    //获取当前时间
		jdbc_update.update(name, outnum, outtime,num);
	}
}
