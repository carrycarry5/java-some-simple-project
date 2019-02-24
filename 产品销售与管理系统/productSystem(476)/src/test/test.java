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
		System.out.println("***欢迎使用产品管理销售系统***");
		while(true){
			System.out.println("查询仓库请按1，进货请安2，出货请按3");
			i = sc.nextInt();
			if (i!=1 && i!=2 && i!=3) {
				System.out.println("输入错误，请重新输入");
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
		System.out.println("退出请按1，继续请按2");
		int i  = sc.nextInt();
		if (i!=1 && i!=2) {
			System.out.println("输入错误，请重新输入");
			method2(sc);
		}
		switch (i) {
		case 1:
			System.out.println("欢迎再次使用，bye~");
			break;
		case 2:
			method1();
		default:
			break;
		}
	}
}
