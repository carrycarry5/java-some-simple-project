package util;

import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;

//��ĳѧ�Ƴɼ���ѧ�����зֶ�
public class GroupStudent {
	public static void group(String subject){
		ArrayList<Student> list = GetStudents.getStudent();           //��ȡȫ��ѧ������
		switch(subject){
		case "1" : 
			groupJapan(list);                     //��������ɼ��ֶ�
			break;
		case "2" :
			gruopMath(list);                       //������ѧ�ɼ��ֶ�
			break;
		case "3" :
			groupEnglish(list);                     //����Ӣ��ɼ��ֶ�
			break;
		}
	}
	  //����Ӣ��ɼ��ֶ�
	private static void groupEnglish(ArrayList<Student> list) {
		int a=0;        //����a�ε�ѧ������
		int b=0;        //����b�ε�ѧ������
		int c=0;         //����c�ε�ѧ������
		int d=0;        //����d�ε�ѧ������
		ArrayList<String> namea = new ArrayList<>();             //���ڴ洢a��ѧ��������
		ArrayList<String> nameb = new ArrayList<>();              //���ڴ洢b��ѧ��������
		ArrayList<String> namec = new ArrayList<>();            //���ڴ洢c��ѧ��������
		ArrayList<String> named = new ArrayList<>();          //���ڴ洢d��ѧ��������
		for (Student student : list) {
			if (student.getEnglish() >= 90) {                  //���ڵ��ھ�ʮ��Ϊa��
				namea.add(student.getName());
				a++;
			} else if (student.getEnglish() >= 80) {       //���ڵ��ڰ�ʮ��Ϊb��
				nameb.add(student.getName());
				b++;
			} else if (student.getEnglish() >= 70) {       //���ڵ�����ʮ��Ϊc��
				namec.add(student.getName());
				c++;
			} else {                                                      //������ʮ��Ϊd��
				named.add(student.getName());
				d++;
			}
		}
		System.out.println("Ӣ��ɼ���ϸ��");
		System.out.println("A��ѧ����"+a+"��,�ֱ��ǣ�");
		for (String string : namea) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("B��ѧ����"+b+"��,�ֱ��ǣ�");
		for (String string : nameb) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("C��ѧ����"+c+"��,�ֱ��ǣ�");
		for (String string : namec) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("A��ѧ����"+d+"��,�ֱ��ǣ�");
		for (String string : named) {
			System.out.print(string+"     ");
		}
		System.out.println();
	}
	  //������ѧ�ɼ��ֶ�
	private static void gruopMath(ArrayList<Student> list) {
		int a=0;        //����a�ε�ѧ������
		int b=0;        //����b�ε�ѧ������
		int c=0;         //����c�ε�ѧ������
		int d=0;        //����d�ε�ѧ������
		ArrayList<String> namea = new ArrayList<>();             //���ڴ洢a��ѧ��������
		ArrayList<String> nameb = new ArrayList<>();              //���ڴ洢b��ѧ��������
		ArrayList<String> namec = new ArrayList<>();            //���ڴ洢c��ѧ��������
		ArrayList<String> named = new ArrayList<>();          //���ڴ洢d��ѧ��������
		for (Student student : list) {
			if (student.getMath() >= 90) {                  //���ڵ��ھ�ʮ��Ϊa��
				namea.add(student.getName());
				a++;
			} else if (student.getMath() >= 80) {       //���ڵ��ڰ�ʮ��Ϊb��
				nameb.add(student.getName());
				b++;
			} else if (student.getMath() >= 70) {       //���ڵ�����ʮ��Ϊc��
				namec.add(student.getName());
				c++;
			} else {                                                      //������ʮ��Ϊd��
				named.add(student.getName());
				d++;
			}
		}
		System.out.println("��ѧ�ɼ���ϸ��");
		System.out.println("A��ѧ����"+a+"��,�ֱ��ǣ�");
		for (String string : namea) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("B��ѧ����"+b+"��,�ֱ��ǣ�");
		for (String string : nameb) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("C��ѧ����"+c+"��,�ֱ��ǣ�");
		for (String string : namec) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("A��ѧ����"+d+"��,�ֱ��ǣ�");
		for (String string : named) {
			System.out.print(string+"     ");
		}
		System.out.println();
	}
	  //��������ɼ��ֶ�
	private static void groupJapan(ArrayList<Student> list) {
		int a=0;        //����a�ε�ѧ������
		int b=0;        //����b�ε�ѧ������
		int c=0;         //����c�ε�ѧ������
		int d=0;        //����d�ε�ѧ������
		ArrayList<String> namea = new ArrayList<>();             //���ڴ洢a��ѧ��������
		ArrayList<String> nameb = new ArrayList<>();              //���ڴ洢b��ѧ��������
		ArrayList<String> namec = new ArrayList<>();            //���ڴ洢c��ѧ��������
		ArrayList<String> named = new ArrayList<>();          //���ڴ洢d��ѧ��������
		for (Student student : list) {
			if (student.getJapan() >= 90) {                  //���ڵ��ھ�ʮ��Ϊa��
				namea.add(student.getName());
				a++;
			} else if (student.getJapan() >= 80) {       //���ڵ��ڰ�ʮ��Ϊb��
				nameb.add(student.getName());
				b++;
			} else if (student.getJapan() >= 70) {       //���ڵ�����ʮ��Ϊc��
				namec.add(student.getName());
				c++;
			} else {                                                      //������ʮ��Ϊd��
				named.add(student.getName());
				d++;
			}
		}
		System.out.println("����ɼ���ϸ��");
		System.out.println("A��ѧ����"+a+"��,�ֱ��ǣ�");
		for (String string : namea) {
			System.out.print(string +"     ");
		}
		System.out.println();
		System.out.println("B��ѧ����"+b+"��,�ֱ��ǣ�");
		for (String string : nameb) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("C��ѧ����"+c+"��,�ֱ��ǣ�");
		for (String string : namec) {
			System.out.print(string+"     ");
		}
		System.out.println();
		System.out.println("A��ѧ����"+d+"��,�ֱ��ǣ�");
		for (String string : named) {
			System.out.print(string+"     ");
		}
		System.out.println();
	}
}
