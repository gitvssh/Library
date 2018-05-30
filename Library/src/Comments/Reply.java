package Comments;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
	private String id;		//�ۼ��� ���̵�
	private Date date;		//�ۼ���¥
	private String title;	//���ǻ��� ����
	private String content;	//���ǻ��� ����
	
	public Reply(String id, Date date, String title, String content) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.content = content;
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

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "<������>\t" + id + " (" + sdf.format(date) + ")\n\t[����]:" + title + "\n"
				+ "\t[����]:" + content;
	}
}
