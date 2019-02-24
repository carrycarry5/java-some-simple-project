package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import bean.GetStudents;
import bean.Student;

//��ĳѧ�Ƶ�ѧ����������
public class SortStudent {
	public static void sort(String subject){
		ArrayList<Student> list = GetStudents.getStudent();           //��ȡȫ��ѧ������
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
	//��Ӣ��ɼ���������
	private static void sortEnglish(ArrayList<Student> list) {
		TreeSet<Student> tree = new TreeSet<>(new Comparator<Student>() {     //���һ���Ƚ���
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
		for (Student student : list) {                         //��ѧ������ȫ������tree��
			tree.add(student);                                  
		}
		int i = 1;
		for (Student student : tree) {                      //��ӡѧ����Ϣ
			System.out.println("��"+i +"���� id:" + student.getId()+"     ����"+student.getName()
			+"     �ɼ���  "+student.getEnglish());
			i++;
		}
		
	}
	//����ѧ�ɼ���������
	private static void sortMath(ArrayList<Student> list) {
		TreeSet<Student> tree = new TreeSet<>(new Comparator<Student>() {     //���һ���Ƚ���
			@Override
			public int compare(Student o1, Student o2) {
				double i=o2.getMath() - o1.getMath();
				if (i==0) {
					return 1;
				}
				return (int) (i);
			}
		});
		for (Student student : list) {                         //��ѧ������ȫ������tree��
			tree.add(student);                                  
		}
		int i = 1;
		for (Student student : tree) {                      //��ӡѧ����Ϣ
			System.out.println("��"+i +"���� id:" + student.getId()+"     ����"+student.getName()
			+"     �ɼ���  "+student.getMath());
			i++;
		}
	}
	//������ɼ���������
	private static void sortJapan(ArrayList<Student> list) {
		TreeSet<Student> tree = new TreeSet<>(new Comparator<Student>() {     //���һ���Ƚ���
			@Override
			public int compare(Student o1, Student o2) {
				double i = o2.getJapan() - o1.getJapan();
				if (i==0) {
					return 1;
				}
				return (int) (i);
			}
		});
		for (Student student : list) {                         //��ѧ������ȫ������tree��
			tree.add(student);                                  
		}
		int i = 1;
		for (Student student : tree) {                      //��ӡѧ����Ϣ
			System.out.println("��"+i +"���� id:" + student.getId()+"     ����"+student.getName()
			+"     �ɼ���  "+student.getJapan());
			i++;
		}
	}
}
