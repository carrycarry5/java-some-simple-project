package util;

public class SelectFunc {
	public static void  select() throws Exception{
		System.out.println("[1]����"+"\t" +"[2]�˻�" +"\t"+"[3]ͳ��"+"\t"+
				"[4]����"+"\t" +"[5]��ѯ�鼮"+"\t"+"[6]��ѯ��־");
		System.out.println("�˳�������quit");
		System.out.println("��ѡ�����:");
		
		String s = ScannString.scannString();           //����
		String exit="";
		while(true){
			switch(s){
			case "1" :
				BuyBook.buyBook();                             //��������
				System.out.println("��ɽ����������Ƿ�Ҫ������������,�����밴1���˳��밴2");
				exit = ScannString.scannString();                 
				break;
			case "2":
				BackBook.backBook();                            //�˻�����
				System.out.println("����˻��������Ƿ�Ҫ������������,�����밴1���˳��밴2");
				exit = ScannString.scannString();   
				break;
			case "3":					
				System.out.println("���ͳ�ƣ������Ƿ�Ҫ������������,�����밴1���˳��밴2");
				exit = ScannString.scannString();   
				break;
			case "4":
				SellBook.sellBook();                              //�������
				System.out.println("������ۣ������Ƿ�Ҫ������������,�����밴1���˳��밴2");
				exit = ScannString.scannString();   
				break;
			case "5":
				SelectBook.selectBook();                //��ѯ�鼮����
				System.out.println("��ɲ�ѯ�������Ƿ�Ҫ������������,�����밴1���˳��밴2");
				exit = ScannString.scannString();   
				break;
			case "6":
				SelectLog.selectLog();                  //��ѯ��־
				System.out.println("��ɲ�ѯ�������Ƿ�Ҫ������������,�����밴1���˳��밴2");
				exit = ScannString.scannString();   
				break;
			case "quit":
				System.out.println("bye~");
				System.out.println("�˳�ϵͳ");
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
					System.out.println("�����������������");
				}
			} else{
				System.out.println("��������������");
				s=ScannString.scannString();
			}
			
		}
	}
}
