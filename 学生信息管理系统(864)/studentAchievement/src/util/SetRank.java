package util;

import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;
//设置学生排名
public class SetRank {
	public static void set(){
		ArrayList<Student> list = GetStudents.getStudent();
		for(int i = 0 ; i < list.size() ; i ++){
			Student student = max(list);                        //获得总分最大的学生对象
			student.setRank(i+1);                                   //设置学生排名
			list.remove(student);                                    //将最高排名的学生删除
		}
		
	}
	
	public static Student max(ArrayList<Student> list){                       //返回总分最大的学生对象
		Student s = list.get(0);
		for(int i = 0 ; i < list.size()-1 ; i++ ){
			Student student = list.get(i+1);
			if (s.getSum()<student.getSum()) {
				s=student;
			}
		}
		return s;
	}
}
