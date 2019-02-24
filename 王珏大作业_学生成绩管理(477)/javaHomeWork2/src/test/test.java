package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Set;

import bean.Student;
import bean.putonStudent;
import dao.jdbc_select;
import utils.GetScore;
import utils.GetTenScore;
import utils.InputStudent;

public class test {
	public static void main(String[] args) throws SQLException, IOException {
		//输出平均成绩
		//System.out.println(GetScore.getAvg());
		//输出最高成绩的学生信息
		//System.out.println("最高成绩："+GetScore.getMax().score() + "       该学生的信息："+GetScore.getMax());
		//输出10位学生的平均成绩
		//System.out.println(GetTenScore.getAvg());
		//输出10位学生中最高成绩的学生信息
		//System.out.println("最高成绩："+GetTenScore.getMax().score() + "       该学生的信息："+GetTenScore.getMax());
		
		InputStudent.input();
	}


}
