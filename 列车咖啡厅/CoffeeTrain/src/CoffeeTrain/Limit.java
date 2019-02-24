package CoffeeTrain;

public class Limit {
	public boolean lim(int a,int min,int max){
		if(a<min || a>max){
			System.out.println("输入错误，请重新输入!");
			return true;
		}
		return false;
	}
}
