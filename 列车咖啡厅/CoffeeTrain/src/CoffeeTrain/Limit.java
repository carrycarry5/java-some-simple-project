package CoffeeTrain;

public class Limit {
	public boolean lim(int a,int min,int max){
		if(a<min || a>max){
			System.out.println("�����������������!");
			return true;
		}
		return false;
	}
}
