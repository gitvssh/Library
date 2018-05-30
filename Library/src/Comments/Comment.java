package Comments;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {	//���ǻ��� Ŭ����
	private int no;	//���ǻ��� ��ȣ
	private String id;		//�ۼ��� ���̵�
	private Date date;		//�ۼ���¥
	private String title;	//���ǻ��� ����
	private String content;	//���ǻ��� ����
	private Reply reply;	//������ �亯
	
	public Comment(int no, String id, Date date, String title, String content) {
		this.no = no;
		this.id = id;
		this.date = date;
		this.title = title;
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String print = no+".\t" + id + " (" + sdf.format(date) + ")\n\t[����]:" + title + "\n"
				+ "\t[����]:" + content+"\n";
		if(reply==null)
			return print;
		else
			return print+reply+"\n";
	}

}