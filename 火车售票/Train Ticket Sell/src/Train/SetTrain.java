package Train;

import java.util.ArrayList;
import java.util.Collection;


public class SetTrain {                                  //���๦�ܣ����ó���
	
	Collection c = new ArrayList();
	
	public Object[] add(){	
		
		c.add(new Train(1,18,"����","T001",100.0));
		c.add(new Train(1,18,"����","T002",200.0));
		c.add(new Train(1,18,"�Ϻ�","T003",200.0));
		c.add(new Train(1,18,"����","T004",150.0));
		
		Object[] arr = c.toArray();
		
		return arr;
	}
}
