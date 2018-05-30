package Pages;

import java.util.List;

public class Page {
	int currentPage;	//���� ������(0���� ����)
	int prevPage;		//���� ������(-1�̸� �������� ��)
	int nextPage;		//���� ������(Paging�� totalPages�� ������ �������� ��)
	
	List pageContents;		//�������� ��� �����͵�(����Ʈ)

	public Page(int currentPage, int prevPage, int nextPage, List pageContents) {
		super();
		this.currentPage = currentPage;
		this.prevPage = prevPage;
		this.nextPage = nextPage;
		this.pageContents = pageContents;
	}
}
