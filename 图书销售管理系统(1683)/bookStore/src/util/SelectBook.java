package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.GetStore;
import domain.Store;

public class SelectBook {
	public static void selectBook(){
		ArrayList<Store> list = GetStore.storeList;                    //��ȡ���ȫ�������
		System.out.println("��ӭ�����ѯ����");
		System.out.println("������������ͨ��id��ѯ����ͨ��������ѯ");
		System.out.println("id�밴1�������밴2");
		String s = select();              //ѡ�����
		switch(s){
		case "1" :
			useID(list);
			break;
		case "2":
			useName(list);
			break;
		default :
			break;
		}
	}

	private static void useName(ArrayList<Store> list) {
		ArrayList<String> namelist = new ArrayList<>();                     //���ڴ�ȫ������
		Map<String, Integer> map = new HashMap<>();                  //map�������ڴ�id�Ͷ�Ӧ������
		for (Store store : list) {
			map.put(store.getName(),store.getId());     
			namelist.add(store.getName());
		}
		System.out.println("����������");
		String name=null;
		while(true){
			name=ScannString.scannString();
			if (namelist.contains(name)) {
				break;
			} else{
				System.out.println("���겻���ڸ����ֵ��飬����������");
			}
		}
		int i = map.get(name);              //���id
		Store store = list.get(i-1);
		System.out.println("id�ţ�"+store.getId()+"\t"+"������"+
		store.getName()+"��\t�۸�" +store.getPrice()+"Ԫ\t��棺" +store.getNumber()+"��");
		
	}

	private static void useID(ArrayList<Store> list) {
		
		ArrayList<Integer> ids = new ArrayList<>();                         //���ڴ�id�ļ���
		for (Store store : list) {
			ids.add(store.getId());
		}
		System.out.println("������id��");
		String id = null;
		while(true){
			id=ScannString.scannString();	
			if (ids.contains(Integer.parseInt(id))) {
				break;
			} else{
				System.out.println("�����������������");
			}
		}
		int idi = Integer.parseInt(id);
		Store store = list.get(idi-1);
		System.out.println("id�ţ�"+store.getId()+"\t"+"������"+
		store.getName()+"��\t�۸�" +store.getPrice()+"Ԫ\t��棺" +store.getNumber()+"��");
	}

	private static String select() {
		String s =null;
		while(true){
			s= ScannString.scannString();
			if (s.equals("1") || s.equals("2")) {
				break;
			} else{
				System.out.println("�����������������");
			}
		}
		return s;
	}
}
