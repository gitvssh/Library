package Pages;

import java.util.ArrayList;
import java.util.List;

public class Paging {	//�������� ����� Ŭ����
	int totalPages;	//�� ������ ��
	ArrayList<Page> pageList;	//�� �������� ����� ����Ʈ
	
	public Paging(List list) { //��ü ������ ������ ������� ������ ����, ������ ����Ʈ ������ ���ÿ�.
		pageList = new ArrayList<Page>();
		totalPages = (int)Math.ceil(list.size()/10.);	//�� ������ ���� ������ ��/10�� �ø��� ��
		for(int i=0; i<totalPages; i++) {
			List inputList = new ArrayList();	//�� �������� ������ ��� ������ ����Ʈ
			int limit = (i==totalPages-1) ? list.size():10;
			//�� �������� ��� ������ ����Ʈ�� �ִ� 10��. ������ �������� ��� ������ ���� ���� �������� ��� �ְ� ���� ����Ʈ�� ũ��
			for(int j=0; j < limit; j++) {
				inputList.add(list.get(j));
			}
			pageList.add(new Page(i-1,i,i+1,inputList));
		}
	}
}
