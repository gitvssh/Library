package Comments;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {	//건의사항 클래스
	private static int no;	//건의사항 번호
	private String id;		//작성자 아이디
	private Date date;		//작성날짜
	private String title;	//건의사항 제목
	private String content;	//건의사항 내용
	private Comment reply;	//관리자 답변
	
	public Comment(String id, Date date, String title, String content) {
		no++;	//건의사항이 추가되는 순서에 따라 번호부여.
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
		return no+".\t" + id + " (" + sdf.format(date) + ")\n\t[제목]:" + title + "\n"
				+ "\t[내용]:" + content;
	}

}
