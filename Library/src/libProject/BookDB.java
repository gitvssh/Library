package libProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Comments.Comment;
import Comparators.*;

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
					if(b.isbn.contains(string)) searchList.add(b);
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
		scan.nextLine();
		System.out.println();
		System.out.print("���ǻ� :");
		publisher = scan.nextLine();
		System.out.println();
		Book b = new Book(title,author,subject,publisher); 
		Book.isbn_count++;//å �Ϸù�ȣ(ī��Ʈ)+1
		b.setIndex(b.change_subject(subject)+b.isbn);//�о� + isbn -> �ε���
		bookList.add(b);
		System.out.println("��������� �Ϸ�Ǿ����ϴ�.");
	}

	//����
	@Override
	void delete(Data data) {
		Book b = (Book)data;//get,set�̿��� ���� ����ȯ
		System.out.println(b.getTitle()+"��/�� �����˴ϴ�.");
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
		System.out.printf("���� �Էµ� �о� : %s%n",b.change_subject2(b.getSubject()));
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
	List searchAll() {	//å ��ü ����Ʈ ��� �޼���
		Osystem osys = new Osystem();
		osys.showBookList(bookList);	//��ü ����Ʈ �ܼ����
		align();	//å ���� �޼��� ȣ�� -> align()���� std�� 0�� �Է����� �ʴ� �� ����ؼ� ȣ��Ǵ� �Ϳ� �ָ�.
		return null;
	}

	//����
	@Override
	void align() {	//å ���� �޼���(å ���� ����Ʈ ������ �ε��� ��.)
		Osystem osys = new Osystem();	
		
		while(true) {	//�ݺ��� while - �߸��� �Է¹߻��� �ٽ� �Է°����ϰ� ������.
			osys.observer_align();	//���ĸ޴� �ܼ� ���(0�� ����ȭ��)
			Scanner scan = new Scanner(System.in);
			int std = scan.nextInt();	//���ı���(std) �Է� �ޱ�.
			scan.nextLine();
			
			switch(std) {	//std�� ���� å ����
			case 1:	//����
				//å ��������� �������� ���Ľ����ִ� Comparator��ü(��Ȯ�ϰԴ� ������ü) ����.
				BookTitleComparator cTitle = new BookTitleComparator();
				Collections.sort(bookList, cTitle);	//å DB�� ��� å ��ü�� ����� ����.
				osys.showBookList(bookList);	//���ĵ� å ����Ʈ�� ����ϱ� ���� ��ü ����Ʈ ��� �޼��� ȣ��(���!).
				continue;
			case 2:	//����
				//���� ������ �������� ���Ľ����ִ� Comparator��ü.
				BookAuthorComparator cAuthor = new BookAuthorComparator();
				Collections.sort(bookList, cAuthor);	//å DB�� ���� �� ����.
				osys.showBookList(bookList);	//��ü ����Ʈ ��� �޼��� ȣ��(���!).
				continue;
			case 3:	//���ǻ�
				//���ǻ� ������ �������� ���Ľ����ִ� Comparator��ü.
				BookPublisherComparator cPublisher = new BookPublisherComparator();
				Collections.sort(bookList, cPublisher);	//å DB�� ���ǻ� �� ����.
				osys.showBookList(bookList);	//��ü ����Ʈ ��� �޼��� ȣ��(���!).
				continue;
			case 4:	//����
				//���� ������ �������� ���Ľ����ִ� Comparator��ü.
				BookSubjectComparator cSubject = new BookSubjectComparator();
				Collections.sort(bookList, cSubject);	//å DB�� ���� �� ����.
				osys.showBookList(bookList);	//��ü ����Ʈ ��� �޼��� ȣ��(���!).
				continue;
			case 5:	//�ε���
				//�ε��� ������ �������� ���Ľ����ִ� Comparator��ü.
				BookIndexComparator cIndex = new BookIndexComparator();
				Collections.sort(bookList, cIndex);	//å DB�� �ε��� �� ����.
				osys.showBookList(bookList);	//��ü ����Ʈ ��� �޼��� ȣ��(���!).
				continue;
			case 6:	//ISBN
				//ISBN ������ �������� ���Ľ����ִ� Comparator��ü.
				BookISBNComparator cISBN = new BookISBNComparator();
				Collections.sort(bookList, cISBN);	//å DB�� �ε��� �� ����.
				osys.showBookList(bookList);	//��ü ����Ʈ ��� �޼��� ȣ��(���!).
				continue;
			case 0: //����ȭ�� - �ڷ� ���� ���� �ݵ�� å ����� �ε��� ��(����Ʈ!)���� ����
				BookIndexComparator c = new BookIndexComparator();
				Collections.sort(bookList, c);
				return;
			default: //�߸��� �Է�
				System.out.println("�߸��� �Է��Դϴ�!");
				continue;	//���� �Է� �ٽ� ����.
			}
		}
	}
	
	Book adminsearch(BookDB bookDB) {
		Scanner scan = new Scanner(System.in);
		Book selected = null;//�������⿡ �ʿ��� ����īƮ ��������
		check: while (true) {
			String rent = scan.nextLine();
			if (rent.length() != 7) {//7�ڸ� �ƴҰ�� ����ó��
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
			else if(rent.equals("0")){//����ȭ�� ����ó��
				System.out.println("����ȭ������ ���ư��ϴ�.");
				break check;
			}
			else {//�����Է��ϰ��
				String index = rent.substring(2, 7);//�ε��� ����
				System.out.println(index);
				for(Book b:bookDB.bookList) {
					if(b.isbn.equals(index)&&b.status==true) {//�˻���� Ȯ��,���Ȯ��
						System.out.println("�����Ͻ� ������ "+b.title+"�Դϴ�.");
						selected = b;//������ ���� ���ÿ� ���
						return selected;
					}
					else {//��� ���ų�, �߸��� �Է��� ���
						System.out.println("���ð����� ������ �����ϴ�.");
						break;
					}
				}
				
			}//�ε��� �˻� ��
		}
		return selected;
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
				String index = rent.substring(2, 7);//�ε��� ����
				for(Book b:bookDB.bookList) {
					if(b.isbn.equals(index)&&b.status==true) {//�˻���� Ȯ��,���Ȯ��
						System.out.println("�����Ͻ� ������ "+b.title+"�Դϴ�.");
						rentcart = b;//������ ���� ����īƮ�� ���
						break;
					}
					else {//��� ���ų�, �߸��� �Է��� ���
						System.out.println("���Ⱑ�� ������ �����ϴ�.");
						return;
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
				loginMem.rentList.add(rentcart);//������ ����īƮ�� ������ å �߰�
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
	
	void returnBooks(List<Book> rentList){//å�ݳ� �޼���
		if(rentList==null || rentList.size()==0) {	//������ å�� ���� ���(���⸮��Ʈ�� null�̰ų� ���̰� 0)
			System.out.println("�����Ͻ� å�� �����ϴ�.");
			return;	//�޼��� ����
		}
		
		returnB:while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("�ݳ��Ͻ� å�� �ε����� �Է����ּ���.(0�� ���� ȭ��)");
			System.out.print("�ε���: ");
			String returnI = scan.nextLine();	//�ε��� �Է��� ����
			
			if(returnI.equals("0")) break;	//0�� �޼��� ����
			
			for(Book b:rentList) {	//�Է� �ε����� ��ġ�ϴ� ���� ���� �˻�
				if(rentList==null || rentList.size()==0) {
					System.out.println("�ݳ��Ϸ�!");
					return;
				}
				
				if(b.getIndex().equals(returnI)) {	//�Է� �ε����� ��ġ�ϴ� ������ ã���� ���
					if(rentList.remove(b)) {	//���� ����Ʈ���� �ش� å ����
						b.setStatus(true);		//���� ������ �ش� ������ ���¸� "���Ⱑ��"���� �ٲٰ�
						System.out.println(b.getTitle()+"(��)�� �ݳ��߽��ϴ�.");	//���� �޽��� ���
						continue returnB;	//�ٽ� �ε��� �Է� â���� ���ư�
					} else {	//���� ����Ʈ���� å�� ���ŵ��� ���� �� ��ɾ�
						System.out.println("�ݳ�����! ���� ȭ������ ���ư��ϴ�.");
						continue returnB;
					}
				}
			}
			System.out.println("���� ���� �� �ش� �ε����� ������ �������� �ʽ��ϴ�.");	//if���� �ɸ��� ���� ���, �ش絵���� ����.
		}
		//�ε����� �޾Ƽ� å �ݳ�
		//������ true, ������ false.
	}
	
	public void showPages(int page) {//��ü ������ ��� ���������� �����ֱ�(�Ű������� �˻��ϰ��� �ϴ� ������)
		int totalPages = (int)Math.ceil(bookList.size()/10.);
		
		if(page<1 || page>totalPages) {
			System.out.println("������ ����!");
			if(page<1) page=1;
			else page = totalPages;
			return;
		}
		
		for(int i=(page-1)*10; i<page*10; i++) {
			System.out.println(bookList.get(i));
		}
		System.out.println("���� "+page+"������/"+totalPages+"������");
	}
	
	public void showPages(int page, List<Book> searchList) {//�˻��� ������ ��� ���������� �����ֱ�(�Ű� ����Ʈ�� �˻� ����Ʈ)
		int totalPages = (int)Math.ceil(searchList.size()/10.);
		
		if(page<1 || page>totalPages) {
			System.out.println("������ ����!");
			if(page<1) page=1;
			else page = totalPages;
			return;
		}
		
		for(int i=(page-1)*10; i<page*10; i++) {
			System.out.println(searchList.get(i));
		}
		System.out.println("���� "+page+"������/"+totalPages+"������");
	}
}
