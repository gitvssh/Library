package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Comments.Comment;

public class AdminDB extends DB {
	// 2018.05.28 18:10pm.
	List<Admin> adminList;

	AdminDB() {
		adminList = new ArrayList<>();
		// dummy admin
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

		System.out.println("성공적으로 관리자가 만들어졌습니다.");
	}

	Admin login(String id, String password) {
		Admin loginAdm = null;

		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getId().equals(id) && adminList.get(i).getPassword().equals(password)) {
				System.out.printf("[%s] 계정으로 로그인 합니다.%n[%s]님 환영합니다.", adminList.get(i).getId(),
						adminList.get(i).getName());
				loginAdm = adminList.get(i);
				break;
			}

		}
		return loginAdm;
	}

	@Override
	List search(String search) {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getId().contains(search) || adminList.get(i).getName().contains(search)) {
				System.out.printf("아이디: %-10s 이름: %-4s  전화번호: %11s %n", adminList.get(i).getId(),
						adminList.get(i).getName(), adminList.get(i).getTel());
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			}
		}

		return null;
	}

	void admin_modify(String id) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getId().equals(id)) {
				System.out.printf("[%s]님의 정보를 불러왔습니다.%n", adminList.get(i).getId());

				while (true) {
					Osystem osys = new Osystem();
					osys.member_modify();
					int menu = sc.nextInt();
					sc.nextLine();

					if (!(0 <= menu && menu < 6)) {
						System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
						continue;
					} else if (menu == 0) {
						System.out.println("이전화면으로 돌아갑니다.");
						break;
					} else {
						switch (menu) {
						case 1:
							System.out.println("수정하실 아이디를 입력해주세요.");
							System.out.println("현재 아이디 : " + adminList.get(i).getId());
							adminList.get(i).setId(sc.nextLine());
							System.out.println("수정되셨습니다. 수정된 아이디 : " + "[" + adminList.get(i).getId() + "]");
							continue;
						case 2:
							while (true) {
								System.out.println("수정하실 비밀번호를 입력해주세요.");
								String passright1 = sc.nextLine();
								System.out.println("비밀번호를 한번 더 입력해주세요");
								String passright2 = sc.nextLine();
								if (passright1.equals(passright2)) {
									adminList.get(i).setPassword(passright2);
									System.out.println("비밀번호를 수정하였습니다.");
									break;
								} else {
									System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
									continue;
								}
							}
							continue;
						case 3:
							System.out.println("수정하실 이름을 입력해주세요.");
							System.out.println("현재 이름 : " + adminList.get(i).getName());
							adminList.get(i).setName(sc.nextLine());
							System.out.println("수정되셨습니다. 수정된 이름 : " + "[" + adminList.get(i).getName() + "]");
							continue;

						case 4:
							System.out.println("수정하실 생년월일를 입력해주세요.");
							System.out.println("현재 생년월일 : " + adminList.get(i).getSsn());
							adminList.get(i).setSsn(sc.nextLine());
							System.out.println("수정되셨습니다. 수정된 생년월일 : " + "[" + adminList.get(i).getSsn() + "]");
							continue;
						case 5:
							System.out.println("수정하실 전화번호를 입력해주세요.");
							System.out.println("현재 전화번호 : " + adminList.get(i).getTel());
							adminList.get(i).setTel(sc.nextLine());
							System.out.println("수정되셨습니다. 수정된 전화번호 : " + "[" + adminList.get(i).getTel() + "]");
							continue;
						}

					}

				} // while end
			} else {
				System.out.println("아이디 입력이 잘못되었습니다.");
				break;
			}

		}

	}// void modify end

	void repassword(String ssn) {

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
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("관리자를 전체 조회합니다.	                                   ");
		for (int i = 0; i < adminList.size(); i++) {
			System.out.printf("아이디: %-10s 이름: %-4s  전화번호: %11s %n", adminList.get(i).getId(),
					adminList.get(i).getName(), adminList.get(i).getTel());
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		return null;
	}

	@Override
	void align() {
		// TODO Auto-generated method stub
		return;
	}

	public void showPages(int page) {// 전체 관리자 목록 페이지별로 보여주기(매개변수는 검색하고자 하는 페이지)
		int totalPages = (int) Math.ceil(adminList.size() / 10.);

		if (page < 1 || page > totalPages) {
			System.out.println("페이지 없음!");

			if (page < 1)
				page = 0;
			else
				page = totalPages + 1;

			return;
		}

		for (int i = (page - 1) * 10; i < page * 10; i++) {
			System.out.println(adminList.get(i));
		}
		System.out.println("현재 " + page + "페이지/" + totalPages + "페이지");
	}

	public void showPages(int page, List<Admin> searchList) {// 검색한 관리자 목록 페이지별로 보여주기(매개 리스트는 검색 리스트)
		int totalPages = (int) Math.ceil(searchList.size() / 10.);

		if (page < 1 || page > totalPages) {
			System.out.println("페이지 없음!");

			if (page < 1)
				page = 0;
			else
				page = totalPages + 1;

			return;
		}

		for (int i = (page - 1) * 10; i < page * 10; i++) {
			System.out.println(searchList.get(i));
		}
		System.out.println("현재 " + page + "페이지/" + totalPages + "페이지");
	}
}