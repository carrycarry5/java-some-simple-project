package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.jdbc_add;
import dao.jdbc_select;

public class SendPost {
	static String message = null;
	static  String time = null;
	static  String name = null;
	public static  void send() throws FileNotFoundException, IOException, SQLException{
		
		
		System.out.println("欢迎来到发帖页面");
		System.out.println("请输入你要发帖的内容：");
		Scanner sc = new Scanner(System.in);
		message = sc.next();
		time = GetCurrentTime.getTime();
		name = Login_register.getName();                      //获取当前登录的用户名
		System.out.println(name);
		jdbc_add.addPost(time, message, name);             //添加信息到数据库
		System.out.println("发帖成功");
		
		
		jdbc_select.selectPost();              //执行查询
		System.out.println("************************");
		System.out.println("帖子编号："+jdbc_select.getIds().get(jdbc_select.getIds().size()-1));
		System.out.println("作者："+name);
		System.out.println("发帖时间："+time);
		System.out.println("内容："+message);
		System.out.println("************************");
		
		System.out.println("回复按1，不回复按2");
		String num  = sc.next();
		switch (num) {
		case "1":
			reply();                //回复页面
			break;
		case "2":
			System.out.println("本次服务结束");
			break;
		default:
			break;
		}
		
	}
	
	public static void reply() throws FileNotFoundException, IOException, SQLException{
		System.out.println("***欢迎来到回复页面***");
		System.out.println("请输入你的回复");
		String replyMessage = new Scanner(System.in).next();
		String replyAuthor = name;
		String time = GetCurrentTime.getTime();
		
		jdbc_add.addReply(replyMessage, replyAuthor, time);          //将信息存入数据库
		
		System.out.println("回复成功");
		
		System.out.println("*****************************");
		System.out.println("回复作者昵称：" + name);
		System.out.println("回复时间："+ time);
		System.out.println("回复内容："+replyMessage);
		System.out.println("本次服务结束");
	}
	
	
}
