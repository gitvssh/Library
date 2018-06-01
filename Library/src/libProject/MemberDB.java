package libProject;

import java.time.LocalDate;
import java.util.*;

import Comments.Comment;
import Comparators.*;

public class MemberDB extends DB {
	List<Member> memberList;
	// ...
	Osystem osys = new Osystem();

	Scanner scanner = new Scanner(System.in);
	String id = "";
	String password = "";
	String name = "";
	String ssn = "";
	String tel = "";
	boolean status;
	boolean blackstatus;

	// ....
	public MemberDB() {
		memberList = new ArrayList<>();

		// 더미 데이터(연체자 체크용)
		ArrayList<Book> dumRentList = new ArrayList<>();
		Book dumBook = new Book("소피의 세계", "요슈타인가아더 ", 1, "현암사");
		LocalDate date = LocalDate.now();
		LocalDate returnDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth() - 7);
		dumBook.setReturnDate(returnDate);
		dumRentList.add(dumBook);
		Member dumMember = new Member("blacKim", "1234", "김블랙", "991120", "01042326814");	// 더미 데이터 0번
		dumMember.setRentList(dumRentList);
		this.memberList.add(dumMember);

		this.memberList.add(new Member("java111", "1234", "박자바", "991120", "01042326814"));	//더미 데이터 1번
		this.memberList.add(new Member("java222", "1234", "김자바", "900110", "01063127891"));	
		this.memberList.add(new Member("java333", "1234", "최자바", "880106", "01023268214"));
		this.memberList.add(new Member("java444", "1234", "이자바", "000813", "01032123819"));	//더미 데이터5번
		memberList.get(0).setStatus(true);// 더미 데이터에게 연체중 상태 부여
		memberList.get(2).setStatus(true);
		memberList.get(3).setStatus(true);
	}

	void checkStatus() {	// 계정의 정상 연체 계정정지 상태를 체크하는 메서드 - 회원메뉴, 관리자메뉴에서 사용

		for (int i = 0; i < memberList.size(); i++) {

			if (memberList.get(i).status == false) {	// boolean status의 값이 false면 "정상"상태
				memberList.get(i).idstatus = "정상";
			} else if (memberList.get(i).status == true) {	// boolean status의 값이 true면서 boolean blackstatus의 값이 false이면 "연체중"상태

				if (memberList.get(i).blackstatus == false) {

					memberList.get(i).idstatus = "연체중";
				} else {									// boolean status의 값이 true면서 boolean blackstatus의 값이 true이면 "계정 정지"상태
					memberList.get(i).idstatus = "계정정지";
				}
			}
		}
	}

	@Override
	List search(String search) {	// 회원검색 메서드 - 관리자메뉴에서 사용
		System.out.println("┌────────────────────────────────────────────────────────────┐");	// 검색메뉴 인터페이스
		System.out.printf("   %-8s | %-12s | %-13s | %-21s | %-10s  %n", "회원ID", "이름", "생년월일", "전화번호", "상태");
		System.out.println("└────────────────────────────────────────────────────────────┘");
		System.out.println("┌────────────────────────────────────────────────────────────┐");
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().contains(search) || memberList.get(i).getName().contains(search)) {	// 출력된 회원의 인터페이스
				System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4s  %n", memberList.get(i).id,
						memberList.get(i).name, memberList.get(i).ssn, memberList.get(i).tel,
						memberList.get(i).idstatus);
				System.out.println("└────────────────────────────────────────────────────────────┘");
			}
		}
		return null;
	}

	List adminsearch(String id) {	// 관리자 검색 및 수정 메서드 - 관리자메뉴에서 사용

		int count = 0;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				System.out.printf("[%s]님의 정보를 불러왔습니다. 수정하실 항목을 선택해주세요. %n", memberList.get(i).getId());
				osys.member_modify();									// 수정메뉴 인터페이스
				update(memberList.get(i));
				count++;
				if (!(count == 0)) {
					System.out.printf("[%s]님의 정보수정이 완료되었습니다.%n", memberList.get(i).getId());
				} else {
					break;
				}
			} else {	// 입력한 아이디가 없을 경우
				System.out.println("입력하신 아이디 정보가 없습니다.");
				break;
			}
		}

		return null;
	}

	void input() { // 회원가입 메서드 - 회원메뉴에서 사용
		System.out.println("아이디를 입력해주세요. 0:이전메뉴로 이동");
		String id = scanner.nextLine();	// 아이디 입력 구간
		if (id.equals("0"))				// 아이디 입력 구간에 0을 입력할경우 이전메뉴로 나감
			return;
		while (true) {					// 비밀번호 확인이 틀렸을 경우 재입력을 위해서 while(true)
			System.out.println("비밀번호를 입력해주세요.");
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

		Member m = new Member(id, password, name, ssn, tel);	// 입력받은 값을 객체에 저장
		memberList.add(m);
		System.out.println("회원가입이 성공했습니다.");
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	void update(Data data) { // 회원 정보 수정 메서드 - 회원메뉴에서 사용
		Member m = (Member) data;
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1:
			System.out.println("수정하실 아이디를 입력해주세요.");		
			System.out.println("현재 아이디 : " + m.getId());		// 수정하기 전 아이디 출력
			m.setId(scanner.nextLine());						// 아이디 입력구간
			System.out.println("수정되셨습니다. 수정된 아이디 : " + "[" + m.getId() + "]");		// 수정된 아이디 출력
			break;
		case 2:
			while (true) {
				System.out.println("수정하실 비밀번호를 입력해주세요.");		// 비밀번호는 보안상의 문제로 출력하지 않음
				String passright1 = scanner.nextLine();		// 수정할 비밀번호 입력구간
				System.out.println("비밀번호를 한번 더 입력해주세요");
				String passright2 = scanner.nextLine();		// 수정할 비밀번호를 확인하기 위한 입력구간
				if (passright1.equals(passright2)) {		// 수정할 비밀번호와 비밀번호 확인이 맞을경우
					m.setPassword(passright2);
					System.out.println("비밀번호를 수정하였습니다.");
					break;
				} else {									// 다를 경우
					System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
					continue;
				}
			}
			break;
		case 3:
			System.out.println("수정하실 이름을 입력해주세요.");
			System.out.println("현재 이름 : " + m.getName());	// 수정하기 전 이름 출력
			m.setName(scanner.nextLine());					// 수정할 이름 입력
			System.out.println("수정되셨습니다. 수정된 이름 : " + "[" + m.getName() + "]");	// 수정 후 이름 출력
			break;

		case 4:
			System.out.println("수정하실 생년월일를 입력해주세요.");		
			System.out.println("현재 생년월일 : " + m.getSsn());	// 수정하기 전 생년월일 출력
			m.setSsn(scanner.nextLine());						// 수정할 생년월일 입력
			System.out.println("수정되셨습니다. 수정된 생년월일 : " + "[" + m.getSsn() + "]");	// 수정 후 생년월일 출력
			break;
		case 5:
			System.out.println("수정하실 전화번호를 입력해주세요.");		
			System.out.println("현재 전화번호 : " + m.getTel());	// 수정하기 전 전화번호 출력
			m.setTel(scanner.nextLine());						// 수정할 전화번호 입력
			System.out.println("수정되셨습니다. 수정된 전화번호 : " + "[" + m.getTel() + "]");	// 수정 후 전화번호 출력
			break;
		case 0:
			System.out.println("이전화면으로 이동합니다.");
			break;
		}
		return;
	}

	void printBlack() {							// 블랙리스트 회원 출력용 메서드 - 관리자메뉴에서 사용
		int count = 0;
		System.out.println("┌────────────────────────────────────────────────────────────┐");
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).status == true) {
				count++;
				System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4s  %n", memberList.get(i).id,
						memberList.get(i).name, memberList.get(i).ssn, memberList.get(i).tel,
						memberList.get(i).idstatus);
				System.out.println("└────────────────────────────────────────────────────────────┘");
			}
		}
		System.out.println("총 " + count + "명의 회원이 블랙리스트에 있습니다.");		// status가 true인 사람이 있을때마다 count + 1

	}

	void alignBlack() {											// 블랙리스트인 회원을 정렬하고 "계정정지", "계정복구" 부여

		Osystem osys = new Osystem();
		System.out.println("1.정렬 2.계정정지 3.계정복구 0.이전화면");
		System.out.println("메뉴를 선택해주세요.");
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1:
			while (true) {
				System.out.println("1.아이디 2.이름 3.생년월일 4.전화번호 5.상태 0.이전화면");
				System.out.println("정렬을 원하는 항목을 선택해주세요.");
				int input = scanner.nextInt();
				scanner.nextLine();
				switch (input) {
				case 1: // 아이디
					MemberIdComparator cId = new MemberIdComparator();
					Collections.sort(memberList, cId);
					osys.showBlackList(memberList);
					continue;
				case 2: // 이름
					MemberNameComparator cName = new MemberNameComparator();
					Collections.sort(memberList, cName);
					osys.showBlackList(memberList);
					continue;
				case 3: // 생년월일
					MemberSsnComparator cSsn = new MemberSsnComparator();
					Collections.sort(memberList, cSsn);
					osys.showBlackList(memberList);
					continue;
				case 4: // 전화번호
					MemberTelComparator cTel = new MemberTelComparator();
					Collections.sort(memberList, cTel);
					osys.showBlackList(memberList);
					continue;
				case 5: // 상태
					MemberIdStatusComparator cIdStatus = new MemberIdStatusComparator();
					Collections.sort(memberList, cIdStatus);
					osys.showBlackList(memberList);
					continue;
				case 0:
					MemberIdComparator c = new MemberIdComparator();
					Collections.sort(memberList, c);
					return;
				default:
					System.out.println("잘못된 입력입니다.");
					continue;
				}
			}
		case 2:
			System.out.println("정지하려는 계정의 아이디를 입력해주세요. 0.이전화면");

			id = scanner.nextLine();
			if (id.equals("0")) {
				System.out.println("이전화면으로 이동합니다");
				break;
			} else {

				for (int i = 0; i < memberList.size(); i++) {
					if (memberList.get(i).id.equals(id)) {
						memberList.get(i).setBlackstatus(true);
						if (memberList.get(i).status == false) {
							memberList.get(i).idstatus = "정상";
						} else if (memberList.get(i).status == true) {

							if (memberList.get(i).blackstatus == false) {

								memberList.get(i).idstatus = "연체중";
							} else {
								memberList.get(i).idstatus = "계정정지";
							}
						}
						System.out.println("┌────────────────────────────────────────────────────────────┐");
						System.out
								.println(memberList.get(i).id + "님이 " + memberList.get(i).getIdstatus() + "상태가 되었습니다.");
						System.out.println("└────────────────────────────────────────────────────────────┘");
					}
				}

				break;
			}

		case 3:
			System.out.println("복구하려는 계정의 아이디를 입력해주세요. 0.이전화면");
			id = scanner.nextLine();
			if (id.equals("0")) {
				System.out.println("이전화면으로 이동합니다");
				break;

			}
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).id.equals(id)) {
					memberList.get(i).setBlackstatus(false);
					if (memberList.get(i).status == false) {
						memberList.get(i).idstatus = "정상";
					} else if (memberList.get(i).status == true) {

						if (memberList.get(i).blackstatus == false) {

							memberList.get(i).idstatus = "연체중";
						} else {
							memberList.get(i).idstatus = "계정정지";
						}
					}
					System.out.println("┌────────────────────────────────────────────────────────────┐");
					System.out.println(memberList.get(i).id + "님이 " + memberList.get(i).getIdstatus() + "상태가 되었습니다.");
					System.out.println("└────────────────────────────────────────────────────────────┘");
				}

			}
			break;
		case 0:
			System.out.println("이전화면으로 이동합니다.");
			break;
		}
	}

	// ..
	Member loginMem(String id, String password) { // 로그인 메서드

		Member loginMem = null;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				if (memberList.get(i).getPassword().equals(password)) {
					System.out.println("┌────────────────────────────────────────────────────────────┐");
					System.out.println(memberList.get(i).getId() + "님이 로그인 하셨습니다.");
					System.out.println("└────────────────────────────────────────────────────────────┘");
					System.out.println("회원 메뉴로 이동합니다.");
					loginMem = memberList.get(i);

				} else {
					System.out.println("비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
			}

		}
		return loginMem;
	}

	void printMemInform(Data data) { // 회원 정보 출력
		Member m = (Member) data;
		System.out.println("아이디 : " + m.getId());
		System.out.println("이름 : " + m.getName());
		System.out.println("생년월일 : " + m.getSsn());
		System.out.println("전화번호 : " + m.getTel());
		System.out.println("계정상태 : " + m.getIdstatus());
		System.out.println("0.이전메뉴로 이동");
		System.out.print(">>");
		int menu = scanner.nextInt();
		scanner.nextLine();
		if (menu == 0) {
			System.out.println("이전메뉴로 이동합니다");
		}
	}

	void findId() { // 아이디 찾기
		System.out.println("이름을 입력해주세요");
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {

				System.out.println("전화번호를 입력해주세요");
				tel = scanner.nextLine();
				if (memberList.get(i).getTel().equals(tel)) {
					System.out.println("┌────────────────────────────────────────────────────────────┐");
					System.out.println("귀하의 아이디는 :" + memberList.get(i).getId() + "입니다.");
					System.out.println("└────────────────────────────────────────────────────────────┘");
					break;
				} else {
					System.out.println("잘못된 전화번호 입니다.");
					break;
				}
			}
		}
	}

	void findPw() { // 비밀번호 찾기
		System.out.println("이름를 입력해주세요"); // 아이디 입력
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {
				System.out.println("아이디를 입력해주세요"); // 이름입력
				id = scanner.nextLine();
				if (memberList.get(i).getId().equals(id)) {
					System.out.println("전화번호를 입력해주세요"); // 전화번호 입력
					tel = scanner.nextLine();
					if (memberList.get(i).getTel().equals(tel)) {
						System.out.println("┌────────────────────────────────────────────────────────────┐");
						System.out.println("해당 번호로 비밀번호를 전송하였습니다.");
						System.out.println("└────────────────────────────────────────────────────────────┘");
					} else {
						System.out.println("잘못된 전화번호 입니다.");
						break;
					}
				} else {
					System.out.println("잘못된 이름 입니다.");
					break;
				}
			}
		}
	}

	@Override
	List searchAll() {

		System.out.println("┌────────────────────────────────────────────────────────────┐");
		System.out.printf("   %-8s | %-12s | %-13s | %-21s | %-10s  %n", "회원ID", "이름", "생년월일", "전화번호", "상태");
		System.out.println("└────────────────────────────────────────────────────────────┘");

		System.out.println("┌────────────────────────────────────────────────────────────┐");
		for (int i = 0; i < memberList.size(); i++) {
			System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4s  %n", memberList.get(i).getId(),
					memberList.get(i).getName(), memberList.get(i).getSsn(), memberList.get(i).getTel(),
					memberList.get(i).getIdstatus());
			System.out.println("└────────────────────────────────────────────────────────────┘");
		}
		System.out.printf("  회원은 총 %s 명 입니다.%n", memberList.size());
		return null;
	}

	@Override
	void align() {
		System.out.println("");
		return;
	}

	public int showPages(int page) {// 전체 회원 목록 페이지별로 보여주기(매개변수는 검색하고자 하는 페이지)
		int totalPages = (int) Math.ceil(memberList.size() / 10.);

		if (page < 1 || page > totalPages) {
			System.out.println("페이지 없음!");
			if (page < 1)
				return 0;
			else
				return totalPages + 1;
		}

		int limit = (page != totalPages) ? page * 10 : memberList.size();
		for (int i = (page - 1) * 10; i < limit; i++) {
			System.out.println(memberList.get(i));
		}
		System.out.println("현재 " + page + "페이지/" + totalPages + "페이지");
		return page;
	}

	public int showPages(int page, List<Member> searchList) {// 검색한 회원 목록 페이지별로 보여주기(매개 리스트는 검색 리스트)
		int totalPages = (int) Math.ceil(searchList.size() / 10.);

		if (page < 1 || page > totalPages) {
			System.out.println("페이지 없음!");
			if (page < 1)
				return 0;
			else
				return totalPages + 1;
		}

		int limit = (page != totalPages) ? page * 10 : searchList.size();
		for (int i = (page - 1) * 10; i < limit; i++) {
			System.out.println(searchList.get(i));
		}
		System.out.println("현재 " + page + "페이지/" + totalPages + "페이지");
		return page;
	}
}
