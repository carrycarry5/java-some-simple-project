package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Poker_ {

	public static void main(String[] args) {
		//1.׼����
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","k","A","2"};
		String[] color = {"����","����","����","÷��"};
		
		HashMap<Integer, String> hm = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();            //���������ļ���
		
		int index=0;
		for(String s1 : num){
			for (String s2 : color) {
				hm.put(index, s2.concat(s1));               //���˿˴���HashMap
				list.add(index);                                    //����������ArrayList����
				index++;
			}
		}
		
		hm.put(index, "С��");
		list.add(index);
		index++;
		hm.put(index, "����");
		list.add(index);
				
		//2.ϴ��
		Collections.shuffle(list);
			
		//3.����
		TreeSet<Integer> ������ = new TreeSet<>();
		TreeSet<Integer> ���� = new TreeSet<>();
		TreeSet<Integer> �γ� = new TreeSet<>();
		TreeSet<Integer> ���� = new TreeSet<>();
		
		for(int i = 0 ; i < list.size() ; i ++ ){                        //��������
			if (i<3) {
				����.add(list.get(i));
			}else if (i % 3 == 0) {
				������.add(list.get(i));
			}else if (i % 3 == 1) {
				����.add(list.get(i));
			}else if (i % 3 == 2) {
				�γ�.add(list.get(i));
			}
		}
		
		//4.����
		System.out.println("--------------------------\n�����ε����ǣ�");
		lookpoker(hm, ������);
		System.out.println("--------------------------\n���������ǣ�");
		lookpoker(hm, ����);
		System.out.println("--------------------------\n�γɵ����ǣ�");
		lookpoker(hm, �γ�);
		System.out.println("--------------------------\n�����ǣ�");
		lookpoker(hm, ����);
	}
	//���ƺ���
	public static void lookpoker( HashMap<Integer, String> hm , TreeSet<Integer> ts){
		for (Integer integer : ts) {
			System.out.print(hm.get(integer) + "  ");
		}
		System.out.println();
	}

}
