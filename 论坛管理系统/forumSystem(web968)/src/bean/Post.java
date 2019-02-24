package bean;

public class Post {
	//������Ϣ���������ӱ�š��������ڡ�ʱ�䡢�ȼ���
	private Integer id;
	private String title;
	private String postTime;
	private String postMessage;
	private String name;              //name��Ϊauthor�����
	
	public Post(Integer id,String title, String postTime, String postMessage, String name) {
		super();
		this.title = title;
		this.id = id;
		this.postTime = postTime;
		this.name = name;
		this.postMessage = postMessage;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "Post [id=" + id +"title= "+title+", postTime=" + postTime +  ", postMessage=" + postMessage + "]"+"name="+name;
	}
	
	
}
