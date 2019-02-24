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
	
	//求所有人的平均成绩
	public static double getAvg() throws SQLException{
		map = jdbc_select.getMap();
		set = map.keySet();
		int i = 0;  //用于计数，到10就停止循环
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
	
	//求最高成绩者
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
