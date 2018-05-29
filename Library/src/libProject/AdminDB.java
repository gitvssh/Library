package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDB extends DB {
	// 2018.05.28 18:10pm.
	List<Admin> adminList;
	
	
	AdminDB(){
		adminList = new ArrayList<>();
		Admin a = new Admin("admin1", "1234", "관리자", "921002", "01012341234");
		adminList.add(a);
	}
	
	void input() {

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
		String ssn = sc.nextLine();
		System.out.println("전화번호를 입력하시오. 하이픈(-)은 생략하여 입력하세요. ");
		String tel = sc.nextLine();
		Admin a = new Admin(id, password, name, ssn, tel);

		adminList.add(a);
	}

	Admin login(String id, String password) {
		// adminList.get(int i).g

		Admin loginAdm = null;

		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getId().equals(id) && adminList.get(i).getPassword().equals(password)) {
				System.out.printf("[%s] 계정으로 로그인 합니다.%n[%s]님 환영합니다.",adminList.get(i).getId(),adminList.get(i).getName());
				loginAdm = adminList.get(i);
				break;
			} 
			
		}
		return loginAdm;
	}

	@Override
	List search(String id) {
		List<Admin> searchId = new ArrayList<Admin>();
		for (Admin a : adminList) {
			if (a.getName().contains(id))
				searchId.add(a);
		}
		return searchId;
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

}