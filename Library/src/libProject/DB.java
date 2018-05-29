package libProject;

import java.util.ArrayList;
import java.util.List;

public abstract class DB {//데이터 베이스의 부모 클래스
	
	abstract List search(String title);

	//abstract List search(String title, int std); //검색 메서드 -> 검색 키워드가 책 제목인지 저자인지 아이디인지(std 보고 확인) 등을 구분할 수 있게 메서드 변경
	
	abstract void input();	//추가 메서드 -> 수정: 별도의 매개 데이터를 받지 않고 DB 추가가 가능하게 변경.
	//abstract void insert(Data data);	//추가 메서드 -> 수정: 별도의 매개 데이터를 받지 않고 DB 추가가 가능하게 변경.
	
	abstract void delete(Data data);	//제거 메서드
	
	abstract void update(Data data);	//수정 메서드
	
	abstract List searchAll();	//DB자료 전체를 보여주는 메서드
	
	abstract List align(); //DB자료를 정렬하는 메서드

}
