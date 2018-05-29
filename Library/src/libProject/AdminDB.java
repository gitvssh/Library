package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDB extends DB {
//2018.05.28 18:10pm.
	List<Admin> adminList;

	Data input() {

		Scanner sc = new Scanner(System.in);
		System.out.println("새로운 관리자를 등록합니다.");
		System.out.println();

		System.out.println("아이디를 입력하세요.");
		String id = sc.nextLine();

		System.out.println("패스워드를 입력하세요.");
		String password = sc.nextLine();
		while (true) { // 패스워드 확인하는 구문
			System.out.println("패스워드를 다시 한번 입력하세요.");
			String password2 = sc.nextLine();
			if (!(password.equals(password2))) {
				System.out.println("패스워드가 일치하지 않습니다.");
				continue;
			} else {
				break;
			}
		}
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("생년월일을 입력하세요. ex)92년10월2일생일시 -> '921002'");
		int ssn = sc.nextInt();
		sc.nextLine();
		System.out.println("전화번호를 입력하시오. 하이픈(-)은 생략하여 입력하세요. ");
		int tel = sc.nextInt();
		sc.nextLine();
		Admin a = new Admin(id, password, name, ssn, tel);

		return a;
	}

	void insert(Admin admin) {
		adminList.add((Admin) admin);
	}

	List searchid(String id) {//검색 : id 
		List<Admin> searchId = new ArrayList<Admin>();
		for(Admin a:adminList) {
			if(a.getName().contains(id)) searchId.add(a);
		}
		return searchId;
	}
	List searchname(String name) {//검색 : 이름
		List<Admin> searchName = new ArrayList<Admin>();
		for(Admin a:adminList) {
			if(a.getName().contains(name)) searchName.add(a);
		}
		return searchName;
	}

	@Override
	void insert() {
		
	}

	@Override
	void delete(Data data) {
		// TODO Auto-generated method stub

	}

	@Override
	void update(Data data) {
		// TODO Auto-generated method stub

	}

	@Override
	List searchAll() {
		for (int i = 0; i < adminList.size(); i++) {
			System.out.println((Admin) adminList.get(i));
		}
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List search(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}