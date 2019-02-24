package util;



import java.util.ArrayList;

import dao.GetMarket1;
import dao.GetMarket2;
import dao.UpdateLog;
import dao.UpdateMarket;
import dao.UpdateStore;
import domain.Market1;
import domain.Market2;

public class BuyBook {
	public static void buyBook() throws Exception{
		System.out.println("��ӭ����������棺");
		System.out.println("��ѡ��Ӧ�̡�");
		ArrayList<Market1> list1= GetMarket1.market1List;             //��ȡ���ҹ�Ӧ�̵���Ʒ��Ϣ
		ArrayList<Market2> list2 = GetMarket2.market2List; 
		System.out.println("**********������**********");
		for (Market1 market1 : list1) {
			System.out.println(market1.getId()+"\t��" +market1.getName()+"��\t      " +market1.getPrice()+"Ԫ\t      " +market1.getNumber()+"��");
		}
		System.out.println("**********ϲ������**********");
		for (Market2 market2 : list2) {
			System.out.println(market2.getId()+"\t��" +market2.getName()+"��\t      " +market2.getPrice()+"Ԫ\t      " +market2.getNumber()+"��");
		}
		
		System.out.println("�������밴1��ϲ�������밴2");
		String s = ScannString.scannString();
		select(s);                 //ѡ��
	}
	
	public static void select(String s) throws Exception{                                //ѡ��Ӧ��
		while(true){
			switch(s){
			case "1" :
				select1();
				break;
			case "2":
				select2();
				break;
			}
			if (s.equals("1") || s.equals("2")) {
				break;
			} else{
				System.out.println("�����������������");
			}
			s=ScannString.scannString();
		}
	}
	//ѡ���˹�Ӧ��һ
	public static void select1() throws Exception{
		System.out.println("��ѡ���˵���������");
		System.out.println("��ѡ���������id");
		ArrayList<Integer> idlist = new ArrayList<>();              //���弯�����ڴ�id
		ArrayList<Market1> list = GetMarket1.market1List;       //��ȡȫ������
		for (Market1 market1 : list) {
			idlist.add(market1.getId());
		}
		int id = getID(idlist);                                      //���id
		int num= list.get(id-1).getNumber();                 //��ȡ���
		System.out.println("��ѡ��������");
		int change = getNum1(list, id);                            //��ù�����Ŀ
		String sql = "update market1 set number=? where id=?";             //����sql���
		UpdateMarket.update(sql, num-change,id);            //���½���������
		String sql1 = "update store set number=? where id=?";
		UpdateStore.update(sql1, change, id);                     //�����������
		String time = GetDate.getDate();                           //��ȡ��ǰʱ��
		
		String sql2 = "insert into inLog values(null,?,?,?)";
		String bookName = list.get(id-1).getName();                      //�������
		String content  = "�ӵ���������".concat(bookName).concat("��");
		UpdateLog.update(sql2, time, content, change);         //���¹�����־
	}
	//ѡ���˹�Ӧ�̶�
	public static void select2() throws Exception{
		System.out.println("��ѡ����ϲ�����Ž���");
		System.out.println("��ѡ���������id");
		ArrayList<Integer> idlist = new ArrayList<>();            //���弯�����ڴ�id
		ArrayList<Market2> list = GetMarket2.market2List;    //��ȡȫ������
		for (Market2 market2 : list) {
			idlist.add(market2.getId());
		}
		int id = getID(idlist);                                         //���id
		int num = list.get(id-1).getNumber();              //��ÿ��
		System.out.println("������������");
		int change = getNum2(list, id);                                          //��ù�����Ŀ
		String sql = "update market2 set number=? where id=?";         //�������
		UpdateMarket.update(sql, num-change, id);             //���½���������
		String sql1 = "update store set number=? where id=?";
		UpdateStore.update(sql1, change, id);                            //�����������
		
		String time = GetDate.getDate();                                //��ȡ��ǰʱ��
		String sql2 = "insert into inLog values(null,?,?,?)";
		String bookName = list.get(id-1).getName(); 
		String content  = "��ϲ������������".concat(bookName).concat("��");
		UpdateLog.update(sql2, time, content, change);
	}
		//��ȡ�������Ŀ
	public static int getNum1(ArrayList<Market1> list, int id) {
		int num=0;                                             //��������
		while(true){
			String nums = ScannString.scannString();
			try {
				num=Integer.parseInt(nums);
			} catch (Exception e) {
				System.out.println("�����������������");
			}
			int amount = list.get(id-1).getNumber();            //��ȡ����Ŀ��
			if (num>amount) {
				System.out.println("��治�㣬����������");
			} else if (num<=0) {
				System.out.println("�������������������������");
			} else {
				break;
			}
		}
		return num;
	}
	//��ȡ�������Ŀ
	public static int getNum2(ArrayList<Market2> list, int id) {
		int num=0;                                             //��������
		while(true){
			String nums = ScannString.scannString();
			try {
				num=Integer.parseInt(nums);
			} catch (Exception e) {
				System.out.println("�����������������");
			}
			int amount = list.get(id-1).getNumber();            //��ȡ����Ŀ��
			if (num>amount) {
				System.out.println("��治�㣬����������");
			} else if (num<=0) {
				System.out.println("�������������������������");
			} else {
				break;
			}
		}
		return num;
	}
	//��ȡ�������id��
	public static int getID(ArrayList<Integer> idlist) {
		String ids = null;
		int id=0;                                                     //����id��
		while(true){
			ids = ScannString.scannString();
			try {
				id = Integer.parseInt(ids);                   //������������ĸ��ץ
			} catch (NumberFormatException e) {
				
			}
			if (idlist.contains(id)) {
				break;                    //��������id�Ŵ��ھ��˳�ѭ��
			} else {
				System.out.println("δ�ҵ���id���飬����������");
			}
		}
		return id;
	}

	
	
}



