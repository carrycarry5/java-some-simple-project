package Train;

import java.util.ArrayList;
import java.util.Collection;


public class SetTrain {                                  //本类功能：设置车辆
	
	Collection c = new ArrayList();
	
	public Object[] add(){	
		
		c.add(new Train(1,18,"赣州","T001",100.0));
		c.add(new Train(1,18,"北京","T002",200.0));
		c.add(new Train(1,18,"上海","T003",200.0));
		c.add(new Train(1,18,"广州","T004",150.0));
		
		Object[] arr = c.toArray();
		
		return arr;
	}
}
