package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import bean.Student;
import dao.jdbc_add;

public class InputStudent {
	private static  String id = null;
	private static  String name = null;
	private static  double pingshi = 0;
	private  static double kaoshi = 0;
	private static  String type = null;
	
	public static void input() throws SQLException, IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("请问要输入几个学生的信息？请按对应数字。");
		int num = sc.nextInt();
		//输入学生信息
		for(int i = 0 ; i <num ; i++){
			//输入信息
			scannerMessage(sc);
			//存入数据库
			jdbc_add.add(id, name, pingshi, kaoshi, type);
			//存入文件
			saveAsText();
		}
		
	}
	//输入学生的信息
	public static void scannerMessage(Scanner sc) {
		System.out.println("请输入学生的id");
		id = sc.next();
		System.out.println("请输入学生的名字");
		name = sc.next();
		System.out.println("请输入学生的平时成绩");
		pingshi = sc.nextDouble();
		System.out.println("请输入学生的考试成绩");
		kaoshi = sc.nextDouble();
		System.out.println("请输入学生的类型（普通生：p ， 留级生：l ， 特长生：t）");
		type = sc.next();
	}
	
	//将学生信息存入本地文件中
	public static void saveAsText() throws IOException{
		Student s = new Student(name, id, pingshi, kaoshi);
		File file = new File("D://javahomework2.txt");
		FileOutputStream fos = new FileOutputStream(file,true);
		String message = s.toString();
		fos.write(message.getBytes());
		fos.write("/r/n".getBytes());
		
		//释放资源
		fos.close();
	}

}
