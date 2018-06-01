package libProject;

import java.util.ArrayList;

public class Member implements Data {
	String id;
	String password;
	String name;
	String ssn;
	String tel;
	boolean status;
	String idstatus;
	boolean blackstatus;


	ArrayList<Book> rentList; // 빌린 책 리스트

public Member(String id, String password, String name, String ssn, String tel) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
		this.status = status;
		this.blackstatus = blackstatus;
		rentList = new ArrayList<>();
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isBlackstatus() {
		return blackstatus;
	}
	
	public void setBlackstatus(boolean blackstatus) {
		this.blackstatus = blackstatus;
	}
	public String getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(String idstatus) {
		this.idstatus = idstatus;
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

	public ArrayList<Book> getRentList() {
		return rentList;
	}

	public void setRentList(ArrayList<Book> rentList) {
		this.rentList = rentList;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", ssn=" + ssn + ", tel=" + tel
				+ ", status=" + status + "]";
	} // 회원 정보를 문자열로 리턴하게 toString 메서드 오버라이딩.
}
