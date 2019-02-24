package bean;

public class Song {
	/*
	 * 歌曲信息包括歌曲名、作者、演唱者、发行年月、专辑等。
	 * */
	private String name;
	private String author;
	private String singer;
	private String releaseTime;
	private String albums;
	
	@Override
	public String toString() {
		return "Song [name=" + name + ", author=" + author + ", singer=" + singer + ", releaseTime=" + releaseTime
				+ ", albums=" + albums + "]";
	}
	public Song(String name, String author, String singer, String releaseTime, String albums) {
		super();
		this.name = name;
		this.author = author;
		this.singer = singer;
		this.releaseTime = releaseTime;
		this.albums = albums;
	}
	
	public Song (){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		releaseTime = releaseTime;
	}
	public String getAlbums() {
		return albums;
	}
	public void setAlbums(String albums) {
		this.albums = albums;
	}
	
	
}
