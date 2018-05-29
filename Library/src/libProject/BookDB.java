package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDB extends DB{
	List<Book> bookList;
	
	//�˻�, ��ü�˻�, ���� �̿ϼ�, toString �԰ݿ� �°� ����
	
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
		
		List search(String string, int std) {
			List<Book> searchList = new ArrayList<Book>();
			switch(std) {//1.���� 2.���� 3.���ǻ� 4.���� 5.�ε��� 6.ISBN 7.��ü ������� 
			case 1:	//����
			for(Book b:bookList) {
				if(b.title.contains(string)) searchList.add(b);
			}
			return searchList;
			case 2://����
				for(Book b:bookList) {
					if(b.author.contains(string)) searchList.add(b);
				}
				return searchList;
			case 3://���ǻ�
				for(Book b:bookList) {
					if(b.publisher.contains(string)) searchList.add(b);
				}
				return searchList;
			case 4://�о�
				for(Book b:bookList) {
					if(b.subject==Integer.parseInt(string)) searchList.add(b);
				}
				return searchList;
			case 5://�ε���
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

	//���� �ڷ� �Է¹ް� ����, �����͹�ȯ
	void input() {
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
		Book.isbn_count++;//å �Ϸù�ȣ(ī��Ʈ)+1
		b.isbn = Book.isbn_count;//�Ϸù�ȣ �ε��� ����
		b.setIndex(b.change_subject(subject)+b.isbn);//�о� + isbn -> �ε���
		bookList.add(b);
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

	Book rentBooks(String index){//å����
		Book book = null;
		//���� å ã��
		//������ �������� ����Ʈ <- å ��ü
		//å <- ������ ��ü
		return book;
	}
	
	boolean returnBooks(String index){//å�ݳ�
		boolean result=false;
		//�ε����� �޾Ƽ� å �ݳ�
		//������ true, ������ false.
		return result;
	}
}
