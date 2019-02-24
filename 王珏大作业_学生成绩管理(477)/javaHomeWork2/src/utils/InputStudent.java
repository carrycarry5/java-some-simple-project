package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import bean.Student;
import dao.jdbc_add;

public class InputStudent {
	private static  String id = null;
	private static  String name = null;
	private static  double pingshi = 0;
	private  static double kaoshi = 0;
	private static  String type = null;
	
	public static void input() throws SQLException, IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("����Ҫ���뼸��ѧ������Ϣ���밴��Ӧ���֡�");
		int num = sc.nextInt();
		//����ѧ����Ϣ
		for(int i = 0 ; i <num ; i++){
			//������Ϣ
			scannerMessage(sc);
			//�������ݿ�
			jdbc_add.add(id, name, pingshi, kaoshi, type);
			//�����ļ�
			saveAsText();
		}
		
	}
	//����ѧ������Ϣ
	public static void scannerMessage(Scanner sc) {
		System.out.println("������ѧ����id");
		id = sc.next();
		System.out.println("������ѧ��������");
		name = sc.next();
		System.out.println("������ѧ����ƽʱ�ɼ�");
		pingshi = sc.nextDouble();
		System.out.println("������ѧ���Ŀ��Գɼ�");
		kaoshi = sc.nextDouble();
		System.out.println("������ѧ�������ͣ���ͨ����p �� ��������l �� �س�����t��");
		type = sc.next();
	}
	
	//��ѧ����Ϣ���뱾���ļ���
	public static void saveAsText() throws IOException{
		Student s = new Student(name, id, pingshi, kaoshi);
		File file = new File("D://javahomework2.txt");
		FileOutputStream fos = new FileOutputStream(file,true);
		String message = s.toString();
		fos.write(message.getBytes());
		fos.write("/r/n".getBytes());
		
		//�ͷ���Դ
		fos.close();
	}

}
