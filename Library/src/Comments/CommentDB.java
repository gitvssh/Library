package Comments;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import libProject.Admin;
import libProject.Member;

public class CommentDB {	//���ǻ��� DBŬ����
	static int commentNo = 0;
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
	
	public void replyComment(int no,ArrayList<Comment> searchList,Admin loginAdm) {
		for(Comment c:searchList) {
			if(c.getNo()==no) {
				System.out.println(c);
				while(true) {
					System.out.println("�ش� ���ǻ��׿� �亯�� �ۼ��Ͻðڽ��ϱ�? (Y/N)");
					Scanner scan = new Scanner(System.in);
					String yn = scan.nextLine().toUpperCase().trim();
					
					if(yn.equals("Y")) {
						System.out.println("<������ �亯>");
						String id = loginAdm.getId();	//�α��� ȸ�� ���̵�
						Date date = new Date();	//���� ��¥ ��ü
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//���� ��¥�� �ش� �������� ������.
						
						System.out.printf("���̵�: %s (%s)\n", id, sdf.format(date));
						System.out.print("����: ");
						String title = scan.nextLine();
						System.out.println("[����]");
						String content = scan.nextLine();
						
						while(true) {	//����Ȯ��
							System.out.println("�ۼ��Ͻ� ������ �½��ϱ�? (Y/N)");
							yn = scan.nextLine().toUpperCase().trim();
							if(yn.equals("Y")) {
								c.setReply(new Reply(id, date, title, content));
								System.out.println("�亯�� �߰��ƽ��ϴ�.");
								return;
							} else if(yn.equals("N")) {
								System.out.println("�亯 �ۼ��� ��ҵƽ��ϴ�. ���� �������� ���ư��ϴ�.");
								return;
							} else {
								System.out.println("�߸��� �Է��Դϴ�!");
								continue;
							}
						}
					} else if (yn.equals("N")){
						System.out.println("�亯 �ۼ��� ����մϴ�.");
						return;
					} else {
						System.out.println("�߸��� �Է��Դϴ�.");
						continue;
					}
				} //�亯 while��
			}
		}	//�˻� for��
		System.out.println("�ش��ϴ� ��ȣ�� �����ϴ�.");
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
				if(commentList.add(new Comment(++commentNo, id, date, title, content))) {
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
