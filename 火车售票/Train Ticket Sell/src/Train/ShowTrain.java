package Train;

public class ShowTrain {                                           //本类功能：输出车辆信息
	SetTrain sTrain = new SetTrain();
	
	public void show(){
		Object[] arr=sTrain.add();
		
		for(int i=0;i<arr.length ;i++){
		Train t = (Train) arr[i];                        //向下强转为Train
		System.out.println("*     "+t.getMonth()+"月"+t.getDay()+"日     "+t.getPlace()+"          "
		+t .getNumber()+"          "+t.getPrice()+"元     *");
		}
	}
}
