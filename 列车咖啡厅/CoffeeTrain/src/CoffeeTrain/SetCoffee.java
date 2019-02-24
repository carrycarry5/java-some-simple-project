package CoffeeTrain;

import java.util.ArrayList;
import java.util.Collection;

public class SetCoffee {
	Collection c = new ArrayList();
	
	public Object[] set() {
		c.add(new Coffee("ÃÀÊ½¿§·È", 10));
		c.add(new Coffee("°×¿§·È", 15));
		c.add(new Coffee("ÂêÆæ¶ä", 20));
		c.add(new Coffee("¿µ±¦À¼", 25));
		c.add(new Coffee("ÄÃÌú", 30));
		c.add(new Coffee("²¼ÁĞ·ò", 40));
		c.add(new Coffee("¿¨²¼ÆæÅµ", 50));
		
		Object[] arr = c.toArray();	
		return arr;
	}
}
