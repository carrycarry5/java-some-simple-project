package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;

//将信息存入txt文件中
public class ioStudent {
	//将学生信息存入txt文件中
	public static void saveStudent() throws Exception{
		ArrayList<Student > list = GetStudents.getStudent();
		BufferedWriter writer = new BufferedWriter(new FileWriter("D://学生成绩管理系统.txt",true));
		for (Student s : list) {
			writer.write("id："+s.getId()+"     "+"姓名：" +s.getName()+"     "+"日语成绩：" +s.getJapan()
			+"     "+"数学成绩：" +s.getMath()+"     "+"英语成绩：" +s.getEnglish()+"     " +"总成绩：" +s.getSum()
			+"     "+"班级排名"+ s.getRank());
			writer.newLine();
		}
		writer.close();
	}
	//将日志存入txt文件中
	public static void saveLog(String log) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter("D://学生成绩管理系统.txt",true));
		writer.write(log);
		writer.newLine();
		writer.close();
	}
}
