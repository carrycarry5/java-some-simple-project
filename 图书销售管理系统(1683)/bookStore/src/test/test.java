package test;

import util.GetDataFromMysql;
import util.SelectFunc;

public class test {

	public static void main(String[] args) throws Exception {
		GetDataFromMysql.getData();                    //�����ݿ��л�ȡ��Ϣ
		System.out.println("#######��ӭʹ��ͼ�����۹���ϵͳ#######");		
		SelectFunc.select();                           //ѡ�����                   	
	}

}
