package Comments;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import libProject.Admin;
import libProject.Member;

public class CommentDB {	//건의사항 DB클래스
	static int commentNo = 0;
	ArrayList<Comment> commentList;	//건의사항이 저장되는 리스트
	
	public CommentDB() {	//DB객체 생성시 리스트도 객체생성.
		commentList = new ArrayList<>();
	}
	
	public ArrayList<Comment> searchComments(String id) {	//입력 키워드로 해당 아이디의 건의사항을 검색하는 메서드
		ArrayList<Comment> searchList = new ArrayList<>();	//검색결과를 담는 리스트(결과가 없으면 null 리턴)
		for(Comment comment:commentList) {	//해당 키워드를 포함하는 아이디의 건의사항을 저장된 리스트에서 검색
			if(comment.getId().equals(id)) searchList.add(comment);
		}
		if(searchList.size()==0) return null;
		else return searchList;	//검색결과 리턴
	}
	
	public void replyComment(int no,ArrayList<Comment> searchList,Admin loginAdm) {
		for(Comment c:searchList) {
			if(c.getNo()==no) {
				System.out.println(c);
				while(true) {
					System.out.println("해당 건의사항에 답변을 작성하시겠습니까? (Y/N)");
					Scanner scan = new Scanner(System.in);
					String yn = scan.nextLine().toUpperCase().trim();
					
					if(yn.equals("Y")) {
						System.out.println("<관리자 답변>");
						String id = loginAdm.getId();	//로그인 회원 아이디
						Date date = new Date();	//현재 날짜 객체
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//현재 날짜를 해당 형식으로 포매팅.
						
						System.out.printf("아이디: %s (%s)\n", id, sdf.format(date));
						System.out.print("제목: ");
						String title = scan.nextLine();
						System.out.println("[내용]");
						String content = scan.nextLine();
						
						while(true) {	//내용확인
							System.out.println("작성하신 내용이 맞습니까? (Y/N)");
							yn = scan.nextLine().toUpperCase().trim();
							if(yn.equals("Y")) {
								c.setReply(new Reply(id, date, title, content));
								System.out.println("답변이 추가됐습니다.");
								return;
							} else if(yn.equals("N")) {
								System.out.println("답변 작성이 취소됐습니다. 이전 페이지로 돌아갑니다.");
								return;
							} else {
								System.out.println("잘못된 입력입니다!");
								continue;
							}
						}
					} else if (yn.equals("N")){
						System.out.println("답변 작성을 취소합니다.");
						return;
					} else {
						System.out.println("잘못된 입력입니다.");
						continue;
					}
				} //답변 while문
			}
		}	//검색 for문
		System.out.println("해당하는 번호가 없습니다.");
	}
	
	public void addComment(Member loginMem){	//로그인한 회원 건의사항을 입력하는 메서드
		Scanner scan = new Scanner(System.in);
		String id = loginMem.getId();	//로그인 회원 아이디
		Date date = new Date();	//현재 날짜 객체
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//현재 날짜를 해당 형식으로 포매팅.
		
		System.out.printf("아이디: %s (%s)\n", id, sdf.format(date));
		System.out.print("제목: ");
		String title = scan.nextLine();
		System.out.println("[내용]");
		String content = scan.nextLine();
		
		while(true) {	//내용확인
			System.out.println("작성하신 내용이 맞습니까? (Y/N)");
			String yn = scan.nextLine().toUpperCase().trim();
			if(yn.equals("Y")) {
				if(commentList.add(new Comment(++commentNo, id, date, title, content))) {
					System.out.println("건의사항이 추가됐습니다.");
					return;
				} else {
					System.out.println("에러발생! 건의사항이 추가되지 않았습니다.");
					return;
				}
			} else if(yn.equals("N")) {
				System.out.println("건의사항 작성이 취소됐습니다. 이전 페이지로 돌아갑니다.");
				return;
			} else {
				System.out.println("잘못된 입력입니다!");
				continue;
			}
		}
	}
	
	public void showAllCommentList() {	//건의사항을 전부 보여주는 리스트
		for(Comment c:commentList) System.out.println(c);
	}
	
	public void showCommentList(ArrayList<Comment> searchList) {	//특정 건의사항 리스트만을 보여주는 리스트
		for(Comment c:searchList) System.out.println(c);
	}
}
