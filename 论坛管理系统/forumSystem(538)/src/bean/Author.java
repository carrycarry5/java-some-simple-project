package bean;

public class Author {
	//作者信息：包括作者昵称、性别、年龄、职业、爱好等
	private String name;
	private String sex;
	private String age;
	private String job;
	private String like;
	
	public Author(String name, String sex, String age, String job, String like) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.job = job;
		this.like = like;
	}
	public Author(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	@Override
	public String toString() {
		return "author [name=" + name + ", sex=" + sex + ", age=" + age + ", job=" + job + ", like=" + like + "]";
	}
	
	
	
}
