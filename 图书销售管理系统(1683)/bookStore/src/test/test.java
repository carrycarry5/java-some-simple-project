package test;

import util.GetDataFromMysql;
import util.SelectFunc;

public class test {

	public static void main(String[] args) throws Exception {
		GetDataFromMysql.getData();                    //从数据库中获取信息
		System.out.println("#######欢迎使用图书销售管理系统#######");		
		SelectFunc.select();                           //选择操作                   	
	}

}
