package util;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.Subject;

import org.junit.Test;

import bean.GetStudents;
import bean.Student;
//操作函数，包含查询和修改操作
public class Function {
	
	public static void func() throws Exception{
		System.out.println("请选择操作，查询请按1，修改请按2");
		Scanner sc = new Scanner(System.in);
		String str;
		while(true){
			str = sc.nextLine();                      //对操作进行选择
			switch(str){
			case "1" :
				select();                               //查询操作
				System.out.println("继续操作请按1，退出请按0");
				String quit = sc.nextLine();
				if (quit.equals("1")) {
					func();
				}
				break;
			case "2" :
				update();                           //修改操作
				System.out.println("修改结束,学生信息如下");
				ShowStudent.show();           //展示学生信息
				ioStudent.saveStudent();     //将学生信息记录到txt文件
				System.out.println("继续操作请按1，退出请按0");
				String quit2 = sc.nextLine();
				if (quit2.equals("1")) {
					func();
				}
				break;
			default : 
				System.out.println("请重新输入。");
				break;
			}
			boolean b= str.equals("1") || str.equals("2");
			if (b) {
				break;
			}
		}
		
	}
	//修改操作
	private static void update() throws Exception {
		System.out.println("请输入学生的id");
		Scanner sc = new Scanner(System.in);
		String str;                      //记录学生id
		while(true){                                         //获取学生id
			str = sc.nextLine();
			if (str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4")) {
				break;
			}else{
				System.out.println("未找到该id的学生,请重新输入.");
			}
		}
		Student s = gets(str);         //获取学生对象
		System.out.println("请选择操作:");
		System.out.println("修改日语成绩请按1，修改数学成绩请按2，修改英语成绩请按3");
		while(true){
			String string = sc.nextLine();   //记录选择的修改操作
			switch(string){                  //选择修改操作
			case "1" :
				setJapan(s);          //修改日语
				System.out.println("修改成功");
				System.out.println("继续修改请按1,退出修改请按0");
				String quit = sc.nextLine();
				if (quit.equals("1")) {
					update();
				}
				break;
			case "2" :
				setMath(s);          //修改数学
				System.out.println("修改成功");
				System.out.println("继续修改请按1,退出修改请按0");
				String quit1 = sc.nextLine();
				if (quit1.equals("1")) {
					update();
				}
				break;
			case "3" :
				setEnglish(s);       //修改英语
				System.out.println("修改成功");
				System.out.println("继续修改请按1,退出修改请按0");
				String quit2 = sc.nextLine();
				if (quit2.equals("1")) {
					update();
				}
				break;
			default : 
				break;
			}
			if (string.equals("1") || string .equals("2") || string .equals("3")) {
				break;
			} else {
				System.out.println("请重新输入");
			}
		}
		
	}
	//修改英语成绩
	private static void setEnglish(Student s) throws Exception {
			System.out.println("原英语成绩："+ s.getEnglish());
			System.out.println("请输入新成绩");
			Scanner sc = new Scanner(System.in);
			String english = sc.nextLine();                     //输入新成绩
			ioStudent.saveLog("进行操作：修改英语成绩成绩--------"+s.getEnglish()+"->"+english);    //记录日志
			s.setEnglish(Integer.parseInt(english));        //修改成绩
			s.setSum(s.getEnglish()+s.getJapan()+s.getMath());      //修改总分
			SetRank.set();                                             //修改排名
	}
	//修改数学成绩
	private static void setMath(Student s) throws Exception {
			System.out.println("原数学成绩："+ s.getMath());
			System.out.println("请输入新成绩");
			Scanner sc = new Scanner(System.in);
			String math = sc.nextLine();                     //输入新成绩
			ioStudent.saveLog("进行操作：修改数学成绩成绩--------"+s.getMath()+"->"+math);    //记录日志
			s.setMath(Integer.parseInt(math));        //修改成绩
			s.setSum(s.getEnglish()+s.getJapan()+s.getMath());      //修改总分
			SetRank.set();                                             //修改排名
	}
	//修改日语成绩
	private static void setJapan(Student s) throws Exception {
			System.out.println("原日语成绩："+ s.getJapan());
			System.out.println("请输入新成绩");
			Scanner sc = new Scanner(System.in);
			String japan = sc.nextLine();                     //输入新成绩
			ioStudent.saveLog("进行操作：修改日语成绩成绩--------"+s.getJapan()+"->"+japan);    //记录日志
			s.setJapan(Integer.parseInt(japan));        //修改成绩
			s.setSum(s.getEnglish()+s.getJapan()+s.getMath());      //修改总分
			SetRank.set();                                             //修改排名
	}
	 //通过学生id来获取学生对象	
	public static Student gets(String id) {
		ArrayList<Student> list = GetStudents.getStudent();           //获取全部学生	  
		for (Student student : list) {
			if (student.getId().equals(id)) {
				return student;                                                        //返回学生对象
			} 		
		}
		return Student.miku;	
	}
	
	//查询操作
	private static void select() throws Exception {
		ioStudent.saveLog("进行操作：查询");
		System.out.println("查学生请按1，查学科请按2");
		Scanner sc = new Scanner(System.in);
		while(true){
			String str = sc.nextLine();
			switch(str){
			case "1" :
				selStudent();
				System.out.println("继续查找请按1，退出请按0");
				String quit = sc.nextLine();
				if (quit.equals("1")) {
					select();
				}
				break;
			case "2" :
				selClass();
				System.out.println("继续查找请按1，退出请按0");
				String quit2 = sc.nextLine();
				if (quit2.equals("1")) {
					select();
				}
				break;
			default : 
				System.out.println("请重新输入");
				break;
			}
			if (str.equals("1") || str.equals("2")) {
				break;
			}
		}
	}
	//按学科查
	private static void selClass() {
		System.out.println("请选择想要查询的学科：");
		System.out.println("日语请按1，数学请按2，英语请按3");
		Scanner sc = new Scanner(System.in);
		String subject;                
		while(true){                            //获得学科
			subject = sc.nextLine();    
			if (subject.equals("1") || subject.equals("2") || subject.equals("3")) {
				break;
			} else {
				System.out.println("请重新输入");
			}
		}
		showAvg.show(subject);                          //输出该学科的平均成绩
		SortStudent.sort(subject);                        //输出该学科各学生的排名
		GroupStudent.group(subject);                //输出该学科各学生的分数段
	}
	
	//按学生查
	private static void selStudent() {
		System.out.println("请输入学生id");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		Student s = gets(id);                       //通过id获取学生对象
		System.out.println("id："+s.getId()+"     "+"姓名：" +s.getName()+"     "+"日语成绩：" +s.getJapan()
		+"     "+"数学成绩：" +s.getMath()+"     "+"英语成绩：" +s.getEnglish()+"     " +"总成绩：" +s.getSum()
		+"     "+"班级排名"+ s.getRank());
	}
}
