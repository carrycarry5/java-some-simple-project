package util;

import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;

public class ShowStudent {
	public static void show(){
		ArrayList<Student> list = GetStudents.getStudent();
		for (Student s : list) {
			System.out.println("id��"+s.getId()+"     "+"������" +s.getName()+"     "+"����ɼ���" +s.getJapan()
			+"     "+"��ѧ�ɼ���" +s.getMath()+"     "+"Ӣ��ɼ���" +s.getEnglish()+"     " +"�ܳɼ���" +s.getSum()
			+"     "+"�༶����"+ s.getRank());
		}
	}
}
