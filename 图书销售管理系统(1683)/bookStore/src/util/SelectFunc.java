package util;

public class SelectFunc {
	public static void  select() throws Exception{
		System.out.println("[1]进货"+"\t" +"[2]退货" +"\t"+"[3]统计"+"\t"+
				"[4]销售"+"\t" +"[5]查询书籍"+"\t"+"[6]查询日志");
		System.out.println("退出请输入quit");
		System.out.println("请选择操作:");
		
		String s = ScannString.scannString();           //输入
		String exit="";
		while(true){
			switch(s){
			case "1" :
				BuyBook.buyBook();                             //进货操作
				System.out.println("完成进货，请问是否还要进行其他操作,继续请按1，退出请按2");
				exit = ScannString.scannString();                 
				break;
			case "2":
				BackBook.backBook();                            //退货操作
				System.out.println("完成退货，请问是否还要进行其他操作,继续请按1，退出请按2");
				exit = ScannString.scannString();   
				break;
			case "3":					
				System.out.println("完成统计，请问是否还要进行其他操作,继续请按1，退出请按2");
				exit = ScannString.scannString();   
				break;
			case "4":
				SellBook.sellBook();                              //卖书操作
				System.out.println("完成销售，请问是否还要进行其他操作,继续请按1，退出请按2");
				exit = ScannString.scannString();   
				break;
			case "5":
				SelectBook.selectBook();                //查询书籍操作
				System.out.println("完成查询，请问是否还要进行其他操作,继续请按1，退出请按2");
				exit = ScannString.scannString();   
				break;
			case "6":
				SelectLog.selectLog();                  //查询日志
				System.out.println("完成查询，请问是否还要进行其他操作,继续请按1，退出请按2");
				exit = ScannString.scannString();   
				break;
			case "quit":
				System.out.println("bye~");
				System.out.println("退出系统");
				System.exit(0);
				break;
			default:
				break;
			}
			if (s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5") || s.equals("6")) {
				if (exit.equals("1")) {
					select();
				} else if (exit.equals("2")) {
					s="quit";
				} else{
					System.out.println("输入错误，请重新输入");
				}
			} else{
				System.out.println("错误，请重新输入");
				s=ScannString.scannString();
			}
			
		}
	}
}
