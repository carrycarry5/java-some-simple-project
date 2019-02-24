package utils;

import java.sql.SQLException;
import java.util.IdentityHashMap;
import java.util.Set;

import bean.Student;
import dao.jdbc_select;

public  class GetScore {
	private static  double avg=0;
	private static double max=0;
	private static Student maxScoreStudent = null;
	private static IdentityHashMap< String , Student> map = null;
	private static Set<String > set = null;
	
	//求所有人的平均成绩
	public static double getAvg() throws SQLException{
		map = jdbc_select.getMap();
		set = map.keySet();
		for (String string : set) {
			Student s = map.get(string);
			avg += s.score();
		}
		return avg/map.size();
	}
	
	//求最高成绩者
	public static Student getMax() throws SQLException{
		map = jdbc_select.getMap();
		set = map.keySet();
		for (String string : set) {
			double score = map.get(string).score();
			
			if (max < score) {
				max = score;
				maxScoreStudent = map.get(string);
			}
		}
		return maxScoreStudent;
	}
}
