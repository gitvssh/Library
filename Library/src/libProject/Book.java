package libProject;

public class Book implements Data{

	String index;//�ε����� �о�(ex ��. ��. ��.)+å����ī��Ʈ(1,2,...) ���ļ� ���ڿ��� ����
	String title;//����
	String author;//����
	int subject;//�о�, �оߴ� ���ڷ� �޵�, ī�忹�� 1,2,3,4�� spade,diamond�� �ٲ۰�ó�� ��.(ö��-1),��.(����-2)������ ��ȯ
	/*���ڷ� �޴� ������, ���߿� ��½� �پ��� ���·� ���(�ε��� ��,��,... �����˻��帣 ö��,����...)�� �Ǵµ�
	 *������ ��½� �ٸ����·� ��ȯ�ؾ� �� ��찡 ������, �Ű������� int�� �����ϸ� �˻��̳� ����, �޸𸮰������� ������ �� �� �ִٰ� ������
	 */
	
	String publisher;//���ǻ�
	int isbn;//isbn�� ī���ͷ� ��� ����, ���߿� �о߿� �����ؼ� �ε����� Ȱ��
	static int isbn_count=0;
	//�ν��Ͻ����� static���� ����
	/*isbn�̶�	
	*���� ǥ�� ���� ��ȣ(���������������, International Standard Book Number, ISBN)�� ���������� å�� ���̴� ������ �ĺ����̴�.
	*isbn��������� ������ ����� �ʹ� �����ϰ�, ������ �ĺ��ڰ� ī���Ϳ� �ǹ̰� �����ϴ� ī���ͷ� ����ϴ°� ���ƺ���
	*/
	boolean status;
	/*å�� ���´� db�� ������ �ִ���(1)�� ������(0)���� ����
	 * �ٸ� �������(0)�̰� �ݳ��Ⱓ�� �������ĸ� �˻��ؼ� ��ü������ ���
	 * �����Ⱑ�ɡ�, �������ߡ�, ����ü�ߡ�
	 */
	int rentCount;//����ȸ�� �����Ҷ����� ī��Ʈ �ǵ���
	//static���� �ν���Ʈ�� ����, static�� ��ü å�� ī��Ʈ�� �Ǳ⶧���� å ������ ������ �ȵ�
	
//	������(Desc) 
// ��ü�� �ν��Ͻ������� �޾Ƽ� ����ϴ°� ���߿� ����
	
	//�⺻������
	public Book() {
		
	}
	
	//�Ű����� ������
	public Book(String title, String author, int subject,String publisher) {
		isbn_count++;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.publisher = publisher;
		this.isbn = isbn_count;
		this.status = true;// �⺻ ������ ������ 1
		this.rentCount = 0; // �⺻ �뿩ȸ�� 0
	}
	
	//�ε��� ������ Ȱ��� ��.��.��. ��ȯ�޼���
	String change_subject(int subject) {
		switch(subject) {
		//ö�� ���� ��ȸ�� �ڿ����� ������� ���� ��� ���� ����
		case 1:
			return "��.";
		case 2:
			return "��.";
		case 3:
			return "��.";
		case 4:
			return "��.";
		case 5:
			return "��.";
		case 6:
			return "��.";
		case 7:
			return "��.";
		case 8:
			return "��.";
		case 9:
			return "��.";
		}
		return "�߸��� �Է��Դϴ�.";
	}
	
	//�о� ��½� Ȱ��� ����,ö��..��ȯ �޼���
	String change_subject2(int subject) {
		switch(subject) {
		//ö�� ���� ��ȸ�� �ڿ����� ������� ���� ��� ���� ����
		case 1:
			return "ö��";
		case 2:
			return "����";
		case 3:
			return "��ȸ��";
		case 4:
			return "�ڿ�����";
		case 5:
			return "�������";
		case 6:
			return "����";
		case 7:
			return "���";
		case 8:
			return "����";
		case 9:
			return "����";
		}
		return "�߸��� �Է��Դϴ�.";
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

	@Override
	public String toString() {
		return "Book [index=" + index + ", title=" + title + ", author=" + author + ", subject=" + subject
				+ ", publisher=" + publisher + ", isbn=" + isbn + "]";
	}

	
	
}
