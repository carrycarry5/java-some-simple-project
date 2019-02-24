package utils;

import java.sql.SQLException;
import java.util.IdentityHashMap;
import java.util.Set;

import bean.Student;
import dao.jdbc_select;

public  class GetTenScore {
	private static  double avg=0;
	private static double max=0;
	private static Student maxScoreStudent = null;
	private static IdentityHashMap< String , Student> map = null;
	private static Set<String > set = null;
	
	//�������˵�ƽ���ɼ�
	public static double getAvg() throws SQLException{
		map = jdbc_select.getMap();
		set = map.keySet();
		int i = 0;  //���ڼ�������10��ֹͣѭ��
		for (String string : set) {
			i++;
			Student s = map.get(string);
			avg += s.score();
			if (i==10) {
				break;
			}	
		}
		return avg/i;
	}
	
	//����߳ɼ���
	public static Student getMax() throws SQLException{
		map = jdbc_select.getMap();
		set = map.keySet();
		int i=0;
		for (String string : set) {
			i++;
			double score = map.get(string).score();
			if (max < score) {
				max = score;
				maxScoreStudent = map.get(string);
			}
			if (i==10) {
				break;
			}
		}
		return maxScoreStudent;
	}
}
