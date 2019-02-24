package test;

import util.Function;
import util.GetTime;
import util.Password;
import util.ShowStudent;
import util.ioStudent;

public class test {

	public static void main(String[] args) throws Exception {
		System.out.println(GetTime.getTime());             //显示当前时间
		System.out.println("欢迎使用学生系统.");
		System.out.println("请输入登入密码。");
		Password.pass();                                     //检验密码是否正确
		System.out.println("密码正确，欢迎进入。");
		ioStudent.saveLog("  进入系统");                  //记录进入信息
		System.out.println("学生信息如下:");
		ShowStudent.show();                              //展示学生信息
		ioStudent.saveStudent();                        //将学生信息存入txt文件
		System.out.println("进入操作页面");
		Function.func();                                      //调用操作函数
		System.out.println(GetTime.getTime());           //显示当前时间
		System.out.println("欢迎再次使用");
		ioStudent.saveLog("  退出系统");            //记录退出信息
	}

}
