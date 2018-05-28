package libProject;

import java.util.ArrayList;
import java.util.List;

public abstract class DB {//데이터 베이스의 부모 클래스

	abstract List search(String title); 			//검색 메서드
	
	abstract void insert(Data data);	//추가 메서드
	
	abstract void delete(Data data);	//제거 메서드
	
	abstract void update(Data data);	//수정 메서드
	
	abstract List searchAll();	//DB자료 전체를 보여주는 메서드
	
	abstract List align(); //DB자료를 정렬하는 메서드
}
