package libProject;

import java.util.ArrayList;
import java.util.List;

public abstract class DB {//������ ���̽��� �θ� Ŭ����

	abstract List search(String title); 			//�˻� �޼���
	
	abstract void insert(Data data);	//�߰� �޼���
	
	abstract void delete(Data data);	//���� �޼���
	
	abstract void update(Data data);	//���� �޼���
	
	abstract List searchAll();	//DB�ڷ� ��ü�� �����ִ� �޼���
	
	abstract List align(); //DB�ڷḦ �����ϴ� �޼���
}
