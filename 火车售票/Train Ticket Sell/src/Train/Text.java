package Train;

public class Text {
	
	public static void main(String[] args){                                          //���๦�ܣ�������
		
		ShowTrain showTrain = new ShowTrain();
		ShowFunc showFunc = new ShowFunc();
		SelectFunc selectFunc = new SelectFunc();
		
		
		System.out.println("**********�ϲ���վ��Ʊϵͳ**********");
		System.out.println("***************�г���Ϣ****************");
		System.out.println("*     ����          Ŀ�ĵ�          ����          �۸�     *");
		
		showTrain.show();
		
		System.out.println("**********������������²���**********");
		
		showFunc.show();
		
		System.out.println("�������Ӧ��������ɲ�����");
		
		selectFunc.select();
	}
}
