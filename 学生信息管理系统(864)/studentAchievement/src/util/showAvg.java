package util;

import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;

public class showAvg {
	//�����ѧ��ƽ��ֵ
		public static void show(String subject) {
			ArrayList<Student> list = GetStudents.getStudent();           //��ȡȫ��ѧ������
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
		//��������ɼ�ƽ��ֵ
		private static void showJapanAvg(ArrayList<Student> list) {
			double avg=0;
			for (Student student : list) {
				avg+=student.getJapan();
			}
			System.out.println("����ƽ���ɼ���"+ avg/4);
		}
		//������ѧ�ɼ�ƽ��ֵ
		private static void showMathAvg(ArrayList<Student> list) {
			double avg=0;
			for (Student student : list) {
				avg+=student.getMath();
			}
			System.out.println("��ѧƽ���ɼ���"+ avg/4);
		}
		//����Ӣ��ɼ�ƽ��ֵ
		private static void showEnglishAvg(ArrayList<Student> list) {
			double avg=0;
			for (Student student : list) {
				avg+=student.getEnglish();
			}
			System.out.println("Ӣ��ƽ���ɼ���"+ avg/4);
		}
}
