package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.dgc.Lease;
import java.sql.SQLException;
import java.util.Scanner;

import dao.jdbc_add;
import dao.jdbc_select;
import utils.Add_product;
import utils.Out_product;
import utils.Select_product;

public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		method1();
	}


	public static void method1() throws FileNotFoundException, IOException, SQLException {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		System.out.println("***��ӭʹ�ò�Ʒ��������ϵͳ***");
		while(true){
			System.out.println("��ѯ�ֿ��밴1�������밲2�������밴3");
			i = sc.nextInt();
			if (i!=1 && i!=2 && i!=3) {
				System.out.println("�����������������");
			} else {
				break;
			}
		}
		switch (i) {
		case 1:
			Select_product.select();
			method2(sc);
			break;
		case 2:
			Add_product.add_product();
			method2(sc);
			break;
		case 3:
			Out_product.out_product();
			method2(sc);
		}
	}

		
	public static void method2(Scanner sc) throws FileNotFoundException, IOException, SQLException{
		System.out.println("�˳��밴1�������밴2");
		int i  = sc.nextInt();
		if (i!=1 && i!=2) {
			System.out.println("�����������������");
			method2(sc);
		}
		switch (i) {
		case 1:
			System.out.println("��ӭ�ٴ�ʹ�ã�bye~");
			break;
		case 2:
			method1();
		default:
			break;
		}
	}
}
