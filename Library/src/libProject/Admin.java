package libProject;

public class Admin implements Data {
//1
	int test;//테스트용
	private String id;
	private String password;
	private String name;
	private int ssn;
	private int tel;

	Admin() {
	}

	Admin(String id, String password, String name, int ssn, int tel) {

		this.id = id;
		this.password = password;
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;

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

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	//
}
