package util;

import java.util.ArrayList;


import dao.GetStore;
import dao.UpdateLog;
import dao.UpdateStore;
import domain.Store;

public class BackBook {
	public static void backBook() throws Exception{
		System.out.println("��ӭ����������棺");
		System.out.println("�������������Ӧ��id��");
		ArrayList<Store> list = GetStore.storeList;                  //��ȡ���ȫ�������
		for (Store store : list) {
			System.out.println(store.getId()+"\t" +store.getName());
		}
		int id=getID();                                        //��ȡid
		System.out.println("����Ҫ�˼�����");
		int num = getNum();                             //�������
		String sql = "update store set number=? where id=?";
		UpdateStore.update(sql, num, id);                //�޸�������ݿ���Ϣ
		
		String sql1 = "insert into backlog values(null,?,?,?)";
		String time = GetDate.getDate();                 //��ȡ��ǰʱ��
		String bookName = list.get(id-1).getName();    //��ȡ����
		String content = "�˿����飺��".concat(bookName).concat("��");
		UpdateLog.update(sql1, time, content, num);             //�����˻�����Ϣ
	}

	private static int getNum() {
		String nums=null;
		int num = 0;
		while(true){
			nums=ScannString.scannString();
			try {
				num=Integer.parseInt(nums);
			} catch (NumberFormatException e) {
				
			}
			if (num <= 0 ) {
				System.out.println("�������������������������");
			} else{
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
}
