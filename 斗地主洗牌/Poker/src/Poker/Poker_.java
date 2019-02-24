package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Poker_ {

	public static void main(String[] args) {
		//1.准备牌
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","k","A","2"};
		String[] color = {"红桃","黑桃","方块","梅花"};
		
		HashMap<Integer, String> hm = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();            //创建索引的集合
		
		int index=0;
		for(String s1 : num){
			for (String s2 : color) {
				hm.put(index, s2.concat(s1));               //将扑克存入HashMap
				list.add(index);                                    //将索引存入ArrayList集合
				index++;
			}
		}
		
		hm.put(index, "小王");
		list.add(index);
		index++;
		hm.put(index, "大王");
		list.add(index);
				
		//2.洗牌
		Collections.shuffle(list);
			
		//3.发牌
		TreeSet<Integer> 李澜涛 = new TreeSet<>();
		TreeSet<Integer> 谌梁 = new TreeSet<>();
		TreeSet<Integer> 游成 = new TreeSet<>();
		TreeSet<Integer> 底牌 = new TreeSet<>();
		
		for(int i = 0 ; i < list.size() ; i ++ ){                        //分配索引
			if (i<3) {
				底牌.add(list.get(i));
			}else if (i % 3 == 0) {
				李澜涛.add(list.get(i));
			}else if (i % 3 == 1) {
				谌梁.add(list.get(i));
			}else if (i % 3 == 2) {
				游成.add(list.get(i));
			}
		}
		
		//4.看牌
		System.out.println("--------------------------\n李澜涛的牌是：");
		lookpoker(hm, 李澜涛);
		System.out.println("--------------------------\n谌梁的牌是：");
		lookpoker(hm, 谌梁);
		System.out.println("--------------------------\n游成的牌是：");
		lookpoker(hm, 游成);
		System.out.println("--------------------------\n底牌是：");
		lookpoker(hm, 底牌);
	}
	//看牌函数
	public static void lookpoker( HashMap<Integer, String> hm , TreeSet<Integer> ts){
		for (Integer integer : ts) {
			System.out.print(hm.get(integer) + "  ");
		}
		System.out.println();
	}

}
