package CoffeeTrain;

import java.util.ArrayList;
import java.util.Collection;

public class SetCoffee {
	Collection c = new ArrayList();
	
	public Object[] set() {
		c.add(new Coffee("��ʽ����", 10));
		c.add(new Coffee("�׿���", 15));
		c.add(new Coffee("�����", 20));
		c.add(new Coffee("������", 25));
		c.add(new Coffee("����", 30));
		c.add(new Coffee("���з�", 40));
		c.add(new Coffee("������ŵ", 50));
		
		Object[] arr = c.toArray();	
		return arr;
	}
}
