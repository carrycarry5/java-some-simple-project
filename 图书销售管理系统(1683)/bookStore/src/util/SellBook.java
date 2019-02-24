package util;

import java.util.ArrayList;

import dao.GetStore;
import dao.UpdateLog;
import dao.UpdateStore;
import domain.Store;

public class SellBook {
	public static void sellBook() throws Exception{
		System.out.println("��ӭ�����������");
		ArrayList<Store> list = GetStore.storeList;                //��ȡ���ȫ�������
		showBook(list);                                                       //���ȫ������Ϣ
		System.out.println("��������Ҫ�������id��");
		int id=getID();                                                       //��ȡid
		int amount=getamount(id);                                                     //��ȡ�����
		System.out.println("��������Ҫ���������");
		int num = getNum(amount);                                              //��ȡ����
		String sql = "update store set number=? where id=?"; 
		UpdateStore.update(sql, -num, id);                                   //�޸������Ϣ
		
		String date = GetDate.getDate();                                         //��ȡ��ǰʱ��
		String sql1 = "insert into selllog values(null,?,?,?)";
		String bookName = list.get(id-1).getName();                  //�������
		String content = "�˿����飺��".concat(bookName).concat("��");
		UpdateLog.update(sql1, date, content, num);              //�޸�������־
	}

	private static int getamount(int id) {
		int num = GetStore.storeList.get(id-1).getNumber();
		return num;
	}

	private static int getNum(int amount) {
		String nums=null;
		int num = 0;
		while(true){
			nums=ScannString.scannString();
			try {
				num=Integer.parseInt(nums);
			} catch (NumberFormatException e) {
				
			}
			if (num <= 0 ) {
				System.out.println("������������߸���������������");
			} else if (num> amount) {
				System.out.println("��治�㣬����������");
			} else {
				break;
			}
		}
		return num;
	}

	private static int getID() {
		String id=null;
		while(true){
			id = ScannString.scannString();              //����id
			if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
				break;
			} else{
				System.out.println("�����������������");
			}
		}
		return Integer.parseInt(id);
	}

	private static void showBook(ArrayList<Store> list) {
		for (Store store : list) {
			System.out.println(store.getId()+"\t"+store.getName()+"\t"+"��棺"+store.getNumber()+"\t"+
		"���ۣ�"+store.getPrice()+"Ԫ");
		}
	}


}
