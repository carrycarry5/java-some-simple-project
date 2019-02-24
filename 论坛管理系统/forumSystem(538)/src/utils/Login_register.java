package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.jdbc_add;
import dao.jdbc_select;

public class Login_register {
	private static String name = null;
	public static void login_register(String num) throws FileNotFoundException, IOException, SQLException{
		switch(num){
		case  "1" :
			login();               //ִ�е�¼
			break;
		case "2" :
			register();          //ִ��ע��
			break;
		default :
			break;
		}
	}
	
	//��¼
	public static void login() throws FileNotFoundException, IOException, SQLException{
		
		System.out.println("��ӭ������¼����");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("�����û���");
		name = sc2.next();
		        
		ArrayList< String > names = jdbc_select.getNames();    //��ȡnames����
		if (names.contains(name)) {                //����м�¼�����¼������ע��
			System.out.println("��¼�ɹ�");
			SendPost.send();                          //���뷢������
		} else {
			System.out.println("�޸��û�������ע��");
			register();        
		}
		
	}
	//ע��
	public static void register() throws FileNotFoundException, IOException, SQLException{
		System.out.println("��ӭ����ע�����");
		//������Ϣ�����������ǳơ��Ա����䡢ְҵ�����õ�
		String sex = null;
		String age = null;
		String job = null;
		String like = null;
		Scanner sc1 = new Scanner(System.in);
		System.out.println("�������������:");
		name = sc1.next();
		System.out.println("����������Ա�");
		sex = sc1.next();
		System.out.println("�������������");
		age = sc1.next();
		System.out.println("���������ְҵ");
		job = sc1.next();
		System.out.println("��������İ���");
		like = sc1.next();
		
		//����Ϣ�������ݿ�
		try {
			jdbc_add.add(name, sex, age, job, like);            //������������Ѹ��û����Ѵ��ڣ���ֱ�ӵ�¼
			System.out.println("ע��ɹ�");
			SendPost.send();                      //���뷢��ҳ��
		} catch (Exception e) {
			System.out.println("���û��Ѵ��ڣ���ֱ���������Ƶ�¼");
			login();                               //ִ�е�¼����
		}
		
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Login_register.name = name;
	}
	
	
}
