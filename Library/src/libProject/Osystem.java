package libProject;

import java.util.List;

public class Osystem {
	// 히스토리 출력창에 넣을지, 메인에 넣을지, 아이디 포함출력 에러사항
	// 출력이 1줄인 메뉴는 메인화면에서
	// --------------------------------------비회원
	// 시작---------------------------------------------------
	void observer_main() {
		System.out.println("-----------------------------------------------------");
		System.out.println("1.도서검색 2.회원가입 3.로그인 4.관리자로그인 5.아이디/비밀번호 찾기 0.종료");
		System.out.println("-----------------------------------------------------");
		System.out.println("메뉴를 선택하세요>");
	}

	void observer_search() {
		System.out.println("--------------------------------------------------------");
		System.out.println("1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로");
		System.out.println("--------------------------------------------------------");
		System.out.println("메뉴를 선택하세요>");
	}

	void observer_signin() {
		System.out.println("----------------------------------------");
		System.out.println("              회원가입 메뉴입니다.");
		System.out.println("----------------------------------------");
	}

	void observer_findMember() {
		System.out.println("-----------------------------------");
		System.out.println("       찾으시고자 하는 정보를 선택해주세요.");
		System.out.println("-----------------------------------");
		System.out.println("1. 아이디 찾기		2.비밀번호 찾기 0. 이전화면");
	}

	void observer_findId() {
		System.out.println("----------------------------------");
		System.out.println("등록하신 이름과 전화번호를 입력해주세요.");
		System.out.println("----------------------------------");
	}

	void observer_findPass() {
		System.out.println("----------------------------------");
		System.out.println("등록하신 이름과 아이디를 입력해주세요.");
		System.out.println("----------------------------------");
	}

	// --------------------------------------비회원
	// 끝---------------------------------------------------
	void member_main() {
		System.out.println("-------------------------------------------");
		System.out.println("1.도서검색/대출 2.빌린도서 3.도서반납 4.회원정보 ");
		System.out.println("5.건의사항 9.로그아웃 0.종료");
		System.out.println("-------------------------------------------");
		System.out.println("메뉴를 선택하세요.");
	}

	void member_search() {
		System.out.println("--------------------------------------------------------");
		System.out.println("1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로");
		System.out.println("--------------------------------------------------------");
		System.out.println("메뉴를 선택하세요>");
	}

	void member_inform() {
		System.out.println("원하시는 회원 정보 메뉴를 선택해주세요.");
		System.out.println("---------------------------------------");
		System.out.println("1.회원 정보 조회 2.정보 수정 0.이전메뉴로 이동 ");
		System.out.println("---------------------------------------");
	}

	void member_myinform() {
		System.out.println("---------------------------------");
		System.out.println("회원님의 정보입니다.  0.회원메뉴로 이동 ");
		System.out.println("---------------------------------");
	}

	void member_modify() {
		System.out.println("-----------------------------------------------");
		System.out.println("1.아이디 2.비밀번호 3.이름 4.생년월일 5.전화번호 0.회원메뉴로 이동 ");
		System.out.println("-----------------------------------------------");
		System.out.println("수정을 원하시는 항목을 선택해주세요.");
	}

	void member_request() {
		System.out.println("---------------------------------------");
		System.out.println("1.새 건의사항 입력 2.이전 건의사항 보기 0.회원메뉴로 이동 ");
		System.out.println("---------------------------------------");
		System.out.println("메뉴를 선택하세요.");
	}
	// --------------------------------------회원
	// 끝---------------------------------------------------
	void admin_main() {
	    System.out.println("원하시는 기능의 번호를 입력해주세요.");
	    System.out.println("-----------------------------------------------------------");
	    System.out.println("1.도서관리 2. 회원관리 3.건의사항 4.관리자 관리 5.로그아웃 0.시스템 종료");
	    System.out.println("-----------------------------------------------------------");
	    System.out.println("메뉴를 선택하세요>");
	}
	void admin_bookmng() {
		System.out.println("원하시는 기능의 번호를 입력해주세요.");
		System.out.println("--------------------------------------------------");
		System.out.println("1.도서검색 2.도서추가 3.도서수정 4.도서삭제 0.이전 화면으로");
		System.out.println("--------------------------------------------------");
		System.out.println("메뉴를 선택하세요>");
	}
	void admin_search() {
		System.out.println("--------------------------------------------------------");
		System.out.println("1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로");
		System.out.println("--------------------------------------------------------");
		System.out.println("메뉴를 선택하세요>");
	}
	void admin_addbook() {
		System.out.println("------------------------------------------");
		System.out.println("추가하실 도서의 정보를 입력해주세요. (0은 이전화면)");
		System.out.println("------------------------------------------");

	}
	void admin_modifybook() {
		System.out.println("--------------------------------------------");
		System.out.println("수정하실 도서의 인덱스를 입력해주세요. (0은 이전화면)");
		System.out.println("--------------------------------------------");
	}
	void admin_delbook() {
		System.out.println("--------------------------------------------");
		System.out.println("삭제하실 도서의 인덱스를 입력해주세요. (0은 이전화면)");
		System.out.println("--------------------------------------------");
	}
	void admin_membermng() {
		System.out.println("회원관리 메뉴입니다. 원하시는 기능의 번호를 입력해주세요.");
		System.out.println("---------------------------------------");
		System.out.println("1.회원검색 2.전체회원목록 3.블랙리스트 0.이전화면");
		System.out.println("---------------------------------------");

	}
	void admin_findmem() {
		System.out.println("-------------------------------------------");
		System.out.println("찾으시는 회원의 아이디를 입력하세요. (0은 이전화면)");
		System.out.println("-------------------------------------------");

	}
	void admin_admng() {
		System.out.println("관리자 관리 메뉴입니다."); 
		System.out.println("원하시는 기능의 번호를 입력해주세요.");
		System.out.println("----------------------------------------------");
		System.out.println("1.관리자 검색 2.전체 관리자 목록 3.새 관리자 등록 0.이전화면");
		System.out.println("----------------------------------------------");
	}
	void admin_newad() {
		System.out.println("--------------------------------------");
		System.out.println("새로운 관리자를 등록하시겠습니까? (Y/N) >> _");
		System.out.println("--------------------------------------");

	}
	
	void showBookList(List<Book> list) {	//검색한 책 리스트를 출력하는 메서드
		System.out.println("-------------------------------------------------------------");
		System.out.printf("%7s %-20s %8s %8s %5s %5s", "인덱스","제목","저자","출판사","ISBN","주제\n");
		System.out.println("-------------------------------------------------------------");
		for(Book b:list) {//인덱스(7), 제목(20), 저자(8), 출판사(8), ISBN(5), 주제(5)
			System.out.println(b);
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("총"+list.size()+"개의 검색결과가 있습니다.");
	}
	
	//리스트 추가 

	//히스토리 메서드(오버로딩)
	String history(String menu) {
		return menu;
	} //회원이나 관리자 아이디를 메뉴창에 표시할 때도 사용.
	
	
	String history(String menu, String subMenu1) {
		return menu + " >> "+ subMenu1;
	}
	
	String history(String menu, String subMenu1, String subMenu2) {
		return menu + " >> " + subMenu1 + " >> " + subMenu2;
	}
	
	String history(String menu, String subMenu1, String subMenu2, String subMenu3) {
		return menu + " >> " + subMenu1 + " >> " + subMenu2 + " >> " + subMenu3;
	}
}
