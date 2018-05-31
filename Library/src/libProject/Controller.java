package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Comments.*;

public class Controller {

	public static void main(String[] args) {
		Osystem osys = new Osystem(); // ȭ����� ��ä��
		int menu;// ȭ�� �޴����ÿ� Ȱ���� �޴�
		int login = 0;// �α��� �˻�
		Scanner scan = new Scanner(System.in);// �޴� �Է½� ����� ��ĳ��

		Member loginMem = null; // �α����� ȸ���� ����� ����Ǵ� ����
		Admin loginAdm = null; // �α����� ������ ����� ����Ǵ� ����

		BookDB bookDB = new BookDB(); // å DB ��ü��
		MemberDB memberDB = new MemberDB(); // ȸ�� DB ��ü��
		AdminDB adminDB = new AdminDB(); // ���� DB ��ü��
		CommentDB commentDB = new CommentDB();	//���ǻ��� DB ��ü��

		// -----------------���ν���-----------------------
		main: while (true) {
			switch (login) {
			case 0:// ��ȸ�� 0
				observer: while (true) {// ----------------------��ȸ�� while-------------------
					osys.history("��ȸ��");//���丮(��ݱ��� ��� �޴� ǥ��)
					osys.observer_main();// ��ȸ�� ����ȭ��
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.�����˻� 2.ȸ���� 3.�α��� 4.���ڷα��� 5.���̵�/��й�ȣ ã��
					case 1:// 1.�����˻�
						osys.history("��ȸ��","�����˻�");
						osys.observer_search();// ��ȸ�� �����˻� ȭ��
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.��� 2.���� 3.���ǻ� 4.��� 5.�ε��� 6.ISBN 7.��ü ������� 0.����ȭ�����
						case 1:// ���
							osys.history("��ȸ��","�����˻�","���");
							System.out.println("�˻��Ͻ� ���� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 1));
							break;
						case 2:// ����
							osys.history("��ȸ��","�����˻�","����");
							System.out.println("�˻��Ͻ� ���ڸ� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 2));
							break;
						case 3:// ���ǻ�
							osys.history("��ȸ��","�����˻�","���ǻ�");
							System.out.println("�˻��Ͻ� ���ǻ縦 �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 3));
							break;
						case 4:// �о�
							osys.history("��ȸ��","�����˻�","�о�");
							System.out.println("�˻��Ͻ� �о߸� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 4));
							break;
						case 5:// �ε���
							osys.history("��ȸ��","�����˻�","�ε���");
							System.out.println("�˻��Ͻ� �ε����� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 5));
							break;
						case 6:// ISBN
							osys.history("��ȸ��","�����˻�","ISBN");
							osys.showBookList(bookDB.search(scan.nextLine(), 6));
							System.out.println("�˻��Ͻ� ISBN� �Է��ϼ���");
							break;
						case 7:// ��ü �������
							osys.history("��ȸ��","�����˻�","��ü ���� ���");
							System.out.println("��ü ���� ����Դϴ�.");
							bookDB.searchAll();
							continue observer;
						case 0:// ����ȭ�����
							System.out.println("����ȭ����� ���ư��ϴ�.");
							continue observer;
						}
						break;

					case 2:// ȸ����
						osys.history("��ȸ��","ȸ����");
						osys.observer_signin();// ȸ���� ȭ��
						memberDB.input();// ȸ���� �޼���
						break;
					case 3:// �α���
						osys.history("��ȸ��","�α���");
						System.out.println("���̵� �Է��ϼ���.");
						String id = scan.nextLine();
						if(id.equals("0")) {
							System.out.println("����ȭ����� �̵��մϴ�.");
							break;
						}
						System.out.println("��й�ȣ�� �Է��ϼ���.");
						String password = scan.nextLine();
						loginMem = memberDB.Login(id, password);// �α��� �޼���
						if (loginMem == null) {
							System.out.println("�α��ο� �����Ͽ���ϴ�. ���̵� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
							break;
						} else {
							login = 1;
						continue main;// ������� ������ �Ǻ�
						}
					case 4:// ���ڷα���
						osys.history("��ȸ��","���� �α���");
						System.out.println("���̵� �Է��ϼ���.");
						id = scan.nextLine();
						System.out.println("��й�ȣ�� �Է��ϼ���.");
						password = scan.nextLine();
						loginAdm = adminDB.login(id, password); // �α��� �޼���
						if (loginAdm == null) {
							System.out.println("�α��ο� �����Ͽ���ϴ�. ���̵� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
							break;
						} else {
							login = 2;
							continue main;
						}

					case 5:// ���̵� ��й�ȣã��
						osys.history("��ȸ��","���̵�/��й�ȣ ã��");
						osys.observer_findMember();// ���ã�� ȭ��
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1. ���̵� ã�� 2.��й�ȣ ã�� 0. ����ȭ��
						case 1:// ���̵� ã��
							osys.history("��ȸ��","���̵�/��й�ȣ ã��","���̵� ã��");
							osys.observer_findId();// ���̵�ã�� ȭ��
							memberDB.FindId();// ���̵� ã�� �޼���
							break;
						case 2:// ��й�ȣ ã��
							osys.history("��ȸ��","���̵�/��й�ȣ ã��","��й�ȣ ã��");
							osys.observer_findPass();// ��й�ȣã�� ȭ��
							memberDB.FindPw();// ��й�ȣ ã�� �޼��� -> ��й�ȣ�� ��ȣ�� ������Ƚ�ϴ�!
							break;
						case 0:// ����ȭ��
							System.out.println("����ȭ����� ���ư��ϴ�.");
							continue observer;
						}
						break;
					case 0:// ��α׷� ���
						System.out.println("��α׷�� ����մϴ�...");
						break main;
					}// end switch
				} // --------------------------��ȸ�� while end-----------------------
			case 1:// ȸ�� 1
				member: while (true) {
					osys.history(loginMem.getId());
					osys.member_main();
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.�����˻���� 2.����� 3.�����ݳ� 4.ȸ����� 5.���ǻ��� 9.�α׾ƿ� 0.���");
					case 1:// �����˻����
						osys.history(loginMem.getId(),"��������");
						osys.member_search();// ȸ�� �����˻�ȭ��
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.��� 2.���� 3.���ǻ� 4.�з� 5.�ε��� 6.ISBN 7.��ü ������� 0.����ȭ�����
						// �Ʒ��� �����ɵ� �߰�
						case 1:// ���
							osys.history(loginMem.getId(),"��������","���");
							System.out.println("�˻��Ͻ� ���� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 1));//�˻�޼���
							bookDB.rentBooks(bookDB, loginMem);//����޼���
							break;
						case 2:// ����
							osys.history(loginMem.getId(),"��������","����");
							System.out.println("�˻��Ͻ� ���ڸ� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 2));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 3:// ���ǻ�
							osys.history(loginMem.getId(),"��������","���ǻ�");
							System.out.println("�˻��Ͻ� ���ǻ縦 �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 3));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 4:// �о�
							osys.history(loginMem.getId(),"��������","�о�");
							System.out.println("�˻��Ͻ� �о߸� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 4));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 5:// �ε���
							osys.history(loginMem.getId(),"��������","�ε���");
							System.out.println("�˻��Ͻ� �ε����� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 5));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 6:// ISBN
							osys.history(loginMem.getId(),"��������","ISBN");
							System.out.println("�˻��Ͻ� ISBN� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 6));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 7:// ��ü �������
							osys.history(loginMem.getId(),"��������","��ü �������");
							System.out.println("��ü ��������Դϴ�.");
							bookDB.searchAll();
							continue member;
						case 0:// ����ȭ�����
							System.out.println("����ȭ����� ���ư��ϴ�.");
							continue member;
						}// end switch
						continue member;
					case 2:// �����
						osys.history(loginMem.getId(),"�� ����");
						osys.showBookList(loginMem.getRentList());	// ����� ��� �޼���
						while(true) {
							System.out.println("0.���� ȭ��");
							if (scan.nextInt()==0) continue member;
							else continue;	//�� ���� �ȸ ������ ȸ�� �޴���.
						}
					case 3:// �����ݳ�
						osys.history(loginMem.getId(),"���� �ݳ�");
						bookDB.returnBooks(loginMem.getRentList());	// �����ݳ� �޼���
						continue member;	//�ݳ� ������ ȸ�� �޴���.
					case 4:// ȸ�����
						osys.history(loginMem.getId(),"ȸ�����");
						osys.member_inform();
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.ȸ����� �ȸ 2.ȸ����� ��� 0. ����ȭ��
						case 1:// ȸ����� �ȸ
							osys.history(loginMem.getId(),"ȸ�����","ȸ������ȸ");
							osys.member_myinform();// ȸ����� �ȸ ȭ��
							break;
							// ȸ����� �ȸ �޼���
						case 2:// ȸ����� ���1.���̵� 2.��й�ȣ 3.�̸� 4.������ 5.��ȭ��ȣ 0.ȸ��޴��� �̵�
							osys.history(loginMem.getId(),"ȸ�����","ȸ����� ���");
							osys.member_modify();// ȸ����� ��� ȭ��
							modify: while (true) {
								memberDB.update(loginMem);
								break;
								}// end switch_modify
							 // end while modify;
						case 0:// ����ȭ��
							System.out.println("����ȭ����� ���ư��ϴ�.");
							continue member;
						}// end switch ȸ������޴�
					case 5:// ���ǻ���
						comment:while(true) {
							osys.history(loginMem.getId(),"���ǻ���");
							osys.member_request();
							menu = scan.nextInt(); // ���ǻ��� �޼���
							switch(menu) {
							case 1: //1.�� ���ǻ��� �Է�
								osys.history(loginMem.getId(),"���ǻ���","1.�� ���ǻ��� �Է�");
								commentDB.addComment(loginMem);
								continue comment;
							case 2: //2.���� ���ǻ��� ����
								osys.history(loginMem.getId(),"���ǻ���","2.���� ���ǻ��� ����");
								//ȸ�� ���̵�� �ۼ��� ���ǻ���� �˻��� ����Ʈ�� �ޱ�
								ArrayList<Comment> searchList = commentDB.searchComments(loginMem.getId());
								//�˻��� ����� ����Ʈ�� �Ű������ ���� ���ǻ��׵�� ���
								if(searchList!=null) {
									int page = 1;
									commentDB.showPages(page,searchList);
									while(true) {
										System.out.println("1.���� ������  2.��� ������  0.���� ȭ��");
										menu = scan.nextInt();
										scan.nextLine();
										if(menu==0) continue comment;	//0� �Է¹���� ���ǻ��� �޴���.
										if(menu==1) page = commentDB.showPages(--page,searchList); 
										else if(menu==2) page = commentDB.showPages(++page,searchList);
										else System.out.println("�߸�� �Է�!");
									}
								} else {
									System.out.println("��ϵ� ���ǻ����� ���ϴ�.");
									continue comment;
								}
							case 0: //0.ȸ��޴��� �̵� 
								System.out.println("����ȭ����� ���ư��ϴ�.");
								continue member;
							}
						}
					case 9:// �α׾ƿ�
						while(true) {
							osys.history(loginMem.getId(),"�α׾ƿ�");
							System.out.println("�α׾ƿ�� �Ͻðڽ�ϱ�? y/n");
							String out = scan.nextLine();
							if(out.equals("y")) {
								System.out.println("�α׾ƿ� �Ǿ��ϴ�.");
								login = 0;
								break;
							}else if(out.equals("n")) {
								System.out.println("�α׾ƿ��� ��ҵǾ��ϴ�.");
								login = 1;
								break;
								}else {
								System.out.println("�߸��Է��ϼ̽�ϴ�.");
								continue;
							}
						}
						continue main;// ������� ������ �Ǻ�
					case 0:// ���
						System.out.println("��α׷�� ����մϴ�...");
						break main;
					}// end switch
				} // -----------------------------ȸ�� while end-----------------------
			case 2:// ���� 2
				admin: while (true) {
					osys.history(loginAdm.getId());
					osys.admin_main();// ���� ����ȭ��
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.������ 2. ȸ��� 3.���ǻ��� 4.���� �� 5.�α׾ƿ� 0.�ý��� ���
					case 1:// ������
						bookmng: while (true) {// ������޴� while
							Book selected = null;//���� ���,����� ��� ������� 
							osys.history(loginAdm.getId(),"������");
							osys.admin_bookmng();
							menu = scan.nextInt();
							scan.nextLine();
							switch (menu) {// 1.�����˻� 2.�����߰� 3.������� 4.������� 0.���� ȭ�����
							case 1:// �����˻�
								osys.history(loginAdm.getId(),"������","�����˻�");
								osys.admin_search();
								menu = scan.nextInt();
								scan.nextLine();
								switch (menu) {// 1.��� 2.���� 3.���ǻ� 4.��� 5.�ε��� 6.ISBN 7.��ü ������� 0.����ȭ�����
								case 1:// ���
									osys.history(loginAdm.getId(),"������","�����˻�","���");
									System.out.println("�˻��Ͻ� ���� �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 1));
									break;
								case 2:// ����
									osys.history(loginAdm.getId(),"������","�����˻�","����");
									System.out.println("�˻��Ͻ� ���ڸ� �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 2));
									break;
								case 3:// ���ǻ�
									osys.history(loginAdm.getId(),"������","�����˻�","���ǻ�");
									System.out.println("�˻��Ͻ� ���ǻ縦 �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 3));
									break;
								case 4:// �о�
									osys.history(loginAdm.getId(),"������","�����˻�","�о�");
									System.out.println("�˻��Ͻ� �о߸� �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 4));
									break;
								case 5:// �ε���
									osys.history(loginAdm.getId(),"������","�����˻�","�ε���");
									System.out.println("�˻��Ͻ� �ε����� �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 5));
									break;
								case 6:// ISBN
									osys.history(loginAdm.getId(),"������","�����˻�","ISBN");
									osys.showBookList(bookDB.search(scan.nextLine(), 6));
									System.out.println("�˻��Ͻ� ISBN� �Է��ϼ���");
									break;
								case 7:// ��ü �������
									osys.history(loginAdm.getId(),"������","�����˻�","��ü �������");
									System.out.println("��ü ���� ����Դϴ�.");
									bookDB.searchAll();
									continue admin;
								case 0:// ����ȭ�����
									System.out.println("����ȭ����� ���ư��ϴ�.");
									continue admin;
								}
								break;
							case 2:// �����߰�
								osys.history(loginAdm.getId(),"������","�����߰�");
								osys.admin_addbook();
								bookDB.input();
								break;
							case 3:// �������
								osys.history(loginAdm.getId(),"������","�������");
								osys.admin_modifybook();
								selected = bookDB.adminsearch(bookDB);
								if(selected==null) {
								}
								else {
								bookDB.update(selected);
								}
								break;
							case 4:// �������
								osys.history(loginAdm.getId(),"������","�������");
								osys.admin_delbook();
								selected = bookDB.adminsearch(bookDB);
								if(selected==null) {
								}
								else {
								bookDB.delete(selected);
								}
								break;
							case 0:// ����ȭ��
								System.out.println("����ȭ����� ���ư��ϴ�.");
								break bookmng;
							}
						} // end while_bookmng
					case 2:// ȸ���
						osys.history(loginAdm.getId(),"ȸ���");
						osys.admin_membermng();
						menu = scan.nextInt();
						scan.nextLine();


						membermng: while (true) {// ȸ���޴� while
							switch (menu) {// 1.ȸ��˻� 2.��üȸ���� 3.������Ʈ 0.����ȭ��
							case 1:// ȸ��˻�
								osys.history(loginAdm.getId(),"ȸ���","ȸ��˻�");

								osys.admin_findmem();
								String id=scan.nextLine();
								memberDB.search(id);
								break;
							case 2:// ��üȸ����
								osys.history(loginAdm.getId(),"ȸ���","��ü ȸ����");
									memberDB.searchAll();// ��üȸ�� ��� �޼���
								break;
							case 3:// ������Ʈ
								osys.history(loginAdm.getId(), "ȸ���", "������Ʈ");
								System.out.println("������Ʈ ȸ�����Դϴ�.");
								memberDB.blackList();
								break;
							case 0:// ����ȭ��
								System.out.println("����ȭ����� ���ư��ϴ�.");
								break membermng;
							}// end switch_membermng
						}
					case 3:// ���ǻ���
							// ���ǻ��� ��� �޼���(db)
						osys.history(loginAdm.getId(),"���ǻ���");
						System.out.println("1.�˻�	2.�亯	0.����ȭ��");
						menu = scan.nextInt();
						scan.nextLine();
						request: while (true) {// ȸ���޴� while
							switch (menu) {
							case 1:// �˻�
								osys.history(loginAdm.getId(),"���ǻ���","�˻�");
								System.out.println("�˻��Ͻð��� �ϴ� ���ǻ����� ���̵� �Է����ּ���.(0� ���� ȭ��)");
								System.out.print("���̵�: ");
								String searchId = scan.nextLine();
								if(searchId.equals("0")) continue admin;
								
								ArrayList<Comment> searchList = commentDB.searchComments(searchId);
								
								if(searchList!=null) {
									int page = 1;
									commentDB.showPages(page,searchList);
									while(true) {
										System.out.println("1.���� ������  2.��� ������  0.���� ȭ��");
										int subMenu = scan.nextInt();
										scan.nextLine();
										if(subMenu==0) continue request;	//0� �Է¹���� ���ǻ��� �޴���.
										if(subMenu==1) page = commentDB.showPages(--page,searchList); 
										else if(subMenu==2) page = commentDB.showPages(++page,searchList);
										else System.out.println("�߸�� �Է�!");
									}
								} else {
									System.out.println("��ϵ� ���ǻ����� ���ϴ�.");
									continue request;
								}
							case 2:// �亯
								osys.history(loginAdm.getId(),"���ǻ���","�亯");
								System.out.println("�亯�Ͻð��� �ϴ� ���ǻ����� ���̵� �Է����ּ���. (0� ���� ȭ��)");
								searchId = scan.nextLine();
								if(searchId.equals("0")) continue admin;
								
								searchList = commentDB.searchComments(searchId);
								
								if(searchList!=null) {
									commentDB.showCommentList(searchList);
									
									System.out.println("�亯�Ͻð��� �ϴ� ���ǻ����� ��ȣ�� �Է����ּ���.");
									System.out.print("��ȣ: ");
									
									int searchNo = scan.nextInt();
									scan.nextLine();
									commentDB.replyComment(searchNo,searchList,loginAdm);
									continue request;
								} else {
									System.out.println("��ϵ� ���ǻ����� ���ϴ�.");
									continue request;
								}
							case 0:// ����ȭ��
								System.out.println("����ȭ����� ���ư��ϴ�.");
								break request;
							}// end switch
						} // end while_request
					case 4:// ���� ��
						osys.history(loginAdm.getId(),"���� ��");
						osys.admin_admng();
						menu = scan.nextInt();
						scan.nextLine();
						admng: while (true) {// ���ڰ�޴� while
							switch (menu) {// 1.���� �˻� 2.��ü ���� ��� 3.�� ���� ��� 0.����ȭ��
							case 1:// ���� �˻�
								osys.history(loginAdm.getId(),"���� ��","���� �˻�");
								System.out.println("�˻��� ���� ���̵� Ȥ� �̸�� �Է����ּ���.");
								String searchAdminId = scan.nextLine();
								adminDB.search(searchAdminId);// ���� �˻� �޼���
								break admng;
							case 2:// ��ü ���� ���
								osys.history(loginAdm.getId(),"���� ��","��ü ���� ���");
								adminDB.searchAll();// ��ü ���� ��� ��� �޼���
								break admng;
							case 3:// �� ���� ���
								osys.history(loginAdm.getId(),"���� ��","�� ���� ���");
								osys.admin_newad();// y or n
								String menu2 = scan.nextLine();
								newadm: while (true) {
									if (menu2.equalsIgnoreCase("y")) {
										adminDB.input();// ���� �߰� �޼���
										break newadm;
									} else  {
										System.out.println("���� ��ȭ����� ���ư��ϴ�.");
										break admng;
									} 
								} // end while_newadm
							case 0:// ����ȭ��
								System.out.println("����ȭ����� ���ư��ϴ�.");
								break admng;
							}// end switch
						} // end while_request
					case 5:// �α׾ƿ�
						while(true) {// �α׾ƿ� �޼���
							osys.history(loginMem.getId(),"�α׾ƿ�");
							System.out.println("�α׾ƿ�� �Ͻðڽ�ϱ�? y/n");
							String out = scan.nextLine();
							if(out.equals("y")) {
								System.out.println("�α׾ƿ� �Ǿ��ϴ�.");
								login = 0;
								break;
							}else if(out.equals("n")) {
								System.out.println("�α׾ƿ��� ��ҵǾ��ϴ�.");
								login = 2;
								break;
								}else {
								System.out.println("�߸��Է��ϼ̽�ϴ�.");
								continue;
							}
						}
						continue main;// ������� ������ �Ǻ�
					case 0:// ���
						System.out.println("��α׷�� ����մϴ�...");
						break main;
					}
				} // --------------------------------���� while end-------------------------
			}// end switch_login
		} // end while_main

	}// end main

}// end class