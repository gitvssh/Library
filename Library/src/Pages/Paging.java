package Pages;

import java.util.ArrayList;
import java.util.List;

public class Paging {	//페이지를 만드는 클래스
	int totalPages;	//총 페이지 수
	ArrayList<Page> pageList;	//각 페이지가 저장될 리스트
	
	public Paging(List list) { //객체 생성시 페이지 나누기와 페이지 생성, 페이지 리스트 저장을 동시에.
		pageList = new ArrayList<Page>();
		totalPages = (int)Math.ceil(list.size()/10.);	//총 페이지 수는 데이터 수/10을 올림한 수
		for(int i=0; i<totalPages; i++) {
			List inputList = new ArrayList();	//각 페이지에 나뉘어 담길 데이터 리스트
			int limit = (i==totalPages-1) ? list.size():10;
			//각 페이지에 담길 데이터 리스트는 최대 10개. 마지막 페이지에 담길 데이터 수는 이전 페이지에 모두 넣고 남은 리스트의 크기
			for(int j=0; j < limit; j++) {
				inputList.add(list.get(j));
			}
			pageList.add(new Page(i-1,i,i+1,inputList));
		}
	}
}
