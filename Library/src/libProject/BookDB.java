package libProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Comparators.BookTitleComparator;

public class BookDB extends DB{
	List<Book> bookList;
	
	//�˻�, ��ü�˻�, ���� �̿ϼ�, toString �԰ݿ� �°� ����
	
	public BookDB() {
		this.bookList = new ArrayList();
		this.bookList.add(new Book("������ ����","�佴Ÿ�ΰ��ƴ� ",1,"���ϻ�"));
		this.bookList.add(new Book("����, ����","����",2,"�迵��"));
		this.bookList.add(new Book("�����׽�źƮ ����","���� ����",3,"��������"));
		this.bookList.add(new Book("��, ���ǰ���","������",4,"������Ͽ콺"));
		this.bookList.add(new Book("�ż������","������",5,"�������ǻ�"));
		this.bookList.add(new Book("�����̼�, ���ø��׸���","ȫ��ǥ",6,"�������"));
		this.bookList.add(new Book("������ ����","���۰�",7,"������ ����"));
		this.bookList.add(new Book("����� ��ȭ","���� �罺����",8,"ȫ���̵��"));
		this.bookList.add(new Book("���","Ƽ�ӽ� �����̴�",9,"����å��"));
		this.bookList.add(new Book("�µ�, ����� ����","������",9,"�����ۺ�"));
//		System.out.println("1.ö�� 2.���� 3.��ȸ�� 4.�ڿ�����");
//		System.out.println("5.������� 6.���� 7.��� 8.���� 9.����");
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
			System.out.println(bookList.get(i));
		}
		return null;
	}

	//����
	@Override
	List align() {
		BookTitleComparator c = new BookTitleComparator();
		Collections.sort(bookList, c);
		return bookList;
	}

	void rentBooks(BookDB bookDB,Member loginMem){//å����
		Scanner scan = new Scanner(System.in);
		Book rentcart = null;//�������⿡ �ʿ��� ����īƮ ��������
		rentcheck: while (true) {
			System.out.println("������ ���ϴ� ������ �ε����� �Է����ּ���.(7�ڸ�)(0.����ȭ��)");
			String rent = scan.nextLine();
			if (rent.length() != 7) {//7�ڸ� �ƴҰ�� ����ó��
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
			else if(rent.equals("0")){//����ȭ�� ����ó��
				System.out.println("����ȭ������ ���ư��ϴ�.");
				break rentcheck;
			}
			else {//�����Է��ϰ��
				int index = Integer.parseInt(rent.substring(2, 6));//�ε��� ����
				for(Book b:bookDB.bookList) {
					if(b.isbn==index&&b.status==true) {//�˻���� Ȯ��,���Ȯ��
						System.out.println("�����Ͻ� ������ "+b.title+"�Դϴ�.");
						rentcart = b;//������ ���� ����īƮ�� ���
						break;
					}
					else {//��� ���ų�, �߸��� �Է��� ���
						System.out.println("���Ⱑ�� ������ �����ϴ�.");
						break;
					}
				}
				
			}//�ε��� �˻� ��
			break;
		} // end while_rentcheck
			// ����Ȯ��----------------------------------------------------
		System.out.println("å�� �����Ͻðڽ��ϱ�? Y/N");
		String menu2 = scan.nextLine();
		rentbook: while (true) {
			if (menu2.equalsIgnoreCase("y")) {
				rentcart.setStatus(false);//���⵵�� ���� ������
				rentcart.setRenter(loginMem);//���⵵���� ������ ���
				rentcart.setRentCount(rentcart.getRentCount()+1);//����Ƚ�� ����
				//�α��θ���� rentcart �߰�
				System.out.println("���������� ����Ǿ����ϴ�.");
				break rentbook;
			} else if (menu2.equalsIgnoreCase("n")) {
				System.out.println("�����˻�ȭ������ ���ư��ϴ�.");
				break rentbook;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		} // end while_rentbook;
			// ����Ȯ�γ�---------------------------------------------------
	}
	
	boolean returnBooks(String index){//å�ݳ�
		boolean result=false;
		//�ε����� �޾Ƽ� å �ݳ�
		//������ true, ������ false.
		return result;
	}
}
