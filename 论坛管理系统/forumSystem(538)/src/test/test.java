package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.jdbc_select;
import utils.GetCurrentTime;
import utils.Login_register;

public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		jdbc_select.select();               //��ѯ���ݿ⣬��ȡ��Ϣ
		Scanner sc = new Scanner(System.in);
		System.out.println("***��ӭ������̳������Ϣϵͳ***");
		System.out.println("��¼�밴1��ע���밴2");
		String num = sc.next();
		Login_register.login_register(num);            //ִ�е�¼��ע��
	}
}
