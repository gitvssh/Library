package libProject;

import java.util.*;

public class MemberDB extends DB {
	List<Member> memberList;
	// ...

	Scanner scanner = new Scanner(System.in);
	String id = "";
	String password = "";
	String name = "";
	String ssn = "";
	String tel = "";

	public MemberDB() {
		memberList = new ArrayList<>();
	}

	@Override
	List<Member> search(String str) {
		List<Member> searchList = new ArrayList<Member>();
		for (Member m : memberList) {
			if (m.getName().contains(str))
				searchList.add(m);
		}
		return searchList;
	}

	Data input() { // 회원가입 메서드
		System.out.println("아이디를 입력해주세요");
		id = scanner.nextLine();
		while (true) {
			System.out.println("비밀번호를 입력해주세요");
			password = scanner.nextLine();
			System.out.println("비밀번호를 한번 더 입력해주세요");
			String passright = scanner.nextLine();
			if (passright.equals(password)) {
				System.out.println("비밀번호를 확인하였습니다.");
				break;
			} else {
				System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
				continue;
			}
		}
		System.out.println("이름을 입력해주세요.");
		name = scanner.nextLine();
		System.out.println("생년월일을 입력해주세요.");
		ssn = scanner.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		tel = scanner.nextLine();

		Member m = new Member(id, password, name, ssn, tel);
		return m;
	}

	@Override
	void insert() {}
	void insert(Data data) {
		memberList.add((Member) data);
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	@Override
	void update(Data data) { // 회원 정보 수정 메서드
		Member m = (Member) data;
		System.out.println("수정을 원하시는 항목을 입력해주세요");
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1:
			System.out.println("수정하실 아이디를 입력해주세요.");
			System.out.println("아이디 : " + m.getId());
			m.setId(scanner.nextLine());
			System.out.println("수정되셨습니다. 아이디 : " + m.getId());
			break;
		case 2:
			while (true) {
				System.out.println("수정하실 비밀번호를 입력해주세요.");
				m.setPassword(m.getPassword());
				System.out.println("비밀번호를 한번 더 입력해주세요");
				String passright = scanner.nextLine();
				if (passright.equals(m.getPassword())) {
					System.out.println("비밀번호를 확인하였습니다.");
					break;
				} else {
					System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
					continue;
				}
			}
			break;
		case 3:
			System.out.println("수정하실 이름을 입력해주세요.");
			System.out.println("이름 : " + m.getName());
			m.setName(scanner.nextLine());
			System.out.println("수정되셨습니다. 이름 : " + m.getName());
			break;

		case 4:
			System.out.println("수정하실 생년월일를 입력해주세요.");
			System.out.println("생년월일 : " + m.getSsn());
			m.setSsn(scanner.nextLine());
			System.out.println("수정되셨습니다. 생년월일 : " + m.getSsn());
			break;
		case 5:
			System.out.println("수정하실 전화번호를 입력해주세요.");
			System.out.println("전화번호 : " + m.getTel());
			m.setTel(scanner.nextLine());
			System.out.println("수정되셨습니다. 전화번호 : " + m.getTel());
			break;
		case 0:
			System.out.println("이전메뉴로 이동합니다.");
			break;
		}
	}

	void Login(Data data) { // 로그인 메서드
		Member m = (Member) data;
		login: while (true) {

			System.out.println("아이디를 입력하세요. 이전메뉴로 이동(0)");
			String idInput = scanner.nextLine();
			int premenu = Integer.parseInt(idInput);
			if (premenu == 0) {
				break login;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
			}
			for (int i = 0; i < memberList.size(); i++) {
				if (m.getId().equals(idInput)) {
					System.out.println("비밀번호를 입력하세요.");
					String passInput = scanner.nextLine();
					if (m.getPassword().equals(passInput)) {
						System.out.println(m.getName() + "님이 로그인 하셨습니다.");
						System.out.println("회원 메뉴로 이동합니다.");
						break login;
					} else {
						System.out.println("비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
						continue;
					}
				} else {
					System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
					continue login;
				}
			}
		}
	}

	@Override
	List<Member> searchAll() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println((Member) memberList.get(i));
		}
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}
}
