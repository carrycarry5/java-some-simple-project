package bean;

public class Post {
	//贴子信息：包括贴子编号、发贴日期、时间、等级等
	private Integer id;
	private String postTime;
	private String postMessage;
	private String name;              //name作为author的外键
	
	public Post(Integer id, String postTime, String postMessage, String name) {
		super();
		this.id = id;
		this.postTime = postTime;
		this.name = name;
		this.postMessage = postMessage;
	}
	
	public Post(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}



	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", postTime=" + postTime +  ", postMessage=" + postMessage + "]"+"name="+name;
	}
	
	
}
