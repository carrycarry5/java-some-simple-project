package Train;

public class GetTrainnum {
	private int Tnum;                               //���ó���ţ����������һ�������
	
	public int getTnum() {
		return Tnum;
	}
	public void setTnum(){                                    //����һ�������
		Tnum = 1+(int)(Math.random() * 9);
	}
}
