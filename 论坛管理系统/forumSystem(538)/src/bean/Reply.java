package bean;

public class Reply {
	//�ظ���Ϣ�������ظ������ǳơ��ظ�ʱ��ȡ�
	private String replyMessage;

	public Reply(String replyMessage) {
		super();
		this.replyMessage = replyMessage;
	}
	
	public Reply(){
		
	}

	public String getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	@Override
	public String toString() {
		return "Reply [replyMessage=" + replyMessage + "]";
	}
	
	
}
