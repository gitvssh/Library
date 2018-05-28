package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDB extends DB{
	List<Book> bookList;
	
	//�˻�, ��ü�˻�, ���� �̿ϼ�
	
	public BookDB() {
		this.bookList = new ArrayList();
	}

	//�˻�
	@Override
	List search(String title) {
		List<Book> searchList = new ArrayList<Book>();
		for(Book b:bookList) {
			if(b.title.contains(title)) searchList.add(b);
		}
		return searchList;
	}

	//���� �ڷ� �Է¹ް� ����, �����͹�ȯ
	Data input() {
		//���� ����
		Scanner scan = new Scanner(System.in);
		String title="";
		String author="";
		int subject=0;
		String publisher="";
		//�Է½���
		System.out.print("���� :");
		title = scan.nextLine();
		System.out.println();
		System.out.print("���� :");
		author = scan.nextLine();
		System.out.println();
		//ö�� ���� ��ȸ�� �ڿ����� ������� ���� ��� ���� ����
		System.out.println("�о� ����Ʈ");
		System.out.println("1.ö�� 2.���� 3.��ȸ�� 4.�ڿ�����");
		System.out.println("5.������� 6.���� 7.��� 8.���� 9.����");
		System.out.print("�о� :");
		subject = scan.nextInt();
		System.out.println();
		System.out.print("���ǻ� :");
		publisher = scan.nextLine();
		System.out.println();
		Book b = new Book(title,author,subject,publisher); 
		return b;
	}
	
	//����Ʈ ����
	@Override
	void insert(Data data) {
		bookList.add((Book)data);
	}

	//����
	@Override
	void delete(Data data) {
		Book b = (Book)data;//get,set�̿��� ���� ����ȯ		
		bookList.remove(b);
	}

	@Override
	void update(Data data) {
		Book b = (Book)data;//get,set�̿��� ���� ����ȯ
		Scanner scan = new Scanner(System.in);
		//��������
		System.out.printf("���� �Էµ� ���� : %s%n",b.getTitle());
		System.out.print("�����Ͻ� ���� :");
		b.setTitle(scan.nextLine());
		System.out.println();
		
		System.out.printf("���� �Էµ� ���� : %s%n",b.getAuthor());
		System.out.print("�����Ͻ� ���� :");
		b.setAuthor(scan.nextLine());
		System.out.println();
		//ö�� ���� ��ȸ�� �ڿ����� ������� ���� ��� ���� ����
		System.out.println("�о� ����Ʈ");
		System.out.println("1.ö�� 2.���� 3.��ȸ�� 4.�ڿ�����");
		System.out.println("5.������� 6.���� 7.��� 8.���� 9.����");
		System.out.printf("���� �Էµ� �о� : %s%n",b.change_subject(b.getSubject()));
		System.out.print("�����Ͻ� �о� :");
		b.setSubject(scan.nextInt());
		System.out.println();
		System.out.printf("���� �Էµ� ���ǻ� : %s%n",b.getPublisher());
		System.out.print("�����Ͻ� ���ǻ� :");
		b.setPublisher(scan.nextLine());
		System.out.println();
	}

	//��ü�˻�
	@Override
	List searchAll() {
		// TODO Auto-generated method stub
		for(int i=0;i<bookList.size();i++) {
			System.out.println((Book)bookList.get(i));
		}
		return null;
	}

	//����
	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
