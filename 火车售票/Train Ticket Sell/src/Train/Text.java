package Train;

public class Text {
	
	public static void main(String[] args){                                          //本类功能：主函数
		
		ShowTrain showTrain = new ShowTrain();
		ShowFunc showFunc = new ShowFunc();
		SelectFunc selectFunc = new SelectFunc();
		
		
		System.out.println("**********南昌火车站订票系统**********");
		System.out.println("***************列车信息****************");
		System.out.println("*     日期          目的地          车次          价格     *");
		
		showTrain.show();
		
		System.out.println("**********您可以完成如下操作**********");
		
		showFunc.show();
		
		System.out.println("请输入对应的数字完成操作：");
		
		selectFunc.select();
	}
}
