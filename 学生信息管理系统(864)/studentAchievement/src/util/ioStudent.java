package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import bean.GetStudents;
import bean.Student;

//����Ϣ����txt�ļ���
public class ioStudent {
	//��ѧ����Ϣ����txt�ļ���
	public static void saveStudent() throws Exception{
		ArrayList<Student > list = GetStudents.getStudent();
		BufferedWriter writer = new BufferedWriter(new FileWriter("D://ѧ���ɼ�����ϵͳ.txt",true));
		for (Student s : list) {
			writer.write("id��"+s.getId()+"     "+"������" +s.getName()+"     "+"����ɼ���" +s.getJapan()
			+"     "+"��ѧ�ɼ���" +s.getMath()+"     "+"Ӣ��ɼ���" +s.getEnglish()+"     " +"�ܳɼ���" +s.getSum()
			+"     "+"�༶����"+ s.getRank());
			writer.newLine();
		}
		writer.close();
	}
	//����־����txt�ļ���
	public static void saveLog(String log) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter("D://ѧ���ɼ�����ϵͳ.txt",true));
		writer.write(log);
		writer.newLine();
		writer.close();
	}
}
