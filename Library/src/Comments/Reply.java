package Comments;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
	private String id;		//작성자 아이디
	private Date date;		//작성날짜
	private String title;	//건의사항 제목
	private String content;	//건의사항 내용
	
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
		return "<관리자>\t" + id + " (" + sdf.format(date) + ")\n\t[제목]:" + title + "\n"
				+ "\t[내용]:" + content;
	}
}
