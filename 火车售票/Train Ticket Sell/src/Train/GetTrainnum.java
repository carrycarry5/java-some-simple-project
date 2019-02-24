package Train;

public class GetTrainnum {
	private int Tnum;                               //设置车厢号，将随机产生一个车厢号
	
	public int getTnum() {
		return Tnum;
	}
	public void setTnum(){                                    //产生一个车厢号
		Tnum = 1+(int)(Math.random() * 9);
	}
}
