package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.jdbc_add;
import dao.jdbc_select;

public class Login_register {
	private static String name = null;
	public static void login_register(String num) throws FileNotFoundException, IOException, SQLException{
		switch(num){
		case  "1" :
			login();               //执行登录
			break;
		case "2" :
			register();          //执行注册
			break;
		default :
			break;
		}
	}
	
	//登录
	public static void login() throws FileNotFoundException, IOException, SQLException{
		
		System.out.println("欢迎来到登录界面");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("输入用户名");
		name = sc2.next();
		        
		ArrayList< String > names = jdbc_select.getNames();    //获取names集合
		if (names.contains(name)) {                //如果有记录，则登录，否则注册
			System.out.println("登录成功");
			SendPost.send();                          //进入发帖界面
		} else {
			System.out.println("无该用户，请先注册");
			register();        
		}
		
	}
	//注册
	public static void register() throws FileNotFoundException, IOException, SQLException{
		System.out.println("欢迎来到注册界面");
		//作者信息：包括作者昵称、性别、年龄、职业、爱好等
		String sex = null;
		String age = null;
		String job = null;
		String like = null;
		Scanner sc1 = new Scanner(System.in);
		System.out.println("请输入你的名称:");
		name = sc1.next();
		System.out.println("请输入你的性别");
		sex = sc1.next();
		System.out.println("请输入你的年龄");
		age = sc1.next();
		System.out.println("请输入你的职业");
		job = sc1.next();
		System.out.println("请输入你的爱好");
		like = sc1.next();
		
		//将信息存入数据库
		try {
			jdbc_add.add(name, sex, age, job, like);            //如果报错，则提醒该用户名已存在，请直接登录
			System.out.println("注册成功");
			SendPost.send();                      //进入发帖页面
		} catch (Exception e) {
			System.out.println("该用户已存在，请直接输入名称登录");
			login();                               //执行登录界面
		}
		
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Login_register.name = name;
	}
	
	
}
