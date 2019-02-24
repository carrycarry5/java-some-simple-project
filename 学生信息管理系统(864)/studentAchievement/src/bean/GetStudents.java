package bean;

import java.util.ArrayList;
import java.util.List;
//通过集合存储学生，创建一个类返回集合
public class GetStudents {
	
	public static ArrayList<Student> getStudent(){
		ArrayList<Student> list = new ArrayList<>();
		Student s1 = Student.miku;
		Student s2 = Student.rin;
		Student s3 = Student.lin;
		Student s4 = Student.luck;
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		return list;
	}
}
