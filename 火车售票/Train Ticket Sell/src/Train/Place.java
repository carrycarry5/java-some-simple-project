package Train;

import java.util.Scanner;

public class Place {                                        //本类功能：输入目的地并判断，返回目的地的序号
	SetTrain setTrain = new SetTrain();
	Object[] arr = setTrain.add();                                          //声明集合
	
	public int place(){
		
		
		Scanner scanner = new Scanner(System.in);
		
		String s= scanner.nextLine();                                         //输入目的地
		
		while(true){                                                                  //判断输入是否合格
		if(num(s) == -1){
			System.out.println("输入错误，请重新输入：");
			s= scanner.nextLine(); 
		}
		else break;
		}
		
		return num(s);
	}
	
	public int num(String s){                             //找到目的地的序号的函数
		for(int i = 0 ;i<arr.length ;i++){
			Train t =  (Train) arr[i];                         //向下转型为Train
			if(s.equals(t.getPlace())){
				return i;
			}
		}
		return -1;
	}
}
