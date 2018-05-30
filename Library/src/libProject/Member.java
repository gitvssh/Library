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

	ArrayList<Book> rentList; // ���� å ����Ʈ

	public Member(String id, String password, String name, String ssn, String tel,boolean status) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
		if (this.status == false) { // ������ ���� �⺻�� : false=����
			idstatus = "����";
		} else if (this.status == true) { // ��ü���� ������ ���� status:true blackstatus:false
			if (this.blackstatus = false) { // �������� ������ ���� status:true blackstatus:true
				idstatus = "��ü��";
			} else {
				idstatus = "��������";
			}
		}

		rentList = new ArrayList<>();
	}

	// <<<<<<< HEAD
	public Member() {
		// TODO Auto-generated constructor stub
	}
	// =======

	// >>>>>>> branch 'master' of https://github.com/gitvssh/Library

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
	} // ȸ�� ������ ���ڿ��� �����ϰ� toString �޼��� �������̵�.
}
