package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import dao.jdbc_add;

public class Add_product {
	//添加
	public static void add_product() throws FileNotFoundException, IOException, SQLException{
		String name = null;
		int num = 0;
		String intime = null;
		String category = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要添加的产品名称");
		name = sc.next();
		System.out.println("请输入要该产品的数目");
		num = sc.nextInt();
		System.out.println("请输入该产品的类别");
		category = sc.next();
		
		intime = GetCurrentTime.getTime();       //获取当前时间
		System.out.println(intime);
		//将该信息保存到数据库
		jdbc_add.add(name, num, intime, category);
		
		System.out.println("添加成功");
	}
}
