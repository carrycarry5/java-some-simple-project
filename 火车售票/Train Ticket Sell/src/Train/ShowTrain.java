package Train;

public class ShowTrain {                                           //���๦�ܣ����������Ϣ
	SetTrain sTrain = new SetTrain();
	
	public void show(){
		Object[] arr=sTrain.add();
		
		for(int i=0;i<arr.length ;i++){
		Train t = (Train) arr[i];                        //����ǿתΪTrain
		System.out.println("*     "+t.getMonth()+"��"+t.getDay()+"��     "+t.getPlace()+"          "
		+t .getNumber()+"          "+t.getPrice()+"Ԫ     *");
		}
	}
}
