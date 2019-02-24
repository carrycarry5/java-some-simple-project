package util;

import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;

public class showAvg {
	//计算该学科平均值
		public static void show(String subject) {
			ArrayList<Student> list = GetStudents.getStudent();           //获取全部学生对象
			switch(subject){
			case "1" : 
				showJapanAvg(list);
				break;
			case "2" :
				showMathAvg(list);
				break;
			case "3" :
				showEnglishAvg(list);
				break;
			}
		}
		//计算日语成绩平均值
		private static void showJapanAvg(ArrayList<Student> list) {
			double avg=0;
			for (Student student : list) {
				avg+=student.getJapan();
			}
			System.out.println("日语平均成绩："+ avg/4);
		}
		//计算数学成绩平均值
		private static void showMathAvg(ArrayList<Student> list) {
			double avg=0;
			for (Student student : list) {
				avg+=student.getMath();
			}
			System.out.println("数学平均成绩："+ avg/4);
		}
		//计算英语成绩平均值
		private static void showEnglishAvg(ArrayList<Student> list) {
			double avg=0;
			for (Student student : list) {
				avg+=student.getEnglish();
			}
			System.out.println("英语平均成绩："+ avg/4);
		}
}
