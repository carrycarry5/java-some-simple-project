package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Set;

import bean.Student;
import bean.putonStudent;
import dao.jdbc_select;
import utils.GetScore;
import utils.GetTenScore;
import utils.InputStudent;

public class test {
	public static void main(String[] args) throws SQLException, IOException {
		//���ƽ���ɼ�
		//System.out.println(GetScore.getAvg());
		//�����߳ɼ���ѧ����Ϣ
		//System.out.println("��߳ɼ���"+GetScore.getMax().score() + "       ��ѧ������Ϣ��"+GetScore.getMax());
		//���10λѧ����ƽ���ɼ�
		//System.out.println(GetTenScore.getAvg());
		//���10λѧ������߳ɼ���ѧ����Ϣ
		//System.out.println("��߳ɼ���"+GetTenScore.getMax().score() + "       ��ѧ������Ϣ��"+GetTenScore.getMax());
		
		InputStudent.input();
	}


}
