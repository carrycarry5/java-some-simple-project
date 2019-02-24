package bean;

public class Reply {
	//回复信息：包括回复作者昵称、回复时间等。
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
