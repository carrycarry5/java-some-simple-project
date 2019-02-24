package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.jdbc_add;
import dao.jdbc_select;

public class SendPost {
	static String message = null;
	static  String time = null;
	static  String name = null;
	public static  void send() throws FileNotFoundException, IOException, SQLException{
		
		
		System.out.println("��ӭ��������ҳ��");
		System.out.println("��������Ҫ���������ݣ�");
		Scanner sc = new Scanner(System.in);
		message = sc.next();
		time = GetCurrentTime.getTime();
		name = Login_register.getName();                      //��ȡ��ǰ��¼���û���
		System.out.println(name);
		jdbc_add.addPost(time, message, name);             //�����Ϣ�����ݿ�
		System.out.println("�����ɹ�");
		
		
		jdbc_select.selectPost();              //ִ�в�ѯ
		System.out.println("************************");
		System.out.println("���ӱ�ţ�"+jdbc_select.getIds().get(jdbc_select.getIds().size()-1));
		System.out.println("���ߣ�"+name);
		System.out.println("����ʱ�䣺"+time);
		System.out.println("���ݣ�"+message);
		System.out.println("************************");
		
		System.out.println("�ظ���1�����ظ���2");
		String num  = sc.next();
		switch (num) {
		case "1":
			reply();                //�ظ�ҳ��
			break;
		case "2":
			System.out.println("���η������");
			break;
		default:
			break;
		}
		
	}
	
	public static void reply() throws FileNotFoundException, IOException, SQLException{
		System.out.println("***��ӭ�����ظ�ҳ��***");
		System.out.println("��������Ļظ�");
		String replyMessage = new Scanner(System.in).next();
		String replyAuthor = name;
		String time = GetCurrentTime.getTime();
		
		jdbc_add.addReply(replyMessage, replyAuthor, time);          //����Ϣ�������ݿ�
		
		System.out.println("�ظ��ɹ�");
		
		System.out.println("*****************************");
		System.out.println("�ظ������ǳƣ�" + name);
		System.out.println("�ظ�ʱ�䣺"+ time);
		System.out.println("�ظ����ݣ�"+replyMessage);
		System.out.println("���η������");
	}
	
	
}
