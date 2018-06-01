package libProject;

import java.util.List;

public class Osystem {
	// --------------------------------------비회원 시작--------------------------------
	void observer_main() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("     1.도서검색 2.회원가입 3.로그인 4.관리자로그인 5.아이디/비밀번호 찾기 0.종료. ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}

	void observer_search() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("    1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로       ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void observer_align() { // 정렬 메뉴
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                        정렬 기준을 선택하세요");
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("    1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.최다대출도서 0.이전화면으로 ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}

	void observer_signin() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                           회원 가입 메뉴입니다.        ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
	}

	void observer_findMember() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                  1. 아이디 찾기 2.비밀번호 찾기 0. 이전화면");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");	
		System.out.print(">>");

		}

	void observer_findId() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                     등록하신 이름과 전화번호를 입력해주세요.         	 ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}

	void observer_findPass() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                     등록하신 이름과 아이디를 입력해주세요.              ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}

	// --------------------------------------비회원 끝-----------------------------
	void member_main() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("   1.도서검색/대출 2.빌린도서 3.도서반납 4.회원정보 5.건의사항 9.로그아웃 0.종료   	");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void member_search() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("    1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로 ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void member_inform() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("               1.회원 정보 조회 2.정보 수정 0.이전메뉴로 이동	");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void member_myinform() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                  회원님의 정보입니다.  0.회원메뉴로 이동");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void member_modify() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("        1.아이디 2.비밀번호 3.이름 4.생년월일 5.전화번호 0.이전메뉴로 이동  ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void member_request() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("            1.새 건의사항 입력 2.이전 건의사항 보기 0.회원메뉴로 이동 ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}
	// --------------------------------------회원 끝----------------------------------

	void admin_main() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("       1.도서관리 2.회원관리 3.건의사항 4.관리자 관리 5.로그아웃 0.시스템 종료 ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void admin_bookmng() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("            1.도서검색 2.도서추가 3.도서수정 4.도서삭제 0.이전 화면으로");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void admin_search() {
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("                        정렬 기준을 선택해 주십시오.");
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("   1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void admin_addbook() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("             추가하실 도서의 정보를 입력해주세요. (0은 이전화면)");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}

	void admin_modifybook() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("              수정하실 도서의 인덱스를 입력해주세요. (0은 이전화면)");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void admin_delbook() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("               삭제하실 도서의 인덱스를 입력해주세요. (0은 이전화면)");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void admin_membermng() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                1.회원검색 2.전체회원목록 3.블랙리스트 0.이전화면");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}

	void admin_findmem() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("             찾으시는 회원의 아이디 혹은 이름를 입력하세요. (0은 이전화면)");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}

	void admin_findmem2() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("           정보를 수정하려는 회원의 아이디를  입력하세요 (0은 이전화면)");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}

	void admin_admng() {
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("              관리자 관리 메뉴입니다. 원하시는 메뉴를 입력해주세요.");
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("    1.관리자 검색 2.전체 관리자 목록 3.새 관리자 등록  4.관리자 정보수정 0.이전화면 ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
	}

	void admin_newad() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                  새로운 관리자를 등록하시겠습니까? (Y/N) >>");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");

	}
 
	void comment_main() {
		System.out.println("┌──────────────────────────────────────────────────────────────────┐");
		System.out.println("                     1.검색	2.답변	0.이전화면  ");
		System.out.println("└──────────────────────────────────────────────────────────────────┘");
		System.out.print(">>");
				
			}
	//-----------------------------------관리자 끝 ----------------------------------------
	
	void showBookList(List<Book> list) {	//검색한 책 리스트를 출력하는 메서드
		if(list == null || list.size()==0) System.out.println("조회할 도서가 없습니다.");	//매개변수인 리스트가 null이거나 길이가 0일 때
		else {
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			System.out.printf("    %-7s | %-30s | %-8s | %-8s | %-5s | %-5s | %-5s   %n", "인덱스", "제목", "저자", "출판사",
					"ISBN", "주제", "상태");
			System.out.println("└──────────────────────────────────────────────────────────────────┘");
			for (Book b : list) {// 인덱스(7), 제목(30), 저자(8), 출판사(8), ISBN(5), 주제(5)
				System.out.println(b);
			}
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			System.out.printf("                                            총 %2d개의 도서를 관리중입니다.%n", list.size());
			System.out.println("└──────────────────────────────────────────────────────────────────┘");
		}
	}

	void showMemberList(List<Member> list) { // 검색한 회원 리스트 출력 양식
		if (list == null || list.size() == 0)
			System.out.println("조회할 회원이 없습니다.");
		else {
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			System.out.printf("    %-8s | %-12s | %-13s | %-21s | %-10s  %n", "회원ID", "이름", "생년월일", "전화번호", "상태");
			System.out.println("└──────────────────────────────────────────────────────────────────┘");
			for (Member m : list) {
				System.out.println(m);
			}
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			System.out.printf("                                            총 %2d개의 검색결과가 있습니다. %n", list.size());
			System.out.println("└──────────────────────────────────────────────────────────────────┘");
		}

	}

	void showBlackList(List<Member> list) {
		if (list == null || list.size() == 0)
			System.out.println("조회할 회원이 없습니다.");
		else {
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			System.out.printf("  %-8s | %-12s | %-15s | %-25s | %-9s   %n", "회원ID", "이름", "생년월일", "전화번호", "상태");
			System.out.println("└──────────────────────────────────────────────────────────────────┘");
			int count = 0;
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).isStatus() == true) {
					count++;
					System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4s  %n", list.get(i).getId(),
							list.get(i).getName(), list.get(i).getSsn(), list.get(i).getTel(),
							list.get(i).getIdstatus());
					System.out.println("└──────────────────────────────────────────────────────────────────┘");
				}
			}
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			System.out.printf("  총 %2d개의 검색결과가 있습니다.              %n", count);
			System.out.println("└──────────────────────────────────────────────────────────────────┘");
			System.out.print(">>");
		}
	}

	// 리스트 추가

	// 히스토리 메서드(오버로딩)
	void history(String menu) {
		System.out.println("[" + menu + "]");
	} // 회원이나 관리자 아이디를 메뉴창에 표시할 때도 사용.

	void history(String menu, String subMenu1) {
		System.out.println("[" + menu + " >> " + subMenu1 + "]");
	}

	void history(String menu, String subMenu1, String subMenu2) {
		System.out.println("[" + menu + " >> " + subMenu1 + " >> " + subMenu2 + "]");
	}

	void history(String menu, String subMenu1, String subMenu2, String subMenu3) {
		System.out.println("[" + menu + " >> " + subMenu1 + " >> " + subMenu2 + " >> " + subMenu3 + "]");
	}
}