package util;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.Subject;

import org.junit.Test;

import bean.GetStudents;
import bean.Student;
//����������������ѯ���޸Ĳ���
public class Function {
	
	public static void func() throws Exception{
		System.out.println("��ѡ���������ѯ�밴1���޸��밴2");
		Scanner sc = new Scanner(System.in);
		String str;
		while(true){
			str = sc.nextLine();                      //�Բ�������ѡ��
			switch(str){
			case "1" :
				select();                               //��ѯ����
				System.out.println("���������밴1���˳��밴0");
				String quit = sc.nextLine();
				if (quit.equals("1")) {
					func();
				}
				break;
			case "2" :
				update();                           //�޸Ĳ���
				System.out.println("�޸Ľ���,ѧ����Ϣ����");
				ShowStudent.show();           //չʾѧ����Ϣ
				ioStudent.saveStudent();     //��ѧ����Ϣ��¼��txt�ļ�
				System.out.println("���������밴1���˳��밴0");
				String quit2 = sc.nextLine();
				if (quit2.equals("1")) {
					func();
				}
				break;
			default : 
				System.out.println("���������롣");
				break;
			}
			boolean b= str.equals("1") || str.equals("2");
			if (b) {
				break;
			}
		}
		
	}
	//�޸Ĳ���
	private static void update() throws Exception {
		System.out.println("������ѧ����id");
		Scanner sc = new Scanner(System.in);
		String str;                      //��¼ѧ��id
		while(true){                                         //��ȡѧ��id
			str = sc.nextLine();
			if (str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4")) {
				break;
			}else{
				System.out.println("δ�ҵ���id��ѧ��,����������.");
			}
		}
		Student s = gets(str);         //��ȡѧ������
		System.out.println("��ѡ�����:");
		System.out.println("�޸�����ɼ��밴1���޸���ѧ�ɼ��밴2���޸�Ӣ��ɼ��밴3");
		while(true){
			String string = sc.nextLine();   //��¼ѡ����޸Ĳ���
			switch(string){                  //ѡ���޸Ĳ���
			case "1" :
				setJapan(s);          //�޸�����
				System.out.println("�޸ĳɹ�");
				System.out.println("�����޸��밴1,�˳��޸��밴0");
				String quit = sc.nextLine();
				if (quit.equals("1")) {
					update();
				}
				break;
			case "2" :
				setMath(s);          //�޸���ѧ
				System.out.println("�޸ĳɹ�");
				System.out.println("�����޸��밴1,�˳��޸��밴0");
				String quit1 = sc.nextLine();
				if (quit1.equals("1")) {
					update();
				}
				break;
			case "3" :
				setEnglish(s);       //�޸�Ӣ��
				System.out.println("�޸ĳɹ�");
				System.out.println("�����޸��밴1,�˳��޸��밴0");
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
				System.out.println("����������");
			}
		}
		
	}
	//�޸�Ӣ��ɼ�
	private static void setEnglish(Student s) throws Exception {
			System.out.println("ԭӢ��ɼ���"+ s.getEnglish());
			System.out.println("�������³ɼ�");
			Scanner sc = new Scanner(System.in);
			String english = sc.nextLine();                     //�����³ɼ�
			ioStudent.saveLog("���в������޸�Ӣ��ɼ��ɼ�--------"+s.getEnglish()+"->"+english);    //��¼��־
			s.setEnglish(Integer.parseInt(english));        //�޸ĳɼ�
			s.setSum(s.getEnglish()+s.getJapan()+s.getMath());      //�޸��ܷ�
			SetRank.set();                                             //�޸�����
	}
	//�޸���ѧ�ɼ�
	private static void setMath(Student s) throws Exception {
			System.out.println("ԭ��ѧ�ɼ���"+ s.getMath());
			System.out.println("�������³ɼ�");
			Scanner sc = new Scanner(System.in);
			String math = sc.nextLine();                     //�����³ɼ�
			ioStudent.saveLog("���в������޸���ѧ�ɼ��ɼ�--------"+s.getMath()+"->"+math);    //��¼��־
			s.setMath(Integer.parseInt(math));        //�޸ĳɼ�
			s.setSum(s.getEnglish()+s.getJapan()+s.getMath());      //�޸��ܷ�
			SetRank.set();                                             //�޸�����
	}
	//�޸�����ɼ�
	private static void setJapan(Student s) throws Exception {
			System.out.println("ԭ����ɼ���"+ s.getJapan());
			System.out.println("�������³ɼ�");
			Scanner sc = new Scanner(System.in);
			String japan = sc.nextLine();                     //�����³ɼ�
			ioStudent.saveLog("���в������޸�����ɼ��ɼ�--------"+s.getJapan()+"->"+japan);    //��¼��־
			s.setJapan(Integer.parseInt(japan));        //�޸ĳɼ�
			s.setSum(s.getEnglish()+s.getJapan()+s.getMath());      //�޸��ܷ�
			SetRank.set();                                             //�޸�����
	}
	 //ͨ��ѧ��id����ȡѧ������	
	public static Student gets(String id) {
		ArrayList<Student> list = GetStudents.getStudent();           //��ȡȫ��ѧ��	  
		for (Student student : list) {
			if (student.getId().equals(id)) {
				return student;                                                        //����ѧ������
			} 		
		}
		return Student.miku;	
	}
	
	//��ѯ����
	private static void select() throws Exception {
		ioStudent.saveLog("���в�������ѯ");
		System.out.println("��ѧ���밴1����ѧ���밴2");
		Scanner sc = new Scanner(System.in);
		while(true){
			String str = sc.nextLine();
			switch(str){
			case "1" :
				selStudent();
				System.out.println("���������밴1���˳��밴0");
				String quit = sc.nextLine();
				if (quit.equals("1")) {
					select();
				}
				break;
			case "2" :
				selClass();
				System.out.println("���������밴1���˳��밴0");
				String quit2 = sc.nextLine();
				if (quit2.equals("1")) {
					select();
				}
				break;
			default : 
				System.out.println("����������");
				break;
			}
			if (str.equals("1") || str.equals("2")) {
				break;
			}
		}
	}
	//��ѧ�Ʋ�
	private static void selClass() {
		System.out.println("��ѡ����Ҫ��ѯ��ѧ�ƣ�");
		System.out.println("�����밴1����ѧ�밴2��Ӣ���밴3");
		Scanner sc = new Scanner(System.in);
		String subject;                
		while(true){                            //���ѧ��
			subject = sc.nextLine();    
			if (subject.equals("1") || subject.equals("2") || subject.equals("3")) {
				break;
			} else {
				System.out.println("����������");
			}
		}
		showAvg.show(subject);                          //�����ѧ�Ƶ�ƽ���ɼ�
		SortStudent.sort(subject);                        //�����ѧ�Ƹ�ѧ��������
		GroupStudent.group(subject);                //�����ѧ�Ƹ�ѧ���ķ�����
	}
	
	//��ѧ����
	private static void selStudent() {
		System.out.println("������ѧ��id");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		Student s = gets(id);                       //ͨ��id��ȡѧ������
		System.out.println("id��"+s.getId()+"     "+"������" +s.getName()+"     "+"����ɼ���" +s.getJapan()
		+"     "+"��ѧ�ɼ���" +s.getMath()+"     "+"Ӣ��ɼ���" +s.getEnglish()+"     " +"�ܳɼ���" +s.getSum()
		+"     "+"�༶����"+ s.getRank());
	}
}
