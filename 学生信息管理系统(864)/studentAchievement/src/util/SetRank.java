package util;

import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;
//����ѧ������
public class SetRank {
	public static void set(){
		ArrayList<Student> list = GetStudents.getStudent();
		for(int i = 0 ; i < list.size() ; i ++){
			Student student = max(list);                        //����ܷ�����ѧ������
			student.setRank(i+1);                                   //����ѧ������
			list.remove(student);                                    //�����������ѧ��ɾ��
		}
		
	}
	
	public static Student max(ArrayList<Student> list){                       //�����ܷ�����ѧ������
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
