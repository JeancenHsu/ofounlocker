package cn.xujinchun.ofounlocker.pojo;

public class Tofo {
	private int id;
	private String bicycleid;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBicycleid() {
		return bicycleid;
	}
	public void setBicycleid(String bicycleid) {
		this.bicycleid = bicycleid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Tofo(){
		
	}
	public Tofo(String bicycleid, String password) {
		this.bicycleid = bicycleid;
		this.password = password;
	}
	
	
}
