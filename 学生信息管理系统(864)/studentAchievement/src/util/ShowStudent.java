package util;

import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;

public class ShowStudent {
	public static void show(){
		ArrayList<Student> list = GetStudents.getStudent();
		for (Student s : list) {
			System.out.println("id："+s.getId()+"     "+"姓名：" +s.getName()+"     "+"日语成绩：" +s.getJapan()
			+"     "+"数学成绩：" +s.getMath()+"     "+"英语成绩：" +s.getEnglish()+"     " +"总成绩：" +s.getSum()
			+"     "+"班级排名"+ s.getRank());
		}
	}
}
