package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.jdbc_select;
import dao.jdbc_update;

public class Out_product {
	//����
	public static void out_product() throws FileNotFoundException, IOException, SQLException{
		ArrayList<String > names = jdbc_select.getNames();
		String name = null;
		int outnum =  0 ; 
		String outtime = null;
		int num = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ�����Ļ�Ʒ����");
		name = scanner.next();
		if (!names.contains(name)) {
			System.out.println("�����ڸ���Ʒ������������");
			out_product();
		}
		System.out.println("���������������");
		outnum = scanner.nextInt();
		if (num>jdbc_select.getNum()) {
			System.out.println("�ֿ���ֻ��"+jdbc_select.getNum()+"��"+name);
			out_product();
		}
		System.out.println("�����ɹ�");
		
		
		num = jdbc_select.getNum()-outnum;        //���ʣ����Ŀ
		outtime = GetCurrentTime.getTime();    //��ȡ��ǰʱ��
		jdbc_update.update(name, outnum, outtime,num);
	}
}
