package Comments;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {	//���ǻ��� Ŭ����
	private static int no;	//���ǻ��� ��ȣ
	private String id;		//�ۼ��� ���̵�
	private Date date;		//�ۼ���¥
	private String title;	//���ǻ��� ����
	private String content;	//���ǻ��� ����
	private Comment reply;	//������ �亯
	
	public Comment(String id, Date date, String title, String content) {
		no++;	//���ǻ����� �߰��Ǵ� ������ ���� ��ȣ�ο�.
		this.id = id;
		this.date = date;
		this.title = title;
		this.content = content;
	}
	
	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		Comment.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Comment getReply() {
		return reply;
	}

	public void setReply(Comment reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return no+".\t" + id + " (" + sdf.format(date) + ")\n\t[����]:" + title + "\n"
				+ "\t[����]:" + content;
	}

}
