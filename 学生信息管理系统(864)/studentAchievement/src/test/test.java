package test;

import util.Function;
import util.GetTime;
import util.Password;
import util.ShowStudent;
import util.ioStudent;

public class test {

	public static void main(String[] args) throws Exception {
		System.out.println(GetTime.getTime());             //��ʾ��ǰʱ��
		System.out.println("��ӭʹ��ѧ��ϵͳ.");
		System.out.println("������������롣");
		Password.pass();                                     //���������Ƿ���ȷ
		System.out.println("������ȷ����ӭ���롣");
		ioStudent.saveLog("  ����ϵͳ");                  //��¼������Ϣ
		System.out.println("ѧ����Ϣ����:");
		ShowStudent.show();                              //չʾѧ����Ϣ
		ioStudent.saveStudent();                        //��ѧ����Ϣ����txt�ļ�
		System.out.println("�������ҳ��");
		Function.func();                                      //���ò�������
		System.out.println(GetTime.getTime());           //��ʾ��ǰʱ��
		System.out.println("��ӭ�ٴ�ʹ��");
		ioStudent.saveLog("  �˳�ϵͳ");            //��¼�˳���Ϣ
	}

}
