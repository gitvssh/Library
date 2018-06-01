package libProject;

import java.time.LocalDate;
import java.util.*;

import Comments.Comment;
import Comments.CommentDB;
import Comparators.*;

public class MemberDB extends DB {
	List<Member> memberList;

	Osystem osys = new Osystem();
	Scanner scanner = new Scanner(System.in);

	String id = "";
	String password = "";
	String name = "";
	String ssn = "";
	String tel = "";
	boolean status;
	boolean blackstatus;

public MemberDB() {
	memberList = new ArrayList<>();
	//dummy member
  this.memberList.add(new Member("java111", "1234", "박자바", "991120", "01042326814", false));
	this.memberList.add(new Member("java222", "1234", "김자바", "900110", "01063127891", true));
	this.memberList.add(new Member("java333", "1234", "최자바", "880106", "01023268214", true));
	this.memberList.add(new Member("java444", "1234", "이자바", "000813", "01032123819", false));
  //dummy blacklist
	ArrayList<Book> dumRentList = new ArrayList<>();
	Book dumBook = new Book("소피의 세계","요슈타인가아더 ",1,"현암사");
	LocalDate returnDate = LocalDate.of(2018,5,18);	//기간이 지난 반납일
	dumBook.setReturnDate(returnDate); //기간이 지난 반납일을 책 객체에 삽입
	dumRentList.add(dumBook);	//더미 대출 리스트에 반납일이 지난 책 삽입
	Member dumMember = new Member("blacKim", "1234", "김블랙", "991120", "01042326814", false);
	dumMember.setRentList(dumRentList);
	this.memberList.add(dumMember);
	
	for(int i=0;i<memberList.size();i++) {
		
		if(memberList.get(i).isStatus()==false) {
			memberList.get(i).setIdstatus("정상");
		}else if(memberList.get(i).isStatus()==true){
			if(memberList.get(i).isBlackstatus()==false) {
				memberList.get(i).setIdstatus("연체중");
			}else {
			memberList.get(i).setIdstatus("계정정지");
			}
		}
	}
}//end generator


	@Override
	List search(String search) {
		System.out.println("┌────────────────────────────────────────────────────────────┐");
		System.out.printf("   %-8s | %-12s | %-13s | %-21s | %-10s  %n", "회원ID", "이름", "생년월일", "전화번호", "상태");
		System.out.println("└────────────────────────────────────────────────────────────┘");
		System.out.println("┌────────────────────────────────────────────────────────────┐");
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().contains(search) || memberList.get(i).getName().contains(search)) {
				System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4b  %n", memberList.get(i).id,
						memberList.get(i).name, memberList.get(i).ssn, memberList.get(i).tel,
						memberList.get(i).idstatus);
			}
		}
		System.out.println("└────────────────────────────────────────────────────────────┘");
		return null;
	}

	List adminsearch(String id) {

		int count = 0;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				System.out.printf("[%s]님의 정보를 불러왔습니다. 수정하실 항목을 선택해주세요. %n", memberList.get(i).getId());
				osys.member_modify();
				update(memberList.get(i));
				count++;
				if (!(count == 0)) {
					System.out.printf("[%s]님의 정보수정이 완료되었습니다.%n", memberList.get(i).getId());
				} else {
					break;
				}
			} else {
				System.out.println("입력하신 아이디 정보가 없습니다.");
				break;
			}
		}

		return null;
	}

	@Override
	List searchAll() {
		System.out.println("┌────────────────────────────────────────────────────────────┐");
		System.out.printf("   %-8s | %-12s | %-13s | %-21s | %-10s  %n", "회원ID", "이름", "생년월일", "전화번호", "상태");
		System.out.println("└────────────────────────────────────────────────────────────┘");
		System.out.println("┌────────────────────────────────────────────────────────────┐");

		for (int i = 0; i < memberList.size(); i++) {
			System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4b  %n", memberList.get(i).id, memberList.get(i).name,
					memberList.get(i).ssn, memberList.get(i).tel, memberList.get(i).idstatus);
			System.out.println("└────────────────────────────────────────────────────────────┘");
		}
		System.out.printf("  회원은 총 %s 명 입니다. (0은 이전 화면)%n", memberList.size());
		return null;
	}

	void input() { // 회원가입 메서드
		System.out.println("아이디를 입력해주세요. 0:이전메뉴로 이동");
		String id = scanner.nextLine();
		if(id.equals("0")) return;
		while (true) {
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

		Member m = new Member(id, password, name, ssn, tel, status);
		memberList.add(m);
		System.out.println("회원가입이 성공했습니다.");
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	void update(Data data) {}
	
	void update(Data data, CommentDB commentDB) { // 회원 정보 수정 메서드
		Member m = (Member) data;
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1:
			System.out.println("수정하실 아이디를 입력해주세요.");
			System.out.println("현재 아이디 : " + m.getId());
			String formerId = m.getId();
			m.setId(scanner.nextLine());
			System.out.println("수정되셨습니다. 수정된 아이디 : " + "[" + m.getId() + "]");
			
			//아이디 수정과 동시에 건의사항 DB의 아이디도 모두 수정
			ArrayList<Comment> cList = commentDB.getCommentList();	//건의사항 리스트를 받는다
			if(cList==null||cList.size()==0) System.out.println("아이디가 수정될 건의사항이 없습니다.");
			else {
				int cnt=0;	//아이디가 수정될 건의사항의 개수
				for(int i=0; i<cList.size(); i++) {
					if(cList.get(i).getId().equals(formerId)) {	//이전 아이디와 동일한 아이디의 건의사항이 있으면
						cList.get(i).setId(m.getId());		//수정된 아이디로 수정. 
						cnt++;	//수정된 건의사항 개수+1
					}
				}
				commentDB.setCommentList(cList);
				System.out.println("총 "+cnt+"개의 건의사항이 새로운 아이디로 수정됐습니다.");
			}
			
			break;
		case 2:
			while (true) {
				System.out.println("수정하실 비밀번호를 입력해주세요.");
				String passright1 = scanner.nextLine();
				System.out.println("비밀번호를 한번 더 입력해주세요");
				String passright2 = scanner.nextLine();
				if (passright1.equals(passright2)) {
					m.setPassword(passright2);
					System.out.println("비밀번호를 수정하였습니다.");
					break;
				} else {
					System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
					continue;
				}
			}
			break;
		case 3:
			System.out.println("수정하실 이름을 입력해주세요.");
			System.out.println("현재 이름 : " + m.getName());
			m.setName(scanner.nextLine());
			System.out.println("수정되셨습니다. 수정된 이름 : " + "[" + m.getName() + "]");
			break;

		case 4:
			System.out.println("수정하실 생년월일를 입력해주세요.");
			System.out.println("현재 생년월일 : " + m.getSsn());
			m.setSsn(scanner.nextLine());
			System.out.println("수정되셨습니다. 수정된 생년월일 : " + "[" + m.getSsn() + "]");
			break;
		case 5:
			System.out.println("수정하실 전화번호를 입력해주세요.");
			System.out.println("현재 전화번호 : " + m.getTel());
			m.setTel(scanner.nextLine());
			System.out.println("수정되셨습니다. 수정된 전화번호 : " + "[" + m.getTel() + "]");
			break;
		case 0:
			System.out.println("이전화면으로 이동합니다.");
			break;
		}
	}

	void blackMem() {
		int count = 0;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).status == true) {
				count++;
				System.out.println(memberList.get(i).id + "/" + memberList.get(i).name + "/" + memberList.get(i).ssn
						+ "/" + memberList.get(i).tel + "/" + memberList.get(i).idstatus);
			}
		}
		System.out.println("총 " + count + "명의 회원이 블랙리스트에 있습니다.");

	}

	void blackList() {

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
					osys.showMemberList(memberList);
					continue;
				case 2: // 이름
					MemberNameComparator cName = new MemberNameComparator();
					Collections.sort(memberList, cName);
					osys.showMemberList(memberList);
					continue;
				case 3: // 생년월일
					MemberSsnComparator cSsn = new MemberSsnComparator();
					Collections.sort(memberList, cSsn);
					osys.showMemberList(memberList);
					continue;
				case 4: // 전화번호
					MemberTelComparator cTel = new MemberTelComparator();
					Collections.sort(memberList, cTel);
					osys.showMemberList(memberList);
					continue;
				case 5: // 상태
					MemberIdStatusComparator cIdStatus = new MemberIdStatusComparator();
					Collections.sort(memberList, cIdStatus);
					osys.showMemberList(memberList);
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
						memberList.get(i).setIdstatus("계정정지");

						System.out
								.println(memberList.get(i).id + "님이 " + memberList.get(i).getIdstatus() + "상태가 되었습니다.");
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
					memberList.get(i).setIdstatus("연체중");
					System.out.println(memberList.get(i).id + "님이 " + memberList.get(i).getIdstatus() + "상태가 되었습니다.");
				}

			}
			break;
		case 0:
			System.out.println("이전화면으로 이동합니다.");
			break;
		}
	}

	// ..
	Member Login(String id, String password) { // 로그인 메서드
		Member loginMem = null;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				if (memberList.get(i).getPassword().equals(password)) {
					System.out.println(memberList.get(i).getId() + "님이 로그인 하셨습니다.");
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

	void MemInform(Data data) { // 회원 정보 출력
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

	void FindId() { // 아이디 찾기
		System.out.println("이름을 입력해주세요");
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {
				System.out.println("전화번호를 입력해주세요");
				tel = scanner.nextLine();
				if (memberList.get(i).getTel().equals(tel)) {
					System.out.println("귀하의 아이디는 :" + memberList.get(i).getId() + "입니다.");
					return;
				} else {
					System.out.println("잘못된 전화번호 입니다.");
					return;
				}
			}
		}
		System.out.println("존재하지 않는 이름입니다!");
	}

	void FindPw() { // 비밀번호 찾기
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
						System.out.println("해당 번호로 비밀번호를 전송하였습니다.");
						System.out.println("[비밀번호:"+memberList.get(i).getPassword()+"]");
						return;
					} else {
						System.out.println("잘못된 전화번호 입니다.");
						break;
					}
				} else {
					System.out.println("잘못된 아이디입니다!");
					return;
				}
			} 
		}
		System.out.println("존재하지 않는 이름입니다!");
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
