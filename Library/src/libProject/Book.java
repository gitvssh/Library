package libProject;

//toString 규격에 맞게 수정
public class Book implements Data{
	
	
	String index;//인덱스는 분야(ex ㄱ. ㄷ. ㅂ.)+책생성카운트(1,2,...) 합쳐서 문자열로 생성
	String title;//제목
	String author;//저자
	int subject;//분야, 분야는 숫자로 받되, 카드예제 1,2,3,4를 spade,diamond로 바꾼것처럼 ㄱ.(철학-1),ㄴ.(종교-2)등으로 변환
	/*숫자로 받는 이유는, 나중에 출력시 다양한 형태로 출력(인덱스 ㄱ,ㄴ,... 도서검색장르 철학,종교...)로 되는데
	 *어차피 출력시 다른형태로 변환해야 될 경우가 있으니, 매개변수를 int로 설정하면 검색이나 정렬, 메모리관리에서 이점을 볼 수 있다고 생각됨
	 */
	
	String publisher;//출판사
	String isbn;//isbn을 카운터로 대신 쓰고, 나중에 분야와 조합해서 인덱스로 활용
	static int isbn_count=0;
	//인스턴스에서 static으로 변경
	/*isbn이란	
	*국제 표준 도서 번호(國際標準圖書番號, International Standard Book Number, ISBN)는 국제적으로 책에 붙이는 고유한 식별자이다.
	*isbn생성방법을 가져다 쓰기는 너무 복잡하고, 고유한 식별자가 카운터와 의미가 유사하니 카운터로 사용하는게 좋아보임
	*/
	boolean status;
	/*책의 상태는 db가 가지고 있느냐(1)과 없느냐(0)으로 구분
	 * 다만 대출상태(0)이고 반납기간이 지났느냐를 검사해서 연체중으로 출력
	 * “대출가능”, “대출중”, “연체중”
	 */
	int rentCount;//대출회수 대출할때마다 카운트 되도록
	//static에서 인스턴트로 변경, static은 전체 책이 카운트가 되기때문에 책 종류로 구별이 안됨
	
	Member renter;
	
//	상세정보(Desc) 
// 객체를 인스턴스변수로 받아서 사용하는것 나중에 구현

	//기본생성자
	public Book() {}
	
	//매개변수 생성자
	public Book(String title, String author, int subject,String publisher) {
		isbn_count++;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.publisher = publisher;
		this.isbn = this.isbnMaker(isbn_count);
		this.index = this.change_subject(subject)+this.isbnMaker(isbn_count);	//정렬 기능 시험하기 위해 임시 생성(형주).
		this.status = true;// 기본 도서관 생성시 1
		this.rentCount = 0; // 기본 대여회수 0
	}
	
	String isbnMaker(int isbn) {
	 String tmp = isbn+"";
	 switch(tmp.length()) {
	 case 1:
		 tmp = "0000"+tmp;
		 return tmp;
	 case 2:
		 tmp = "000"+tmp;
		 return tmp;
	 case 3:
		 tmp = "00"+tmp;
		 return tmp;
	 case 4:
		 tmp = "0"+tmp;
		 return tmp;
	 case 5:
		 return tmp;
	 }
	 return null;
	}
	String printStatus(boolean status) {
		if(status=true) {
		return "대출 가능";
		}
		else {
		return "대출 중";
		}
	}
	//인덱스 생성시 활용될 ㄱ.ㄴ.ㄷ. 변환메서드
	String change_subject(int subject) {
		switch(subject) {
		//철학 종교 사회학 자연과학 기술과학 예술 언어 문학 역사
		case 1:
			return "ㄱ.";
		case 2:
			return "ㄴ.";
		case 3:
			return "ㄷ.";
		case 4:
			return "ㄹ.";
		case 5:
			return "ㅁ.";
		case 6:
			return "ㅂ.";
		case 7:
			return "ㅅ.";
		case 8:
			return "ㅇ.";
		case 9:
			return "ㅈ.";
		}
		return "잘못된 입력입니다.";
	}
	
	//분야 출력시 활용될 종교,철학..변환 메서드
	String change_subject2(int subject) {
		switch(subject) {
		//철학 종교 사회학 자연과학 기술과학 예술 언어 문학 역사
		case 1:
			return "철학";
		case 2:
			return "종교";
		case 3:
			return "사회학";
		case 4:
			return "자연과학";
		case 5:
			return "기술과학";
		case 6:
			return "예술";
		case 7:
			return "언어";
		case 8:
			return "문학";
		case 9:
			return "역사";
		}
		return "잘못된 입력입니다.";
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}
	
	public Member getRenter() {
		return renter;
	}

	public void setRenter(Member renter) {
		this.renter = renter;
	}

	@Override
	public String toString() {
		return String.format(" %-7s | %-24s | %-8s | %-8s | %-5s | %-5s | %-7s %n",index,title,author,publisher,isbn,this.change_subject2(subject),printStatus(this.status)); 
	}

	
	
}