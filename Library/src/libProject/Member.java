package libProject;

public class Member implements Data{
	private String id;
	private String password;
	private String name;
	private String ssn;
	private String tel;
	private boolean status;
	
		
	public Member(String id, String password, String name, String ssn, String tel) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
		
	}
	void IdStatus(boolean status) {
		if(status == true) {
			System.out.println("정상");
		}
		else {
			System.out.println("연체중");
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
