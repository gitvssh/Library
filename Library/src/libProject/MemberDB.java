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
		Member b = new Member("java111", "88030490", "박자바", "991120", "01042326814");
		memberList.add(b);
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

	void input() { // 회원가입 메서드
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
		memberList.add(m);
		System.out.println("회원가입이 성공했습니다.");
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	void update(Data data) { // 회원 정보 수정 메서드
		Member m = (Member)data;
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
			return;
		}
		

	Member Login(String id, String password) { // 로그인 메서드
		Member loginMem = null;

			
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).getId().equals(id)) {
					if (memberList.get(i).getPassword().equals(password)) {
						System.out.println(memberList.get(i).getId() + "님이 로그인 하셨습니다.");
						System.out.println("회원 메뉴로 이동합니다.");
						loginMem = memberList.get(i);
						break;
					} else {
						System.out.println("비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
						break;
					}
				} else {
					System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
					continue;
				}
			}
			return loginMem;
		}
	

	void FindId() {
		System.out.println("이름을 입력해주세요");
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {
				System.out.println("생년월일을 입력해주세요");
				ssn = scanner.nextLine();
				if (memberList.get(i).getSsn().equals(ssn)) {
					System.out.println("전화번호를 입력해주세요");
					tel = scanner.nextLine();
					if (memberList.get(i).getTel().equals(tel)) {
						System.out.println("귀하의 아이디는 :" + memberList.get(i).getId() + "입니다.");
					}else {
						System.out.println("잘못된 전화번호 입니다.");
					}
				}else {
					System.out.println("잘못된 생년월일 입니다.");
				}
			}else {
				System.out.println("존재하지 않는 회원입니다.");
		}
		}
	}
void FindPw() {
	System.out.println("아이디를 입력해주세요");
	id = scanner.nextLine();
	for (int i = 0; i < memberList.size(); i++) {
		if (memberList.get(i).getName().equals(name)) {
			System.out.println("이름을 입력해주세요");
			ssn = scanner.nextLine();
			if (memberList.get(i).getSsn().equals(ssn)) {
				System.out.println("전화번호를 입력해주세요");
				tel = scanner.nextLine();
				if (memberList.get(i).getTel().equals(tel)) {
					System.out.println("해당 번호로 비밀번호를 전송하였습니다.");
				}else {
					System.out.println("잘못된 전화번호 입니다.");
				}
			}else {
				System.out.println("잘못된 이름 입니다.");
			}
		}else {
			System.out.println("존재하지 않는 회원입니다.");
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
