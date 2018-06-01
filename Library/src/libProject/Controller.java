package libProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Comments.*;

public class Controller {

	public static void main(String[] args) {
		BookDB bookDB = new BookDB();
		MemberDB memberDB = new MemberDB();
		AdminDB adminDB = new AdminDB();
		CommentDB commentDB = new CommentDB();

		Osystem osys = new Osystem();
		Scanner scan = new Scanner(System.in);

		Member loginMem = null; // 로그인한 회원 변수
		Admin loginAdm = null; // 로그인한 관리자 변수

		int menu;// 화면 메뉴선택
		int login = 0;// 로그인 검사

		detectBlackList(memberDB.memberList); // 부팅시 반납일자 연체 중인 회원 자동 탐지

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
						bookSearch: while (true) { // 책 검색창을 반복해서 띄움.
							osys.history("비회원", "도서검색");
							osys.observer_search();// 비회원 도서검색 화면
							menu = scan.nextInt();
							scan.nextLine();
							switch (menu) {// 1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로
							case 1:// 제목
								osys.history("비회원", "도서검색", "제목");
								System.out.println("검색하실 제목을 입력하세요");
								osys.showBookList(bookDB.search(scan.nextLine(), 1));
								continue bookSearch;
							case 2:// 저자
								osys.history("비회원", "도서검색", "저자");
								System.out.println("검색하실 저자를 입력하세요");
								osys.showBookList(bookDB.search(scan.nextLine(), 2));
								continue bookSearch;
							case 3:// 출판사
								osys.history("비회원", "도서검색", "출판사");
								System.out.println("검색하실 출판사를 입력하세요");
								osys.showBookList(bookDB.search(scan.nextLine(), 3));
								continue bookSearch;
							case 4:// 분야
								osys.history("비회원", "도서검색", "분야");
								System.out.println("검색하실 분야를 입력하세요");
								System.out.println("분야 리스트");
								System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
								System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
								osys.showBookList(bookDB.search(scan.nextLine(), 4));
								continue bookSearch;
							case 5:// 인덱스
								osys.history("비회원", "도서검색", "인덱스");
								System.out.println("검색하실 인덱스를 입력하세요");
								osys.showBookList(bookDB.search(scan.nextLine(), 5));
								continue bookSearch;
							case 6:// ISBN
								osys.history("비회원", "도서검색", "ISBN");
								osys.showBookList(bookDB.search(scan.nextLine(), 6));
								System.out.println("검색하실 ISBN을 입력하세요");
								continue bookSearch;
							case 7:// 전체 도서목록
								osys.history("비회원", "도서검색", "전체 도서 목록");
								System.out.println("전체 도서 목록입니다.");
								bookDB.searchAll();
								continue bookSearch;
							case 0:// 이전화면으로
								System.out.println("이전화면으로 돌아갑니다.");
								continue observer;
							}
							break;
						}

					case 2:// 회원가입
						osys.history("비회원", "회원가입");
						osys.observer_signin();
						memberDB.input();
						continue observer;
					case 3:// 로그인
						osys.history("비회원", "로그인");
						System.out.println("아이디를 입력하세요. (0은 이전 화면)");
						String id = scan.nextLine();
						if (id.equals("0")) {
							System.out.println("이전화면으로 이동합니다.");
							break;
						}
						System.out.println("비밀번호를 입력하세요.");
						String password = scan.nextLine();

						loginMem = memberDB.Login(id, password);

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
						loginAdm = adminDB.login(id, password);
						if (loginAdm == null) {
							System.out.println("로그인에 실패하였습니다. 아이디 비밀번호를 다시 확인해주세요.");
							break;
						} else {
							login = 2;
							continue main;
						}

					case 5:// 아이디 비밀번호찾기

						findInfo: while (true) { // 아이디/비밀번호 찾기창 반복해서 띄움.
							osys.history("비회원", "아이디/비밀번호 찾기");
							osys.observer_findMember();
							menu = scan.nextInt();
							scan.nextLine();
							switch (menu) {// 1. 아이디 찾기 2.비밀번호 찾기 0. 이전화면
							case 1:// 아이디 찾기
								osys.history("비회원", "아이디/비밀번호 찾기", "아이디 찾기");
								osys.observer_findId();
								memberDB.FindId();
								continue findInfo;
							case 2:// 비밀번호 찾기
								osys.history("비회원", "아이디/비밀번호 찾기", "비밀번호 찾기");
								osys.observer_findPass();
								memberDB.FindPw();
								continue findInfo;
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								continue observer;
							}// end switch
							break;
						} // end findInfo
					case 0:// 프로그램 종료
						System.out.println("프로그램을 종료합니다...");
						break main;
					}// end switch
				} // --------------------------비회원 while end-----------------------
			case 1:// 회원 1
				member: while (true) {
					memberDB.checkStatus();
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
							osys.showBookList(bookDB.search(scan.nextLine(), 1));
							bookDB.rentBooks(bookDB, loginMem);
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
							System.out.println("분야 리스트");
							System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
							System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
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
						continue member;
					case 2:// 빌린도서
						osys.history(loginMem.getId(), "빌린 도서");
						osys.showBookList(loginMem.getRentList());
						while (true) {
							System.out.println("0.이전 화면");
							if (scan.nextInt() == 0)
								continue member;
							else
								continue;
						}
					case 3:// 도서반납
						osys.history(loginMem.getId(), "도서 반납");
						bookDB.returnBooks(loginMem.getRentList());
						continue member;
					case 4:// 회원정보
						osys.history(loginMem.getId(), "회원정보");
						osys.member_inform();
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.회원정보 조회 2.회원정보 수정 0. 이전화면
						case 1:// 회원정보 조회
							osys.history(loginMem.getId(), "회원정보", "회원정보조회");
							osys.member_myinform();
							memberDB.MemInform(loginMem);
							continue member;
						case 2:// 회원정보 수정1.아이디 2.비밀번호 3.이름 4.생년월일 5.전화번호 0.회원메뉴로 이동
							osys.history(loginMem.getId(), "회원정보", "회원정보 수정");
							osys.member_modify();
							memberDB.update(loginMem);
							continue member;
						// end while modify;
						case 0:// 이전화면
							System.out.println("이전화면으로 돌아갑니다.");
							continue member;
						}// end switch 회원정보메뉴
					case 5:// 건의사항
						comment: while (true) {
							osys.history(loginMem.getId(), "건의사항");
							osys.member_request();
							menu = scan.nextInt();
							switch (menu) {
							case 1: // 1.새 건의사항 입력
								osys.history(loginMem.getId(), "건의사항", "1.새 건의사항 입력");
								commentDB.addComment(loginMem);
								continue comment;
							case 2: // 2.이전 건의사항 보기
								osys.history(loginMem.getId(), "건의사항", "2.이전 건의사항 보기");
								// 회원 아이디로 작성된 건의사항을 검색해 리스트로 받기
								ArrayList<Comment> searchList = commentDB.searchComments(loginMem.getId());
								// 검색결과가 있으면 리스트를 매개변수로 이전 건의사항들을 출력
								if (searchList != null) {
									int page = 1;
									commentDB.showPages(page, searchList);
									while (true) {
										System.out.println("1.이전 페이지  2.다음 페이지  0.이전 화면");
										menu = scan.nextInt();
										scan.nextLine();
										if (menu == 0)
											continue comment; // 0을 입력받으면 건의사항 메뉴로.
										if (menu == 1)
											page = commentDB.showPages(--page, searchList);
										else if (menu == 2)
											page = commentDB.showPages(++page, searchList);
										else
											System.out.println("잘못된 입력!");
									}
								} else {
									System.out.println("등록된 건의사항이 없습니다.");
									continue comment;
								}
							case 0: // 0.회원메뉴로 이동
								System.out.println("이전화면으로 돌아갑니다.");
								continue member;
							}
						}
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
				} // -----------------------------회원 while end-----------------------
			case 2:// 관리자 2
				admin: while (true) {
					memberDB.checkStatus();
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
							if (!(0 <= menu && menu < 5)) {
								System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
								continue;
							}
							switch (menu) {// 1.도서검색 2.도서추가 3.도서수정 4.도서삭제 0.이전 화면으로
							case 1:// 도서검색
								osys.history(loginAdm.getId(), "도서관리", "도서검색");
								osys.admin_search();
								menu = scan.nextInt();
								scan.nextLine();
								if (!(0 <= menu && menu < 8)) {
									System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
									continue;
								}
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
									System.out.println("분야 리스트");
									System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
									System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
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
								} else {
									bookDB.update(selected);
								}
								break;
							case 4:// 도서삭제
								osys.history(loginAdm.getId(), "도서관리", "도서삭제");
								osys.admin_delbook();
								selected = bookDB.adminsearch(bookDB);
								if (selected == null) {
								} else {
									bookDB.delete(selected);
								}
								break;
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								break bookmng;
							}
						} // end while_bookmng
					case 2:// 회원관리
						osys.history(loginAdm.getId(), "회원관리");
						membermng: while (true) {// 회원관리메뉴 while
							osys.admin_membermng();
							menu = scan.nextInt();
							scan.nextLine();
							if (!(0 <= menu && menu < 4)) {
								System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
								continue;
							}
							switch (menu) {// 1.회원검색 2.전체회원목록 3.블랙리스트 0.이전화면
							case 1:// 회원검색
								osys.history(loginAdm.getId(), "회원관리", "회원검색");
								osys.admin_findmem();
								String id = scan.nextLine();
								if (id.equals("0"))
									continue admin;
								memberDB.search(id);
								continue membermng;
							case 2:// 전체회원목록
								osys.history(loginAdm.getId(), "회원관리", "전체 회원목록");
								memberDB.searchAll();// 전체회원 출력 메서드
								if (scan.nextLine().equals("0"))
									continue admin;
								continue membermng;
							case 3:// 블랙리스트
								osys.history(loginAdm.getId(), "회원관리", "블랙리스트");
								System.out.println("블랙리스트 회원목록입니다.");
								osys.showBlackList(memberDB.memberList);// 블랙리스트 출력 메서드
								memberDB.alignBlack();
								break;
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								continue admin;
							}// end switch_membermng
						}
					case 3:// 건의사항
						ArrayList<Comment> cList = commentDB.getCommentList();
						if (cList == null || cList.size() == 0) {
							System.out.println("새로 등록된 건의사항이 없습니다.");
						} else {
							HashSet<String> idSet = new HashSet<>();
							for (Comment c : cList) {
								if (c.getReply() == null)
									idSet.add(c.getId());
							}
							System.out.println("미답변 건의사항: " + idSet);
						}
						request: while (true) {// 회원관리메뉴 while
							osys.history(loginAdm.getId(), "건의사항");
							osys.comment_main();
							menu = scan.nextInt();
							scan.nextLine();
							if (!(0 <= menu && menu < 3)) {
								System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
								continue;
							}
							switch (menu) {
							case 1:// 검색
								osys.history(loginAdm.getId(), "건의사항", "검색");
								System.out.println("검색하시고자 하는 건의사항의 아이디를 입력해주세요.(0은 이전 화면)");
								System.out.print("아이디: ");
								String searchId = scan.nextLine();
								if (searchId.equals("0"))
									continue admin;

								ArrayList<Comment> searchList = commentDB.searchComments(searchId);

								if (searchList != null) {
									int page = 1;
									commentDB.showPages(page, searchList);
									while (true) {
										System.out.println("1.이전 페이지  2.다음 페이지  0.이전 화면");
										int subMenu = scan.nextInt();
										scan.nextLine();
										if (subMenu == 0)
											continue request; // 0을 입력받으면 건의사항 메뉴로.
										if (subMenu == 1)
											page = commentDB.showPages(--page, searchList);
										else if (subMenu == 2)
											page = commentDB.showPages(++page, searchList);
										else
											System.out.println("잘못된 입력!");
									}
								} else {
									System.out.println("등록된 건의사항이 없습니다.");
									continue request;
								}
							case 2:// 답변
								osys.history(loginAdm.getId(), "건의사항", "답변");
								System.out.println("답변하시고자 하는 건의사항의 아이디를 입력해주세요. (0은 이전 화면)");
								searchId = scan.nextLine();
								if (searchId.equals("0"))
									continue admin;

								searchList = commentDB.searchComments(searchId);

								if (searchList != null) {
									commentDB.showCommentList(searchList);

									System.out.println("답변하시고자 하는 건의사항의 번호를 입력해주세요.");
									System.out.print("번호: ");

									int searchNo = scan.nextInt();
									scan.nextLine();
									commentDB.replyComment(searchNo, searchList, loginAdm);
									continue request;
								} else {
									System.out.println("등록된 건의사항이 없습니다.");
									continue request;
								}
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								continue admin;
							}// end switch
						} // end while_request
					case 4:// 관리자 관리
						admng: while (true) {// 관리자관리메뉴 while
							osys.history(loginAdm.getId(), "관리자 관리");
							osys.admin_admng();
							menu = scan.nextInt();
							scan.nextLine();
							if (!(0 <= menu && menu < 5)) {
								System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
								continue admng;
							}
							switch (menu) {// 1.관리자 검색 2.전체 관리자 목록 3.새 관리자 등록 4.관리자정보수정 0.이전화면
							case 1:// 관리자 검색
								osys.history(loginAdm.getId(), "관리자 관리", "관리자 검색");
								System.out.println("검색할 관리자 아이디 혹은 이름을 입력해주세요.");
								String searchAdminId = scan.nextLine();
								adminDB.search(searchAdminId);// 관리자 검색 메서드
								continue admng;
							case 2:// 전체 관리자 목록
								osys.history(loginAdm.getId(), "관리자 관리", "전체 관리자 목록");
								adminDB.searchAll();// 전체 관리자 목록 출력 메서드
								continue admng;
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
										continue admin;
									}
								} // end while_newadm
								continue admin;
							case 4:
								osys.history(loginAdm.getId(), "관리자 관리", "관리자 정보수정");
								System.out.println("검색할 관리자 아이디를 정확하게 입력해주세요.");
								String searchAdminId2 = scan.nextLine();
								adminDB.admin_modify(searchAdminId2);

								continue admin;
							case 0:// 이전화면
								System.out.println("이전화면으로 돌아갑니다.");
								continue admin;
							}// end switch
						} // end while_request
					case 5:// 로그아웃
						while (true) {// 로그아웃 메서드
							osys.history(loginMem.getId(), "로그아웃");
							System.out.println("로그아웃을 하시겠습니까? y/n");
							String out = scan.nextLine().toLowerCase();
							if (out.equals("y")) {
								System.out.println("로그아웃 되었습니다.");
								login = 0;
								break;
							} else if (out.equals("n")) {
								System.out.println("로그아웃이 취소되었습니다.");
								login = 2;
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
					}
				} // --------------------------------관리자 while end-------------------------
			}// end switch_login
		} // end while_main
	}// end main

	static void detectBlackList(List<Member> list) { // 전체 회원의 도서 연체 여부 검사
		if (list == null || list.size() == 0)
			return; // 가입된 회원이 없을 경우 메서드 종료.
		for (Member m : list) { // for문으로 회원정보 하나씩 검색
			List<Book> rentList = m.getRentList(); // 회원이 대출한 도서 목록을 받음
			if (rentList == null || rentList.size() == 0)
				continue; // 대출한 도서가 없을 경우 바로 다음 회원 검색
			else { // 대출한 도서가 있을 경우
				for (Book b : rentList) { // 대출 도서의 반납일을 하나씩 검색
					if (LocalDate.now().isAfter(b.getReturnDate())) { // 도서반납일이 현재보다 이전인 책이 하나라도 있을 경우
						m.setStatus(true); // 회원상태를 연체 중(블랙리스트에 표시)으로 바꿈.
						break; // 회원 상태를 바꿨으면 바로 다음 회원으로 넘어감.
					}
				}
			}
		}
	}
}// end class