package Train;

import java.util.Scanner;

public class Place {                                        //���๦�ܣ�����Ŀ�ĵز��жϣ�����Ŀ�ĵص����
	SetTrain setTrain = new SetTrain();
	Object[] arr = setTrain.add();                                          //��������
	
	public int place(){
		
		
		Scanner scanner = new Scanner(System.in);
		
		String s= scanner.nextLine();                                         //����Ŀ�ĵ�
		
		while(true){                                                                  //�ж������Ƿ�ϸ�
		if(num(s) == -1){
			System.out.println("����������������룺");
			s= scanner.nextLine(); 
		}
		else break;
		}
		
		return num(s);
	}
	
	public int num(String s){                             //�ҵ�Ŀ�ĵص���ŵĺ���
		for(int i = 0 ;i<arr.length ;i++){
			Train t =  (Train) arr[i];                         //����ת��ΪTrain
			if(s.equals(t.getPlace())){
				return i;
			}
		}
		return -1;
	}
}
