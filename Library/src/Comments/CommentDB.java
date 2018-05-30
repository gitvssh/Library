package Comments;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import libProject.Member;

public class CommentDB {	//���ǻ��� DBŬ����
	ArrayList<Comment> commentList;	//���ǻ����� ����Ǵ� ����Ʈ
	
	public CommentDB() {	//DB��ü ������ ����Ʈ�� ��ü����.
		commentList = new ArrayList<>();
	}
	
	public ArrayList<Comment> searchComments(String id) {	//�Է� Ű����� �ش� ���̵��� ���ǻ����� �˻��ϴ� �޼���
		ArrayList<Comment> searchList = new ArrayList<>();	//�˻������ ��� ����Ʈ(����� ������ null ����)
		for(Comment comment:commentList) {	//�ش� Ű���带 �����ϴ� ���̵��� ���ǻ����� ����� ����Ʈ���� �˻�
			if(comment.getId().equals(id)) searchList.add(comment);
		}
		if(searchList.size()==0) return null;
		else return searchList;	//�˻���� ����
	}
	
	public void addComment(Member loginMem){	//�α����� ȸ�� ���ǻ����� �Է��ϴ� �޼���
		Scanner scan = new Scanner(System.in);
		String id = loginMem.getId();	//�α��� ȸ�� ���̵�
		Date date = new Date();	//���� ��¥ ��ü
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//���� ��¥�� �ش� �������� ������.
		
		System.out.printf("���̵�: %s (%s)\n", id, sdf.format(date));
		System.out.print("����: ");
		String title = scan.nextLine();
		System.out.println("[����]");
		String content = scan.nextLine();
		
		while(true) {	//����Ȯ��
			System.out.println("�ۼ��Ͻ� ������ �½��ϱ�? (Y/N)");
			String yn = scan.nextLine().toUpperCase().trim();
			if(yn.equals("Y")) {
				if(commentList.add(new Comment(id, date, title, content))) {
					System.out.println("���ǻ����� �߰��ƽ��ϴ�.");
					return;
				} else {
					System.out.println("�����߻�! ���ǻ����� �߰����� �ʾҽ��ϴ�.");
					return;
				}
			} else if(yn.equals("N")) {
				System.out.println("���ǻ��� �ۼ��� ��ҵƽ��ϴ�. ���� �������� ���ư��ϴ�.");
				return;
			} else {
				System.out.println("�߸��� �Է��Դϴ�!");
				continue;
			}
		}
	}
	
	public void showAllCommentList() {	//���ǻ����� ���� �����ִ� ����Ʈ
		for(Comment c:commentList) System.out.println(c);
	}
	
	public void showCommentList(ArrayList<Comment> searchList) {	//Ư�� ���ǻ��� ����Ʈ���� �����ִ� ����Ʈ
		for(Comment c:searchList) System.out.println(c);
	}
}
