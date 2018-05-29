package libProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Comparators.BookTitleComparator;

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
					if(b.isbn==Integer.parseInt(string)) searchList.add(b);
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
		System.out.println();
		System.out.print("출판사 :");
		publisher = scan.nextLine();
		System.out.println();
		Book b = new Book(title,author,subject,publisher); 
		Book.isbn_count++;//책 일련번호(카운트)+1
		b.isbn = Book.isbn_count;//일련번호 인덱스 대입
		b.setIndex(b.change_subject(subject)+b.isbn);//분야 + isbn -> 인덱스
		bookList.add(b);
	}

	//삭제
	@Override
	void delete(Data data) {
		Book b = (Book)data;//get,set이용을 위한 형변환		
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
		System.out.printf("현재 입력된 분야 : %s%n",b.change_subject(b.getSubject()));
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
	List searchAll() {
		// TODO Auto-generated method stub
		for(int i=0;i<bookList.size();i++) {
			System.out.println(bookList.get(i));
		}
		return null;
	}

	//정렬
	@Override
	List align() {
		BookTitleComparator c = new BookTitleComparator();
		Collections.sort(bookList, c);
		return bookList;
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
				int index = Integer.parseInt(rent.substring(2, 6));//인덱스 추출
				for(Book b:bookDB.bookList) {
					if(b.isbn==index&&b.status==true) {//검색결과 확인,재고확인
						System.out.println("선택하신 도서는 "+b.title+"입니다.");
						rentcart = b;//선택한 도서 대출카트에 등록
						break;
					}
					else {//재고가 없거나, 잘못된 입력일 경우
						System.out.println("대출가능 도서가 없습니다.");
						break;
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
				//로그인멤버에 rentcart 추가
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
	
	boolean returnBooks(String index){//책반납
		boolean result=false;
		//인덱스를 받아서 책 반납
		//있으면 true, 없으면 false.
		return result;
	}
}
