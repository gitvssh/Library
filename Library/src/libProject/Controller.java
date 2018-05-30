package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		Osystem osys = new Osystem(); // 화면출력 객채생성
		int menu;// 화면 메뉴선택에 활용할 메뉴
		int login = 0;// 로그인 검사
		Scanner scan = new Scanner(System.in);// 메뉴 입력시 사용할 스캐너

		Member loginMem = null; // 로그인한 회원의 정보가 저장되는 변수
		Admin loginAdm = null; // 로그인한 관리자의 정보가 저장되는 변수

		BookDB bookDB = new BookDB(); // 책 DB 객체생성
		MemberDB memberDB = new MemberDB(); // 회원 DB 객체생성
		AdminDB adminDB = new AdminDB(); // 관리자 DB 객체생성

		// -----------------메인시작-----------------------
		main: while (true) {
			switch (login) {
			case 0:// 비회원 0
				observer: while (true) {// ----------------------비회원 while-------------------
					osys.history("비회원");// 히스토리(지금까지 지나온 메뉴 표시)
					osys.observer_main();// 비회원 메인화면
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.도서검색 2.회원가입 3.로그인 4.관리자로그인 5.아이디/비밀번호 찾기
					case 1:// 1.도서검색
						osys.history("비회원", "도서검색");
						osys.observer_search();// 비회원 도서검색 화면
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로
						case 1:// 제목
							osys.history("비회원", "도서검색", "제목");
							System.out.println("검색하실 제목을 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 1));
							break;
						case 2:// 저자
							osys.history("비회원", "도서검색", "저자");
							System.out.println("검색하실 저자를 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 2));
							break;
						case 3:// 출판사
							osys.history("비회원", "도서검색", "출판사");
							System.out.println("검색하실 출판사를 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 3));
							break;
						case 4:// 분야
							osys.history("비회원", "도서검색", "분야");
							System.out.println("검색하실 분야를 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 4));
							break;
						case 5:// 인덱스
							osys.history("비회원", "도서검색", "인덱스");
							System.out.println("검색하실 인덱스를 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 5));
							break;
						case 6:// ISBN
							osys.history("비회원", "도서검색", "ISBN");
							osys.showBookList(bookDB.search(scan.nextLine(), 6));
							System.out.println("검색하실 ISBN을 입력하세요");
							break;
						case 7:// 전체 도서목록
							osys.history("비회원", "도서검색", "전체 도서 목록");
							System.out.println("전체 도서 목록입니다.");
							bookDB.searchAll();
							continue observer;
						case 0:// 이전화면으로
							System.out.println("이전화면으로 돌아갑니다.");
							continue observer;
						}
						break;

					case 2:// 회원가입
						osys.history("비회원", "회원가입");
						osys.observer_signin();// 회원가입 화면
						memberDB.input();// 회원가입 메서드
						break;
					case 3:// 로그인
						osys.history("비회원", "로그인");
						System.out.println("아이디를 입력하세요.");
						String id = scan.nextLine();
						if (id.equals("0")) {
							System.out.println("이전화면으로 이동합니다.");
							break;
						}
						System.out.println("비밀번호를 입력하세요.");
						String password = scan.nextLine();
						loginMem = memberDB.Login(id, password);// 로그인 메서드
						if (loginMem == null) {
							System.out.println("로그인에 실패하였습니다. 아이디 비밀번호를 다시 확인해주세요.");
							break;
						} else {
							login = 1;
							continue main;// 메인으로 보내서 판별
						}
					case 4:// 관리자로그인
						osys.history("비회원", "관리자 로그인");
						System.out.println("아이디를 입력하세요.");
						id = scan.nextLine();
						System.out.println("비밀번호를 입력하세요.");
						password = scan.nextLine();
						loginAdm = adminDB.login(id, password); // 로그인 메서드
						if (loginAdm == null) {
							System.out.println("로그인에 실패하였습니다. 아이디 비밀번호를 다시 확인해주세요.");
							break;
						} else {
							login = 2;
							continue main;
						}

					case 5:// 아이디 비밀번호찾기
						osys.history("비회원", "아이디/비밀번호 찾기");
						osys.observer_findMember();// 정보찾기 화면
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1. 아이디 찾기 2.비밀번호 찾기 0. 이전화면
						case 1:// 아이디 찾기
							osys.history("비회원", "아이디/비밀번호 찾기", "아이디 찾기");
							osys.observer_findId();// 아이디찾기 화면
							memberDB.FindId();// 아이디 찾기 메서드
							break;
						case 2:// 비밀번호 찾기
							osys.history("비회원", "아이디/비밀번호 찾기", "비밀번호 찾기");
							osys.observer_findPass();// 비밀번호찾기 화면
							memberDB.FindPw();// 비밀번호 찾기 메서드 -> 비밀번호를 번호로 보내드렸습니다!
							break;
						case 0:// 이전화면
							System.out.println("이전화면으로 돌아갑니다.");
							continue observer;
						}
						break;
					case 0:// 프로그램 종료
						System.out.println("프로그램을 종료합니다...");
						break main;
					}// end switch
				} // --------------------------비회원 while end-----------------------
			case 1:// 회원 1
				member: while (true) {
					osys.history(loginMem.getId());
					osys.member_main();
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.도서검색대출 2.빌린도서 3.도서반납 4.회원정보 5.건의사항 9.로그아웃 0.종료");
					case 1:// 도서검색대출
						osys.history(loginMem.getId(), "도서대출");
						osys.member_search();// 회원 도서검색화면
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.제목 2.저자 3.출판사 4.분류 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로
						// 아래에 대출기능도 추가
						case 1:// 제목
							osys.history(loginMem.getId(), "도서대출", "제목");
							System.out.println("검색하실 제목을 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 1));// 검색메서드
							bookDB.rentBooks(bookDB, loginMem);// 대출메서드
							break;
						case 2:// 저자
							osys.history(loginMem.getId(), "도서대출", "저자");
							System.out.println("검색하실 저자를 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 2));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 3:// 출판사
							osys.history(loginMem.getId(), "도서대출", "출판사");
							System.out.println("검색하실 출판사를 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 3));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 4:// 분야
							osys.history(loginMem.getId(), "도서대출", "분야");
							System.out.println("검색하실 분야를 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 4));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 5:// 인덱스
							osys.history(loginMem.getId(), "도서대출", "인덱스");
							System.out.println("검색하실 인덱스를 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 5));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 6:// ISBN
							osys.history(loginMem.getId(), "도서대출", "ISBN");
							System.out.println("검색하실 ISBN을 입력하세요");
							osys.showBookList(bookDB.search(scan.nextLine(), 6));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 7:// 전체 도서목록
							osys.history(loginMem.getId(), "도서대출", "전체 도서목록");
							System.out.println("전체 도서목록입니다.");
							bookDB.searchAll();
							continue member;
						case 0:// 이전화면으로
							System.out.println("이전화면으로 돌아갑니다.");
							continue member;
						}// end switch
						break;
					case 2:// 빌린도서
						osys.history(loginMem.getId(), "빌린 도서");
						osys.showBookList(loginMem.getRentList()); // 빌린도서 출력 메서드
						while (true) {
							System.out.println("0.이전 화면");
							if (scan.nextInt() == 0)
								continue member;
							else
								continue; // 빌린 도서 조회 끝나면 회원 메뉴로.
						}
					case 3:// 도서반납
						osys.history(loginMem.getId(), "도서 반납");
						bookDB.returnBooks(loginMem.getRentList()); // 도서반납 메서드
						continue member; // 반납 끝나면 회원 메뉴로.
					case 4:// 회원정보
						osys.history(loginMem.getId(), "회원정보");
						osys.member_inform();
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.회원정보 조회 2.회원정보 수정 0. 이전화면
						case 1:// 회원정보 조회
							osys.history(loginMem.getId(), "회원정보", "회원정보조회");
							osys.member_myinform();// 회원정보 조회 화면
							break;
						// 회원정보 조회 메서드
						case 2:// 회원정보 수정1.아이디 2.비밀번호 3.이름 4.생년월일 5.전화번호 0.회원메뉴로 이동
							osys.history(loginMem.getId(), "회원정보", "회원정보 수정");
							osys.member_modify();// 회원정보 수정 화면
							modify: while (true) {
								memberDB.update(loginMem);
								break;
							} // end switch_modify
							// end while modify;
						case 0:// 이전화면
							System.out.println("이전화면으로 돌아갑니다.");
							continue member;
						}// end switch 회원정보메뉴
					case 5:// 건의사항
						osys.history(loginMem.getId(), "건의사항");
						osys.member_request();
						// 건의사항 메서드
						break;
					case 9:// 로그아웃
						while (true) {
							osys.history(loginMem.getId(), "로그아웃");
							System.out.println("로그아웃을 하시겠습니까? y/n");
							String out = scan.nextLine();
							if (out.equals("y")) {
								System.out.println("로그아웃 되었습니다.");
								login = 0;
								break;
							} else if (out.equals("n")) {
								System.out.println("로그아웃이 취소되었습니다.");
								login = 1;
								break;
							} else {
								System.out.println("잘못입력하셨습니다.");
								continue;
							}
						}
						continue main;// 메인으로 보내서 판별
					case 0:// 종료
						System.out.println("프로그램을 종료합니다...");
						break main;
					}// end switch
					continue main;
				} // -----------------------------회원 while end-----------------------
			case 2:// 관리자 2
				admin: while (true) {
					osys.history(loginAdm.getId());
					osys.admin_main();// 관리자 메인화면
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.도서관리 2. 회원관리 3.건의사항 4.관리자 관리 5.로그아웃 0.시스템 종료
					case 1:// 도서관리
						bookmng: while (true) {// 도서관리메뉴 while
							Book selected = null;// 도서 수정,삭제를 위한 참조변수
							osys.history(loginAdm.getId(), "도서관리");
							osys.admin_bookmng();
							menu = scan.nextInt();
							scan.nextLine();
							switch (menu) {// 1.도서검색 2.도서추가 3.도서수정 4.도서삭제 0.이전 화면으로
							case 1:// 도서검색
								osys.history(loginAdm.getId(), "도서관리", "도서검색");
								osys.admin_search();
								menu = scan.nextInt();
								scan.nextLine();
								switch (menu) {// 1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로
								case 1:// 제목
									osys.history(loginAdm.getId(), "도서관리", "도서검색", "제목");
									System.out.println("검색하실 제목을 입력하세요");
									osys.showBookList(bookDB.search(scan.nextLine(), 1));
									break;
								case 2:// 저자
									osys.history(loginAdm.getId(), "도서관리", "도서검색", "저자");
									System.out.println("검색하실 저자를 입력하세요");
									osys.showBookList(bookDB.search(scan.nextLine(), 2));
									break;
								case 3:// 출판사
									osys.history(loginAdm.getId(), "도서관리", "도서검색", "출판사");
									System.out.println("검색하실 출판사를 입력하세요");
									osys.showBookList(bookDB.search(scan.nextLine(), 3));
									break;
								case 4:// 분야
									osys.history(loginAdm.getId(), "도서관리", "도서검색", "분야");
									System.out.println("검색하실 분야를 입력하세요");
									osys.showBookList(bookDB.search(scan.nextLine(), 4));
									break;
								case 5:// 인덱스
									osys.history(loginAdm.getId(), "도서관리", "도서검색", "인덱스");
									System.out.println("검색하실 인덱스를 입력하세요");
									osys.showBookList(bookDB.search(scan.nextLine(), 5));
									break;
								case 6:// ISBN
									osys.history(loginAdm.getId(), "도서관리", "도서검색", "ISBN");
									osys.showBookList(bookDB.search(scan.nextLine(), 6));
									System.out.println("검색하실 ISBN을 입력하세요");
									break;
								case 7:// 전체 도서목록
									osys.history(loginAdm.getId(), "도서관리", "도서검색", "전체 도서목록");
									System.out.println("전체 도서 목록입니다.");
									bookDB.searchAll();
									continue admin;
								case 0:// 이전화면으로
									System.out.println("이전화면으로 돌아갑니다.");
									continue admin;
								}
								break;
							case 2:// 도서추가
								osys.history(loginAdm.getId(), "도서관리", "도서추가");
								osys.admin_addbook();
								bookDB.input();
								break;
							case 3:// 도서수정
								osys.history(loginAdm.getId(), "도서관리", "도서수정");
								osys.admin_modifybook();
								selected = bookDB.adminsearch(bookDB);
								if (selected == null) {
									break;
								} else {
									bookDB.update(selected);
									break;
								}
							case 4:// 도서삭제
								osys.history(loginAdm.getId(), "도서관리", "도서삭제");
								osys.admin_delbook();
								selected = bookDB.adminsearch(bookDB);
								if (selected == null) {
									break;
								} else {
									bookDB.delete(selected);
									break;
								}
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								break bookmng;
							}
						} // end while_bookmng
					case 2:// 회원관리
						osys.history(loginAdm.getId(), "회원관리");
						osys.admin_membermng();
						menu = scan.nextInt();
						scan.nextLine();
						membermng: while (true) {// 회원관리메뉴 while
							switch (menu) {// 1.회원검색 2.전체회원목록 3.블랙리스트 0.이전화면
							case 1:// 회원검색
								osys.history(loginAdm.getId(), "회원관리", "회원검색");
								osys.admin_findmem();
								break;
							case 2:// 전체회원목록
								osys.history(loginAdm.getId(), "회원관리", "전체 회원목록");
								// 전체회원 출력 메서드
								break;
							case 3:// 블랙리스트
								osys.history(loginAdm.getId(), "회원관리", "블랙리스트");
								// 블랙리스트 출력 메서드
								break;
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								break membermng;
							}// end switch_membermng
						}
					case 3:// 건의사항
							// 건의사항 출력 메서드(db)
						osys.history(loginAdm.getId(), "건의사항");
						System.out.println("1.검색	2.답변	0.이전화면");
						menu = scan.nextInt();
						scan.nextLine();
						request: while (true) {// 회원관리메뉴 while
							switch (menu) {
							case 1:// 검색
								osys.history(loginAdm.getId(), "건의사항", "검색");
								break;
							case 2:// 답변
								osys.history(loginAdm.getId(), "건의사항", "답변");
								break;
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								break request;
							}// end switch
						} // end while_request
					case 4:// 관리자 관리
						osys.history(loginAdm.getId(), "관리자 관리");
						osys.admin_admng();
						menu = scan.nextInt();
						scan.nextLine();
						admng: while (true) {// 관리자관리메뉴 while
							switch (menu) {// 1.관리자 검색 2.전체 관리자 목록 3.새 관리자 등록 0.이전화면
							case 1:// 관리자 검색
								osys.history(loginAdm.getId(), "관리자 관리", "관리자 검색");
								System.out.println("검색할 관리자 아이디 혹은 이름을 입력해주세요.");
								String searchAdminId = scan.nextLine();
								adminDB.search(searchAdminId);// 관리자 검색 메서드
								break admng;
							case 2:// 전체 관리자 목록
								osys.history(loginAdm.getId(), "관리자 관리", "전체 관리자 목록");
								adminDB.searchAll();// 전체 관리자 목록 출력 메서드
								break admng;
							case 3:// 새 관리자 등록
								osys.history(loginAdm.getId(), "관리자 관리", "새 관리자 등록");
								osys.admin_newad();// y or n
								String menu2 = scan.nextLine();
								newadm: while (true) {
									if (menu2.equalsIgnoreCase("y")) {
										adminDB.input();// 관리자 추가 메서드
										break newadm;
									} else {
										System.out.println("관리자 관리화면으로 돌아갑니다.");
										break admng;
									}
								} // end while_newadm
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								break admng;
							}// end switch
						} // end while_request
					case 5:// 로그아웃
						osys.history(loginAdm.getId(), "로그아웃");
						System.out.println("로그아웃합니다.");
						loginAdm = null;
						login = 0;
						continue main;// 메인으로 보내서 판별
					case 0:// 종료
						System.out.println("프로그램을 종료합니다...");
						break main;
					}
					break;
				} // --------------------------------관리자 while end-------------------------
			}// end switch_login
		} // end while_main

	}// end main

}// end class