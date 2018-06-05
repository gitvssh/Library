package libProject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Comments.Comment;
import Comparators.*;

public class BookDB extends DB {
	List<Book> bookList;
	Scanner scan = new Scanner(System.in);

	public BookDB() {
		this.bookList = new ArrayList();

		//dummy books
		this.bookList.add(new Book("에바 일루즈","박형신","3","커뮤니케이션북스"));
		this.bookList.add(new Book("신노예","최성환","3","앤길"));
		this.bookList.add(new Book("그해 봄","박건웅","9","보리"));
		this.bookList.add(new Book("안평","심경호","9","알마"));
		this.bookList.add(new Book("대학의 기업화","고부응","3","한울"));
		this.bookList.add(new Book("장 공의 체면","원팡이","8","연극과인간"));
		this.bookList.add(new Book("그리스 비극 깊이 읽기","최혜영","9","푸른역사"));
		this.bookList.add(new Book("외국어 전파담","로버트 파우저","9","혜화1117"));
		this.bookList.add(new Book("성서 그리고 사람들","장-피에르 이즈부츠","9","황소자리"));
		this.bookList.add(new Book("일본인과 이순신","이종각","9","이상"));
		this.bookList.add(new Book("세계 종교의 역사","리처드 할러웨이","2","소소의책"));
		this.bookList.add(new Book("신학을 다시 묻다","후카이 토모아키","2","비아"));
		this.bookList.add(new Book("무법적 정의","테드 W.제닝스","2","길"));
		this.bookList.add(new Book("예수와 붓다가 함께했던 시간들","개리 R.레너드","2","정신세계사"));
		this.bookList.add(new Book("세상을 알라","리하르트 다비트 프레히트","1","열린책들"));
		this.bookList.add(new Book("철학의 위안","보에티우스","1","현대지성"));
		this.bookList.add(new Book("차별 감정의 철학","나카지마 요시미치","1","바다출판사"));
		this.bookList.add(new Book("그럼에도 불구하고 살아갈 이유","오카다 다카시","1","책세상"));
		this.bookList.add(new Book("말이 칼이 될 때","홍성수","3","어크로스"));
		this.bookList.add(new Book("우리도 사랑할 수 있을까","오연호","3","오마이북"));
		this.bookList.add(new Book("인생극장","노명우","3","사계절"));
		this.bookList.add(new Book("하나도 괜찮지 않습니다","오찬호","3","블랙피쉬"));
		this.bookList.add(new Book("그래비티 익스프레스","조진호","4","위즈덤하우스"));
		this.bookList.add(new Book("인류세의 모험","가이아 빈스","4","곰출판"));
		this.bookList.add(new Book("우리를 둘러싼 바다","레이첼 카슨","4","김홍옥"));
		this.bookList.add(new Book("바람의 자연사","빌 스트리버","4","까치"));
		this.bookList.add(new Book("아무도 몰랐던 세계적 예술가","남경원","6","K.won"));
		this.bookList.add(new Book("사랑의 예술사","이미혜","6","경북대학교출판부"));
		this.bookList.add(new Book("서양 미학사의 거장들","하선규","6","현암사"));
		this.bookList.add(new Book("모던 타임스","자크 랑시에르","6","현실문화A"));
		this.bookList.add(new Book("지금 우리말글","손진호","7","진선출판사"));
		this.bookList.add(new Book("내손안에 사자성어","김진남","7","아인스북"));
		this.bookList.add(new Book("바른 소리글자","김세환","7","백암"));
		this.bookList.add(new Book("강재형의 말글살이","강재형","7","기쁜하늘"));
		this.bookList.add(new Book("무저갱","반시연","8","인디페이퍼"));
		this.bookList.add(new Book("경애의 마음","김금희","8","창비"));
		this.bookList.add(new Book("박쥐우산","박은경","8","푸른사상"));
		this.bookList.add(new Book("풀꽃 사랑","한나라","8","연인M&B"));
		this.bookList.add(new Book("해양 유전 개발","정우송","5","교문사"));
		this.bookList.add(new Book("알기 쉬운 유체역학","김선일","5","성안당"));
		this.bookList.add(new Book("자동차 용어사전","자동차용어사전편찬회","5","일진사"));
		this.bookList.add(new Book("아두이노로 만드는 자동차","허경용","5","오므사"));
		this.bookList.add(new Book("소피의 세계","요슈타인가아더 ","1","현암사"));
		this.bookList.add(new Book("간다, 봐라","법정","2","김영사"));
		this.bookList.add(new Book("프로테스탄트 윤리","막스 베버","3","현대지성"));
		this.bookList.add(new Book("별, 빛의과학","지웅배","4","위즈덤하우스"));
		bookList.get(12).setRentCount(80);
		bookList.get(15).setRentCount(60);
		bookList.get(19).setRentCount(30);
		bookList.get(25).setRentCount(95);
		bookList.get(30).setRentCount(75);
		bookList.get(36).setRentCount(55);
		this.bookList.add(new Book("신소재공학","오세동","5","복두출판사"));
		this.bookList.add(new Book("공공미술, 도시를그리다","홍경표","6","재승출판"));
		this.bookList.add(new Book("쓸어담는 한자","권작가","7","쓸어담는 한자"));
		bookList.get(6).setRentCount(50);
		this.bookList.add(new Book("전쟁과 평화", "레프 톨스토이", "8", "홍진미디어"));
		this.bookList.add(new Book("블랙어스", "티머시 스나이더", "9", "열린책들"));
		this.bookList.add(new Book("온돌,기원과 역사", "손진태", "9", "온이퍼브"));
		bookList.get(9).setRentCount(10);
	}

	@Override
	List search(String title) {
		List<Book> searchList = new ArrayList<Book>();
		for (Book b : bookList) {
			if (b.title.contains(title))
				searchList.add(b);
		}
		return searchList;
	}

	List search(String string, int std) {
		List<Book> searchList = new ArrayList<Book>();
		switch (std) {// 1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록
		case 1: // 제목
			for (Book b : bookList) {
				if (b.title.contains(string))
					searchList.add(b);
			}
			return searchList;
		case 2:// 저자
			for (Book b : bookList) {
				if (b.author.contains(string))
					searchList.add(b);
			}
			return searchList;
		case 3:// 출판사
			for (Book b : bookList) {
				if (b.publisher.contains(string))
					searchList.add(b);
			}
			return searchList;
		case 4:// 분야
			for (Book b : bookList) {
				if (b.subject.equals(string))
					searchList.add(b);
			}
			return searchList;
		case 5:// 인덱스
			for (Book b : bookList) {
				if (b.index.contains(string))
					searchList.add(b);
			}
			return searchList;
		case 6:// ISBN
			for (Book b : bookList) {
				if (b.isbn.contains(string))
					searchList.add(b);
			}
			return searchList;
		}// end switch_std
		return null;
	}// end search

	// 도서 자료 입력받고 가공, 데이터반환
	void input() {
		String title = "";
		String author = "";
		String subject = "";
		String publisher = "";

		System.out.print("제목 :");
		title = scan.nextLine();
		if (title.equals("0")) {
			return;
		}
		System.out.println();

		System.out.print("저자 :");
		author = scan.nextLine();
		System.out.println();

		System.out.println("분야 리스트");
		System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
		System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
		System.out.print("분야 :");
		subject = scan.nextLine();
		System.out.println();

		System.out.print("출판사 :");
		publisher = scan.nextLine();
		System.out.println();

		Book b = new Book(title, author, subject, publisher);
		Book.isbn_count++;
		b.setIndex(b.change_subject(subject) + b.isbn);
		bookList.add(b);
		System.out.println("도서등록이 완료되었습니다.");
	}

	@Override
	void delete(Data data) {
		Book b = (Book) data;
		System.out.println(b.getTitle() + "이/가 삭제됩니다.");
		bookList.remove(b);
	}

	@Override
	void update(Data data) {
		Book b = (Book) data;

		System.out.printf("현재 입력된 제목 : %s%n", b.getTitle());
		System.out.print("수정하실 제목 :");
		b.setTitle(scan.nextLine());
		System.out.println();

		System.out.printf("현재 입력된 저자 : %s%n", b.getAuthor());
		System.out.print("수정하실 저자 :");
		b.setAuthor(scan.nextLine());
		System.out.println();

		System.out.println("분야 리스트");
		System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
		System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
		System.out.printf("현재 입력된 분야 : %s%n", b.change_subject2(b.getSubject()));
		System.out.print("수정하실 분야 :");
		b.setSubject(scan.nextLine());
		System.out.println();

		System.out.printf("현재 입력된 출판사 : %s%n", b.getPublisher());
		System.out.print("수정하실 출판사 :");
		b.setPublisher(scan.nextLine());
		System.out.println();
	}

	@Override
	List searchAll() {
		Osystem osys = new Osystem();
		osys.showBookList(bookList);
		align();
		return null;
	}

	@Override
	void align() {
		Osystem osys = new Osystem();

		while (true) {
			osys.observer_align(); // 정렬메뉴 콘솔 출력(0은 이전화면)
			String std = scan.nextLine(); // 정렬기준(std) 입력 받기.

			switch (std) { // std에 따라 책 정렬
			case "1": // 제목
				// 책 제목순으로 오름차순 정렬시켜주는 Comparator객체(정확하게는 구현객체) 생성.
				BookTitleComparator cTitle = new BookTitleComparator();
				Collections.sort(bookList, cTitle); // 책 DB의 모든 책 객체를 제목순 정렬.
				osys.showBookList(bookList); // 정렬된 책 리스트를 출력하기 위해 전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case "2": // 저자
				// 저자 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookAuthorComparator cAuthor = new BookAuthorComparator();
				Collections.sort(bookList, cAuthor); // 책 DB를 저자 순 정렬.
				osys.showBookList(bookList); // 전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case "3": // 출판사
				// 출판사 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookPublisherComparator cPublisher = new BookPublisherComparator();
				Collections.sort(bookList, cPublisher); // 책 DB를 출판사 순 정렬.
				osys.showBookList(bookList); // 전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case "4": // 주제
				// 주제 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookSubjectComparator cSubject = new BookSubjectComparator();
				Collections.sort(bookList, cSubject); // 책 DB를 주제 순 정렬.
				osys.showBookList(bookList); // 전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case "5": // 인덱스
				// 인덱스 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookIndexComparator cIndex = new BookIndexComparator();
				Collections.sort(bookList, cIndex); // 책 DB를 인덱스 순 정렬.
				osys.showBookList(bookList); // 전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case "6": // ISBN
				// ISBN 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookISBNComparator cISBN = new BookISBNComparator();
				Collections.sort(bookList, cISBN); // 책 DB를 인덱스 순 정렬.
				osys.showBookList(bookList); // 전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case "7": // 최다대출도서
				// 최다대출 순으로 오름차순 정렬시켜주는 Comparator객체.
				System.out.println("1.전체대출순위 2.장르별 대출순위");
				String menu = scan.nextLine();
				switch (menu) {
				case "1":
					BookRentCountComparator crentCount = new BookRentCountComparator();
					Collections.sort(bookList, crentCount); // 책 DB를 인덱스 순 정렬.
					osys.showRentBookList(bookList); // 전체 리스트 출력 메서드 호출(재귀!).
					break;
				case "2":
					System.out.println("검색하실 분야를 입력하세요");
					System.out.println("분야 리스트");
					System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
					System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
					String menu2 = scan.nextLine();
					List<Book> searchList = new ArrayList();
					for (Book b : bookList) {
						if (b.subject.equals(menu2))
							searchList.add(b);
					}
					crentCount = new BookRentCountComparator();
					Collections.sort(searchList, crentCount); // 책 DB를 주제 순 정렬.
					osys.showBookList(searchList); // 전체 리스트 출력 메서드 호출(재귀!).
					break;
				default:
					System.out.println("잘못된 입력입니다.");
					break;
				}
				continue;
			case "0": // 이전화면 - 뒤로 가기 전에 반드시 책 목록을 인덱스 순(디폴트!)으로 정렬
				BookIndexComparator c = new BookIndexComparator();
				Collections.sort(bookList, c);
				return;
			default: // 잘못된 입력
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue; // 정렬 입력 다시 받음.
			}
		}
	}

	Book adminsearch(BookDB bookDB) {// 관리자 도서관리,수정에 씀, 선택도서 리턴
		Book selected = null;
		check: while (true) {
			String rent = scan.nextLine();
			if (rent.length() != 7) {// 7자리 아닐경우 예외처리
				System.out.println("잘못된 입력입니다.");
				break;
			} else if (rent.equals("0")) {// 이전화면 예외처리
				System.out.println("이전화면으로 돌아갑니다.");
				break check;
			} else {// 정상입력일경우
				String index = rent;// 인덱스 추출
				System.out.println(index);
				for (Book b : bookList) {
					if (b.index.equals(index) && b.status == true) {// 검색결과 확인,재고확인
						System.out.println("선택하신 도서는 " + b.title + "입니다.");
						selected = b;// 선택한 도서 샘플에 등록
						return selected;
					} 
				}
				System.out.println("선택가능한 도서가 없습니다.");
				return null;
			} // 인덱스 검색 끝
		}
		return selected;
	}

	void rentBooks(Member loginMem) {
		Book rentcart = null;
		rentcheck: while (true) {
			System.out.println("대출을 원하는 도서의 인덱스를 입력해주세요.(7자리)(0.이전화면)");
			String rent = scan.nextLine();
			if (rent.equals("0")) {// 이전화면 예외처리
				System.out.println("이전화면으로 돌아갑니다.");
				return;
			} else if (rent.length() != 7) {// 7자리 아닐경우 예외처리
				System.out.println("잘못된 입력입니다.");
				continue rentcheck;
			} else {// 정상입력일경우
				String index = rent.substring(2, 7);
				for (Book b : bookList) {
					if (b.isbn.equals(index) && b.status == true) {// 검색결과 확인,재고확인
						System.out.println("선택하신 도서는 " + b.title + "입니다.");
						LocalDate date = LocalDate.now();// 현재 날짜 정보를 LocalDate 객체로 생성
						LocalDate returnDate = date.with(TemporalAdjusters.next(date.getDayOfWeek()));
						b.setReturnDate(returnDate);
						rentcart = b;
						break;
					}
				}
				if (rentcart == null) {
					System.out.println("대출가능 도서가 없습니다.");
					return;
				}
			} // 인덱스 검색 끝
			break;
		} // end while_rentcheck
			// 대출확인----------------------------------------------------
		confirm: while (true) {
			System.out.println("책을 대출하시겠습니까? Y/N");
			String menu2 = scan.nextLine().toLowerCase().trim();
			if (menu2.equalsIgnoreCase("y")) {
				rentcart.setStatus(false);
				rentcart.setRenter(loginMem);
				rentcart.setRentCount(rentcart.getRentCount() + 1);
				loginMem.rentList.add(rentcart);
				System.out.println("정상적으로 대출되었습니다.");
				break confirm;
			} else if (menu2.equalsIgnoreCase("n")) {
				System.out.println("도서검색화면으로 돌아갑니다.");
				break confirm;
			} else {
				System.out.println("잘못된 입력입니다.");
				continue confirm;
			}
		} // end while_rentbook;
	}// 대출확인끝---------------------------------------------------

	void returnBooks(List<Book> rentList) {
		if (rentList == null || rentList.size() == 0) {
			System.out.println("대출하신 책이 없습니다.");
			return;
		}

		returnB: while (true) {
			if (rentList == null || rentList.size() == 0) {// 더 이상 반납할 책이 없으면 메서드 종료
				System.out.println("반납완료!");
				return;
			}

			System.out.println("[대출 도서]");
			for (Book b : rentList)
				System.out.println(b);

			Scanner scan = new Scanner(System.in);
			System.out.println("반납하실 책의 인덱스를 입력해주세요.(0은 이전 화면)");
			System.out.print("인덱스: ");
			String returnI = scan.nextLine();

			if (returnI.equals("0"))
				break;

			for (Book b : rentList) { // 입력 인덱스와 일치하는 대출 도서 검색

				if (b.getIndex().equals(returnI)) { // 입력 인덱스와 일치하는 도서를 찾았을 경우
					if (rentList.remove(b)) { // 대출 리스트에서 해당 책 제거
						b.setStatus(true); // 제거 성공시 해당 도서의 상태를 "대출가능"으로 바꾸고
						System.out.println(b.getTitle() + "(을)를 반납했습니다."); // 성공 메시지 띄움
						continue returnB; // 다시 인덱스 입력 창으로 돌아감
					} else { // 대출 리스트에서 책이 제거되지 않을 때 명령어
						System.out.println("반납오류! 이전 화면으로 돌아갑니다.");
						continue returnB;
					}
				}
			}
			System.out.println("대출 도서 중 해당 인덱스의 도서가 존재하지 않습니다."); // if문에 걸리지 않을 경우, 해당도서가 없음.
		}
		// 인덱스를 받아서 책 반납
		// 있으면 true, 없으면 false.
	}

	public int showPages(int page) {// 전체 책 목록 페이지별로 보여주기(매개변수는 검색하고자 하는 페이지)
		int totalPages = (int) Math.ceil(bookList.size() / 10.);

		if (page < 1 || page > totalPages) {
			System.out.println("페이지 없음!");
			if (page < 1)
				return 0;
			else
				return totalPages + 1;
		}

		int limit = (page != totalPages) ? page * 10 : bookList.size();
		for (int i = (page - 1) * 10; i < limit; i++) {
			System.out.println(bookList.get(i));
		}
		System.out.println("현재 " + page + "페이지/" + totalPages + "페이지");
		return page;
	}

	public int showPages(int page, List<Book> searchList) {// 검색한 책 목록 페이지별로 보여주기(매개 리스트는 검색 리스트)
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
