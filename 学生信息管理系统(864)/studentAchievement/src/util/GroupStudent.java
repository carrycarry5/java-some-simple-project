package util;

import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;

//对某学科成绩的学生进行分段
public class GroupStudent {
	public static void group(String subject){
		ArrayList<Student> list = GetStudents.getStudent();           //获取全部学生对象
		switch(subject){
		case "1" : 
			groupJapan(list);                     //按照日语成绩分段
			break;
		case "2" :
			gruopMath(list);                       //按照数学成绩分段
			break;
		case "3" :
			groupEnglish(list);                     //按照英语成绩分段
			break;
		}
	}
	  //按照英语成绩分段
	private static void groupEnglish(ArrayList<Student> list) {
		int a=0;        //定义a段的学生人数
		int b=0;        //定义b段的学生人数
		int c=0;         //定义c段的学生人数
		int d=0;        //定义d段的学生人数
		ArrayList<String> namea = new ArrayList<>();             //用于存储a段学生的姓名
		ArrayList<String> nameb = new ArrayList<>();              //用于存储b段学生的姓名
		ArrayList<String> namec = new ArrayList<>();            //用于存储c段学生的姓名
		ArrayList<String> named = new ArrayList<>();          //用于存储d段学生的姓名
		for (Student student : list) {
			if (student.getEnglish() >= 90) {                  //大于等于九十分为a段
				namea.add(student.getName());
				a++;
			} else if (student.getEnglish() >= 80) {       //大于等于八十分为b段
				nameb.add(student.getName());
				b++;
			} else if (student.getEnglish() >= 70) {       //大于等于七十分为c段
				namec.add(student.getName());
				c++;
			} else {                                                      //低于七十分为d段
				named.add(student.getName());
				d++;
			}
		}
		System.out.println("英语成绩明细：");
		System.out.println("A段学生共"+a+"名,分别是：");
		for (String string : namea) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("B段学生共"+b+"名,分别是：");
		for (String string : nameb) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("C段学生共"+c+"名,分别是：");
		for (String string : namec) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("A段学生共"+d+"名,分别是：");
		for (String string : named) {
			System.out.print(string+"     ");
		}
		System.out.println();
	}
	  //按照数学成绩分段
	private static void gruopMath(ArrayList<Student> list) {
		int a=0;        //定义a段的学生人数
		int b=0;        //定义b段的学生人数
		int c=0;         //定义c段的学生人数
		int d=0;        //定义d段的学生人数
		ArrayList<String> namea = new ArrayList<>();             //用于存储a段学生的姓名
		ArrayList<String> nameb = new ArrayList<>();              //用于存储b段学生的姓名
		ArrayList<String> namec = new ArrayList<>();            //用于存储c段学生的姓名
		ArrayList<String> named = new ArrayList<>();          //用于存储d段学生的姓名
		for (Student student : list) {
			if (student.getMath() >= 90) {                  //大于等于九十分为a段
				namea.add(student.getName());
				a++;
			} else if (student.getMath() >= 80) {       //大于等于八十分为b段
				nameb.add(student.getName());
				b++;
			} else if (student.getMath() >= 70) {       //大于等于七十分为c段
				namec.add(student.getName());
				c++;
			} else {                                                      //低于七十分为d段
				named.add(student.getName());
				d++;
			}
		}
		System.out.println("数学成绩明细：");
		System.out.println("A段学生共"+a+"名,分别是：");
		for (String string : namea) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("B段学生共"+b+"名,分别是：");
		for (String string : nameb) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("C段学生共"+c+"名,分别是：");
		for (String string : namec) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("A段学生共"+d+"名,分别是：");
		for (String string : named) {
			System.out.print(string+"     ");
		}
		System.out.println();
	}
	  //按照日语成绩分段
	private static void groupJapan(ArrayList<Student> list) {
		int a=0;        //定义a段的学生人数
		int b=0;        //定义b段的学生人数
		int c=0;         //定义c段的学生人数
		int d=0;        //定义d段的学生人数
		ArrayList<String> namea = new ArrayList<>();             //用于存储a段学生的姓名
		ArrayList<String> nameb = new ArrayList<>();              //用于存储b段学生的姓名
		ArrayList<String> namec = new ArrayList<>();            //用于存储c段学生的姓名
		ArrayList<String> named = new ArrayList<>();          //用于存储d段学生的姓名
		for (Student student : list) {
			if (student.getJapan() >= 90) {                  //大于等于九十分为a段
				namea.add(student.getName());
				a++;
			} else if (student.getJapan() >= 80) {       //大于等于八十分为b段
				nameb.add(student.getName());
				b++;
			} else if (student.getJapan() >= 70) {       //大于等于七十分为c段
				namec.add(student.getName());
				c++;
			} else {                                                      //低于七十分为d段
				named.add(student.getName());
				d++;
			}
		}
		System.out.println("日语成绩明细：");
		System.out.println("A段学生共"+a+"名,分别是：");
		for (String string : namea) {
			System.out.print(string +"     ");
		}
		System.out.println();
		System.out.println("B段学生共"+b+"名,分别是：");
		for (String string : nameb) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("C段学生共"+c+"名,分别是：");
		for (String string : namec) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("A段学生共"+d+"名,分别是：");
		for (String string : named) {
			System.out.print(string+"     ");
		}
		System.out.println();
	}
}
