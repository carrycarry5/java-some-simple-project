package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import dao.jdbc_add;

public class Add_product {
	//���
	public static void add_product() throws FileNotFoundException, IOException, SQLException{
		String name = null;
		int num = 0;
		String intime = null;
		String category = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫ��ӵĲ�Ʒ����");
		name = sc.next();
		System.out.println("������Ҫ�ò�Ʒ����Ŀ");
		num = sc.nextInt();
		System.out.println("������ò�Ʒ�����");
		category = sc.next();
		
		intime = GetCurrentTime.getTime();       //��ȡ��ǰʱ��
		System.out.println(intime);
		//������Ϣ���浽���ݿ�
		jdbc_add.add(name, num, intime, category);
		
		System.out.println("��ӳɹ�");
	}
}
