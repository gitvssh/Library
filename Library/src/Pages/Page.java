package Pages;

import java.util.List;

public class Page {
	int currentPage;	//현재 페이지(0부터 시작)
	int prevPage;		//이전 페이지(-1이면 페이지의 끝)
	int nextPage;		//다음 페이지(Paging의 totalPages와 같으면 페이지의 끝)
	
	List pageContents;		//페이지에 담길 데이터들(리스트)

	public Page(int currentPage, int prevPage, int nextPage, List pageContents) {
		super();
		this.currentPage = currentPage;
		this.prevPage = prevPage;
		this.nextPage = nextPage;
		this.pageContents = pageContents;
	}
}
