package libProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Comments.Comment;
import Comparators.*;

public class BookDB extends DB{
	List<Book> bookList;
	
	//검색, 전체검색, 정렬 미완성, toString 규격에 맞게 수정
	
	public BookDB() {
		this.bookList = new ArrayList();
		this.bookList.add(new Book("소피의 세계","요슈타인가아더 ",1,"현암사"));
		this.bookList.add(new Book("간다, 봐라","법정",2,"김영사"));
		this.bookList.add(new Book("프로테스탄트 윤리","막스 베버",3,"현대지성"));
		this.bookList.add(new Book("별, 빛의과학","지웅배",4,"위즈덤하우스"));
		this.bookList.add(new Book("신소재공학","오세동",5,"복두출판사"));
		this.bookList.add(new Book("공공미술, 도시를그리다","홍경표",6,"재승출판"));
		this.bookList.add(new Book("쓸어담는 한자","권작가",7,"쓸어담는 한자"));
		this.bookList.add(new Book("전쟁과 평화","레프 톨스토이",8,"홍진미디어"));
		this.bookList.add(new Book("블랙어스","티머시 스나이더",9,"열린책들"));
		this.bookList.add(new Book("온돌, 기원과 역사","손진태",9,"온이퍼브"));
//		System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
//		System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
	}

	//검색
		@Override
		List search(String title) {
			List<Book> searchList = new ArrayList<Book>();
			for(Book b:bookList) {
				if(b.title.contains(title)) searchList.add(b);
			}
			return searchList;
		}
		
		List search(String string, int std) {
			List<Book> searchList = new ArrayList<Book>();
			switch(std) {//1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 
			case 1:	//제목
			for(Book b:bookList) {
				if(b.title.contains(string)) searchList.add(b);
			}
			return searchList;
			case 2://저자
				for(Book b:bookList) {
					if(b.author.contains(string)) searchList.add(b);
				}
				return searchList;
			case 3://출판사
				for(Book b:bookList) {
					if(b.publisher.contains(string)) searchList.add(b);
				}
				return searchList;
			case 4://분야
				for(Book b:bookList) {
					if(b.subject==Integer.parseInt(string)) searchList.add(b);
				}
				return searchList;
			case 5://인덱스
				for(Book b:bookList) {
					if(b.index.contains(string)) searchList.add(b);
				}
				return searchList;
			case 6://ISBN
				for(Book b:bookList) {
					if(b.isbn.contains(string)) searchList.add(b);
				}
				return searchList;
			}//end switch_std
			return null;
		}//end search

	//도서 자료 입력받고 가공, 데이터반환
	void input() {
		//변수 선언
		Scanner scan = new Scanner(System.in);
		String title="";
		String author="";
		int subject=0;
		String publisher="";
		//입력시작
		System.out.print("제목 :");
		title = scan.nextLine();
		System.out.println();
		System.out.print("저자 :");
		author = scan.nextLine();
		System.out.println();
		//철학 종교 사회학 자연과학 기술과학 예술 언어 문학 역사
		System.out.println("분야 리스트");
		System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
		System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
		System.out.print("분야 :");
		subject = scan.nextInt();
		scan.nextLine();
		System.out.println();
		System.out.print("출판사 :");
		publisher = scan.nextLine();
		System.out.println();
		Book b = new Book(title,author,subject,publisher); 
		Book.isbn_count++;//책 일련번호(카운트)+1
		b.setIndex(b.change_subject(subject)+b.isbn);//분야 + isbn -> 인덱스
		bookList.add(b);
		System.out.println("도서등록이 완료되었습니다.");
	}

	//삭제
	@Override
	void delete(Data data) {
		Book b = (Book)data;//get,set이용을 위한 형변환
		System.out.println(b.getTitle()+"이/가 삭제됩니다.");
		bookList.remove(b);
		
	}

	@Override
	void update(Data data) {
		Book b = (Book)data;//get,set이용을 위한 형변환
		Scanner scan = new Scanner(System.in);
		//수정시작
		System.out.printf("현재 입력된 제목 : %s%n",b.getTitle());
		System.out.print("수정하실 제목 :");
		b.setTitle(scan.nextLine());
		System.out.println();
		
		System.out.printf("현재 입력된 저자 : %s%n",b.getAuthor());
		System.out.print("수정하실 저자 :");
		b.setAuthor(scan.nextLine());
		System.out.println();
		//철학 종교 사회학 자연과학 기술과학 예술 언어 문학 역사
		System.out.println("분야 리스트");
		System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
		System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
		System.out.printf("현재 입력된 분야 : %s%n",b.change_subject2(b.getSubject()));
		System.out.print("수정하실 분야 :");
		b.setSubject(scan.nextInt());
		System.out.println();
		System.out.printf("현재 입력된 출판사 : %s%n",b.getPublisher());
		System.out.print("수정하실 출판사 :");
		b.setPublisher(scan.nextLine());
		System.out.println();
	}

	//전체검색
	@Override
	List searchAll() {	//책 전체 리스트 출력 메서드
		Osystem osys = new Osystem();
		osys.showBookList(bookList);	//전체 리스트 콘솔출력
		align();	//책 정렬 메서드 호출 -> align()에서 std에 0을 입력하지 않는 한 계속해서 호출되는 것에 주목.
		return null;
	}

	//정렬
	@Override
	void align() {	//책 정렬 메서드(책 정렬 디폴트 기준은 인덱스 순.)
		Osystem osys = new Osystem();	
		
		while(true) {	//반복문 while - 잘못된 입력발생시 다시 입력가능하게 루프함.
			osys.observer_align();	//정렬메뉴 콘솔 출력(0은 이전화면)
			Scanner scan = new Scanner(System.in);
			int std = scan.nextInt();	//정렬기준(std) 입력 받기.
			scan.nextLine();
			
			switch(std) {	//std에 따라 책 정렬
			case 1:	//제목
				//책 제목순으로 오름차순 정렬시켜주는 Comparator객체(정확하게는 구현객체) 생성.
				BookTitleComparator cTitle = new BookTitleComparator();
				Collections.sort(bookList, cTitle);	//책 DB의 모든 책 객체를 제목순 정렬.
				osys.showBookList(bookList);	//정렬된 책 리스트를 출력하기 위해 전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case 2:	//저자
				//저자 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookAuthorComparator cAuthor = new BookAuthorComparator();
				Collections.sort(bookList, cAuthor);	//책 DB를 저자 순 정렬.
				osys.showBookList(bookList);	//전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case 3:	//출판사
				//출판사 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookPublisherComparator cPublisher = new BookPublisherComparator();
				Collections.sort(bookList, cPublisher);	//책 DB를 출판사 순 정렬.
				osys.showBookList(bookList);	//전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case 4:	//주제
				//주제 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookSubjectComparator cSubject = new BookSubjectComparator();
				Collections.sort(bookList, cSubject);	//책 DB를 주제 순 정렬.
				osys.showBookList(bookList);	//전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case 5:	//인덱스
				//인덱스 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookIndexComparator cIndex = new BookIndexComparator();
				Collections.sort(bookList, cIndex);	//책 DB를 인덱스 순 정렬.
				osys.showBookList(bookList);	//전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case 6:	//ISBN
				//ISBN 순으로 오름차순 정렬시켜주는 Comparator객체.
				BookISBNComparator cISBN = new BookISBNComparator();
				Collections.sort(bookList, cISBN);	//책 DB를 인덱스 순 정렬.
				osys.showBookList(bookList);	//전체 리스트 출력 메서드 호출(재귀!).
				continue;
			case 0: //이전화면 - 뒤로 가기 전에 반드시 책 목록을 인덱스 순(디폴트!)으로 정렬
				BookIndexComparator c = new BookIndexComparator();
				Collections.sort(bookList, c);
				return;
			default: //잘못된 입력
				System.out.println("잘못된 입력입니다!");
				continue;	//정렬 입력 다시 받음.
			}
		}
	}
	
	Book adminsearch(BookDB bookDB) {
		Scanner scan = new Scanner(System.in);
		Book selected = null;//도서대출에 필요한 대출카트 참조변수
		check: while (true) {
			String rent = scan.nextLine();
			if (rent.length() != 7) {//7자리 아닐경우 예외처리
				System.out.println("잘못된 입력입니다.");
				break;
			}
			else if(rent.equals("0")){//이전화면 예외처리
				System.out.println("이전화면으로 돌아갑니다.");
				break check;
			}
			else {//정상입력일경우
				String index = rent.substring(2, 7);//인덱스 추출
				System.out.println(index);
				for(Book b:bookDB.bookList) {
					if(b.isbn.equals(index)&&b.status==true) {//검색결과 확인,재고확인
						System.out.println("선택하신 도서는 "+b.title+"입니다.");
						selected = b;//선택한 도서 샘플에 등록
						return selected;
					}
					else {//재고가 없거나, 잘못된 입력일 경우
						System.out.println("선택가능한 도서가 없습니다.");
						break;
					}
				}
				
			}//인덱스 검색 끝
		}
		return selected;
	}
	
	void rentBooks(BookDB bookDB,Member loginMem){//책대출
		Scanner scan = new Scanner(System.in);
		Book rentcart = null;//도서대출에 필요한 대출카트 참조변수
		rentcheck: while (true) {
			System.out.println("대출을 원하는 도서의 인덱스를 입력해주세요.(7자리)(0.이전화면)");
			String rent = scan.nextLine();
			if (rent.length() != 7) {//7자리 아닐경우 예외처리
				System.out.println("잘못된 입력입니다.");
				break;
			}
			else if(rent.equals("0")){//이전화면 예외처리
				System.out.println("이전화면으로 돌아갑니다.");
				break rentcheck;
			}
			else {//정상입력일경우
				String index = rent.substring(2, 7);//인덱스 추출
				for(Book b:bookDB.bookList) {
					if(b.isbn.equals(index)&&b.status==true) {//검색결과 확인,재고확인
						System.out.println("선택하신 도서는 "+b.title+"입니다.");
						rentcart = b;//선택한 도서 대출카트에 등록
						break;
					}
					else {//재고가 없거나, 잘못된 입력일 경우
						System.out.println("대출가능 도서가 없습니다.");
						return;
					}
				}
				
			}//인덱스 검색 끝
			break;
		} // end while_rentcheck
			// 대출확인----------------------------------------------------
		System.out.println("책을 대출하시겠습니까? Y/N");
		String menu2 = scan.nextLine();
		rentbook: while (true) {
			if (menu2.equalsIgnoreCase("y")) {
				rentcart.setStatus(false);//대출도서 상태 대출중
				rentcart.setRenter(loginMem);//대출도서에 대출자 등록
				rentcart.setRentCount(rentcart.getRentCount()+1);//대출횟수 증가
				loginMem.rentList.add(rentcart);//대출자 대출카트에 대출한 책 추가
				System.out.println("정상적으로 대출되었습니다.");
				break rentbook;
			} else if (menu2.equalsIgnoreCase("n")) {
				System.out.println("도서검색화면으로 돌아갑니다.");
				break rentbook;
			} else {
				System.out.println("잘못된 입력입니다.");
				break;
			}
		} // end while_rentbook;
			// 대출확인끝---------------------------------------------------
	}
	
	void returnBooks(List<Book> rentList){//책반납 메서드
		if(rentList==null || rentList.size()==0) {	//대출한 책이 없을 경우(대출리스트가 null이거나 길이가 0)
			System.out.println("대출하신 책이 없습니다.");
			return;	//메서드 종료
		}
		
		returnB:while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("반납하실 책의 인덱스를 입력해주세요.(0은 이전 화면)");
			System.out.print("인덱스: ");
			String returnI = scan.nextLine();	//인덱스 입력을 받음
			
			if(returnI.equals("0")) break;	//0은 메서드 종료
			
			for(Book b:rentList) {	//입력 인덱스와 일치하는 대출 도서 검색
				if(rentList==null || rentList.size()==0) {
					System.out.println("반납완료!");
					return;
				}
				
				if(b.getIndex().equals(returnI)) {	//입력 인덱스와 일치하는 도서를 찾았을 경우
					if(rentList.remove(b)) {	//대출 리스트에서 해당 책 제거
						b.setStatus(true);		//제거 성공시 해당 도서의 상태를 "대출가능"으로 바꾸고
						System.out.println(b.getTitle()+"(을)를 반납했습니다.");	//성공 메시지 띄움
						continue returnB;	//다시 인덱스 입력 창으로 돌아감
					} else {	//대출 리스트에서 책이 제거되지 않을 때 명령어
						System.out.println("반납오류! 이전 화면으로 돌아갑니다.");
						continue returnB;
					}
				}
			}
			System.out.println("대출 도서 중 해당 인덱스의 도서가 존재하지 않습니다.");	//if문에 걸리지 않을 경우, 해당도서가 없음.
		}
		//인덱스를 받아서 책 반납
		//있으면 true, 없으면 false.
	}
	
	public void showPages(int page) {//전체 관리자 목록 페이지별로 보여주기(매개변수는 검색하고자 하는 페이지)
		int totalPages = (int)Math.ceil(bookList.size()/10.);
		
		if(page<1 || page>totalPages) {
			System.out.println("페이지 없음!");
			if(page<1) page=1;
			else page = totalPages;
			return;
		}
		
		for(int i=(page-1)*10; i<page*10; i++) {
			System.out.println(bookList.get(i));
		}
		System.out.println("현재 "+page+"페이지/"+totalPages+"페이지");
	}
	
	public void showPages(int page, List<Book> searchList) {//검색한 관리자 목록 페이지별로 보여주기(매개 리스트는 검색 리스트)
		int totalPages = (int)Math.ceil(searchList.size()/10.);
		
		if(page<1 || page>totalPages) {
			System.out.println("페이지 없음!");
			if(page<1) page=1;
			else page = totalPages;
			return;
		}
		
		for(int i=(page-1)*10; i<page*10; i++) {
			System.out.println(searchList.get(i));
		}
		System.out.println("현재 "+page+"페이지/"+totalPages+"페이지");
	}
}
