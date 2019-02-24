package bean;

public class Reply {
	//回复信息：包括回复作者昵称、回复时间等。
	private String replyMessage;
	private String replyauthor;
	private String time;
	private String postID;
	
	
	@Override
	public String toString() {
		return "Reply [replyMessage=" + replyMessage + ", replyauthor=" + replyauthor + ", time=" + time + "postID="+postID+"]";
	}
	public Reply(String replyMessage, String replyauthor, String time , String postID) {
		super();
		this.replyMessage = replyMessage;
		this.replyauthor = replyauthor;
		this.time = time;
		this.postID = postID;
	}
	
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getReplyMessage() {
		return replyMessage;
	}
	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}
	public String getReplyauthor() {
		return replyauthor;
	}
	public void setReplyauthor(String replyauthor) {
		this.replyauthor = replyauthor;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
