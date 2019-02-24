package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import bean.GetStudents;
import bean.Student;

//对某学科的学生进行排序
public class SortStudent {
	public static void sort(String subject){
		ArrayList<Student> list = GetStudents.getStudent();           //获取全部学生对象
		switch(subject){
		case "1" : 
			sortJapan(list);
			break;
		case "2" :
			sortMath(list);
			break;
		case "3" :
			sortEnglish(list);
			break;
		}
	}
	//对英语成绩进行排序
	private static void sortEnglish(ArrayList<Student> list) {
		TreeSet<Student> tree = new TreeSet<>(new Comparator<Student>() {     //添加一个比较器
			@Override
			public int compare(Student o1, Student o2) {
				double i = o2.getEnglish() - o1.getEnglish();
				if (i==0) {
					return 1;
				} else{
					return (int)(i);
				}
			}
		});
		for (Student student : list) {                         //将学生对象全部存入tree中
			tree.add(student);                                  
		}
		int i = 1;
		for (Student student : tree) {                      //打印学生信息
			System.out.println("第"+i +"名： id:" + student.getId()+"     姓名"+student.getName()
			+"     成绩：  "+student.getEnglish());
			i++;
		}
		
	}
	//对数学成绩进行排序
	private static void sortMath(ArrayList<Student> list) {
		TreeSet<Student> tree = new TreeSet<>(new Comparator<Student>() {     //添加一个比较器
			@Override
			public int compare(Student o1, Student o2) {
				double i=o2.getMath() - o1.getMath();
				if (i==0) {
					return 1;
				}
				return (int) (i);
			}
		});
		for (Student student : list) {                         //将学生对象全部存入tree中
			tree.add(student);                                  
		}
		int i = 1;
		for (Student student : tree) {                      //打印学生信息
			System.out.println("第"+i +"名： id:" + student.getId()+"     姓名"+student.getName()
			+"     成绩：  "+student.getMath());
			i++;
		}
	}
	//对日语成绩进行排序
	private static void sortJapan(ArrayList<Student> list) {
		TreeSet<Student> tree = new TreeSet<>(new Comparator<Student>() {     //添加一个比较器
			@Override
			public int compare(Student o1, Student o2) {
				double i = o2.getJapan() - o1.getJapan();
				if (i==0) {
					return 1;
				}
				return (int) (i);
			}
		});
		for (Student student : list) {                         //将学生对象全部存入tree中
			tree.add(student);                                  
		}
		int i = 1;
		for (Student student : tree) {                      //打印学生信息
			System.out.println("第"+i +"名： id:" + student.getId()+"     姓名"+student.getName()
			+"     成绩：  "+student.getJapan());
			i++;
		}
	}
}
