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
		jdbc_select.select();               //查询数据库，获取信息
		Scanner sc = new Scanner(System.in);
		System.out.println("***欢迎来到论坛管理信息系统***");
		System.out.println("登录请按1，注册请按2");
		String num = sc.next();
		Login_register.login_register(num);            //执行登录或注册
	}
}
