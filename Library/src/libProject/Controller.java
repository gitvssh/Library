package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		Osystem osys = new Osystem(); // ȭ����� ��ä����
		int menu;// ȭ�� �޴����ÿ� Ȱ���� �޴�
		int login = 0;// �α��� �˻�
		Scanner scan = new Scanner(System.in);// �޴� �Է½� ����� ��ĳ��

		Member loginMem = null; // �α����� ȸ���� ������ ����Ǵ� ����
		Admin loginAdm = null; // �α����� �������� ������ ����Ǵ� ����

		BookDB bookDB = new BookDB(); // å DB ��ü����
		MemberDB memberDB = new MemberDB(); // ȸ�� DB ��ü����
		AdminDB adminDB = new AdminDB(); // ������ DB ��ü����

		/*
		 * BookDB bookDB = new BookDB(); // å DB ��ü����
		 * 
		 * // bookDB.insert(new Book("����� ��ȭ1")); //å DB�� å ��ü���� // bookDB.insert(new
		 * Book("����� ��ȭ2")); // bookDB.insert(new Book("����� ��ȭ3")); List<Book>
		 * searchBooks = bookDB.search("����� ��ȭ"); // å DB���� å �˻�
		 * 
		 * for (Book b : searchBooks) { System.out.println(b.title); } // å �˻� ��� ���
		 * System.out.println("---------------------------------");
		 * 
		 * MemberDB memberDB = new MemberDB(); // ȸ�� DB ��ü����
		 * 
		 * // memberDB.insert(new Member("���ڹ�")); // ȸ�� DB ��ü���� // memberDB.insert(new
		 * Member("���ڹ�")); // memberDB.insert(new Member("���ڹ�")); List<Member>
		 * searchMembers = memberDB.search("�ڹ�"); // ȸ�� DB ��ü����
		 * 
		 * AdminDB adminDB = new AdminDB(); // ������ DB ��ü����
		 * 
		 * new Admin("admin1", "1234", "������", "921002", "01012341234"); //������ ����
		 * 
		 * for (Member m : searchMembers) { System.out.println(m.getName()); } // ȸ�� DB
		 * ��ü����
		 */
		// -----------------���ν���-----------------------
		main: while (true) {
			switch (login) {
			case 0:// ��ȸ�� 0
				observer: while (true) {// ----------------------��ȸ�� while-------------------
					osys.observer_main();// ��ȸ�� ����ȭ��
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.�����˻� 2.ȸ������ 3.�α��� 4.�����ڷα��� 5.���̵�/��й�ȣ ã��
					case 1:// 1.�����˻�
						osys.observer_search();// ��ȸ�� �����˻� ȭ��
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.���� 2.���� 3.���ǻ� 4.���� 5.�ε��� 6.ISBN 7.��ü ������� 0.����ȭ������
						case 1:// ����
							System.out.println("�˻��Ͻ� ������ �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 1));
							break;
						case 2:// ����
							System.out.println("�˻��Ͻ� ���ڸ� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 2));
							break;
						case 3:// ���ǻ�
							System.out.println("�˻��Ͻ� ���ǻ縦 �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 3));
							break;
						case 4:// �о�
							System.out.println("�˻��Ͻ� �о߸� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 4));
							break;
						case 5:// �ε���
							System.out.println("�˻��Ͻ� �ε����� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 5));
							break;
						case 6:// ISBN
							osys.showBookList(bookDB.search(scan.nextLine(), 6));
							System.out.println("�˻��Ͻ� ISBN�� �Է��ϼ���");
							break;
						case 7:// ��ü �������
							System.out.println("��ü ���� ����Դϴ�.");
							bookDB.searchAll();
							bookDB.align();
							break;
						case 0:// ����ȭ������
							System.out.println("����ȭ������ ���ư��ϴ�.");
							continue observer;
						}
						break;

					case 2:// ȸ������
						osys.observer_signin();// ȸ������ ȭ��
						memberDB.input();// ȸ������ �޼���
						break;
					case 3:// �α���
						System.out.println("���̵� �Է��ϼ���.");
						String id = scan.nextLine();
						if(id.equals("0")) {
							System.out.println("����ȭ������ �̵��մϴ�.");
							break;
						}
						System.out.println("��й�ȣ�� �Է��ϼ���.");
						String password = scan.nextLine();
						loginMem = memberDB.Login(id, password);// �α��� �޼���
						if (loginMem == null) {
							System.out.println("�α��ο� �����Ͽ����ϴ�. ���̵� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
							break;
						} else {
							login = 1;
						continue main;// �������� ������ �Ǻ�
						}
					case 4:// �����ڷα���
						System.out.println("���̵� �Է��ϼ���.");
						id = scan.nextLine();
						System.out.println("��й�ȣ�� �Է��ϼ���.");
						password = scan.nextLine();
						loginAdm = adminDB.login(id, password); // �α��� �޼���
						if (loginAdm == null) {
							System.out.println("�α��ο� �����Ͽ����ϴ�. ���̵� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
							break;
						} else {
							login = 2;
							continue main;
						}

					case 5:// ���̵� ��й�ȣã��
						osys.observer_findMember();// ����ã�� ȭ��
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1. ���̵� ã�� 2.��й�ȣ ã�� 0. ����ȭ��
						case 1:// ���̵� ã��
							osys.observer_findId();// ���̵�ã�� ȭ��
							memberDB.FindId();// ���̵� ã�� �޼���
							break;
						case 2:// ��й�ȣ ã��
							osys.observer_findPass();// ��й�ȣã�� ȭ��
							memberDB.FindPw();// ��й�ȣ ã�� �޼��� -> ��й�ȣ�� ��ȣ�� ������Ƚ��ϴ�!
							break;
						case 0:// ����ȭ��
							System.out.println("����ȭ������ ���ư��ϴ�.");
							continue observer;
						}
						break;
					case 0:// ���α׷� ����
						System.out.println("���α׷��� �����մϴ�...");
						break main;
					}// end switch
				} // --------------------------��ȸ�� while end-----------------------
			case 1:// ȸ�� 1
				member: while (true) {
					osys.member_main();
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.�����˻����� 2.�������� 3.�����ݳ� 4.ȸ������ 5.���ǻ��� 9.�α׾ƿ� 0.����");
					case 1:// �����˻�����
						osys.member_search();// ȸ�� �����˻�ȭ��
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.���� 2.���� 3.���ǻ� 4.�з� 5.�ε��� 6.ISBN 7.��ü ������� 0.����ȭ������
						// �Ʒ��� �����ɵ� �߰�
						case 1:// ����
							System.out.println("�˻��Ͻ� ������ �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 1));//�˻��޼���
							bookDB.rentBooks(bookDB, loginMem);//����޼���
							break;
						case 2:// ����
							System.out.println("�˻��Ͻ� ���ڸ� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 2));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 3:// ���ǻ�
							System.out.println("�˻��Ͻ� ���ǻ縦 �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 3));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 4:// �о�
							System.out.println("�˻��Ͻ� �о߸� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 4));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 5:// �ε���
							System.out.println("�˻��Ͻ� �ε����� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 5));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 6:// ISBN
							System.out.println("�˻��Ͻ� ISBN�� �Է��ϼ���");
							osys.showBookList(bookDB.search(scan.nextLine(), 6));
							bookDB.rentBooks(bookDB, loginMem);
							break;
						case 7:// ��ü �������
							System.out.println("��ü ���� ����Դϴ�.");
							bookDB.searchAll();
							break;
						case 0:// ����ȭ������
							System.out.println("����ȭ������ ���ư��ϴ�.");
							continue member;
						}// end switch
						break;
					case 2:// ��������
							// �������� ��� �޼���
						break;
					case 3:// �����ݳ�
							// �������� ��� �޼���
							// �����ݳ� �޼���
						break;
					case 4:// ȸ������
						osys.member_inform();
						menu = scan.nextInt();
						scan.nextLine();
						switch (menu) {// 1.ȸ������ ��ȸ 2.ȸ������ ���� 0. ����ȭ��
						case 1:// ȸ������ ��ȸ
							osys.member_myinform();// ȸ������ ��ȸ ȭ��
							break;
							// ȸ������ ��ȸ �޼���
						case 2:// ȸ������ ����1.���̵� 2.��й�ȣ 3.�̸� 4.������� 5.��ȭ��ȣ 0.ȸ���޴��� �̵�
							osys.member_modify();// ȸ������ ���� ȭ��
							modify: while (true) {
								memberDB.update(loginMem);
								break;
								}// end switch_modify
							 // end while modify;
						case 0:// ����ȭ��
							System.out.println("����ȭ������ ���ư��ϴ�.");
							continue member;
						}// end switch ȸ�������޴�
					case 5:// ���ǻ���
						osys.member_request();
						// ���ǻ��� �޼���
						break;
					case 9:// �α׾ƿ�
							// �α׾ƿ� �޼���
						continue main;// �������� ������ �Ǻ�
					case 0:// ����
						System.out.println("���α׷��� �����մϴ�...");
						break main;
					}// end switch
					break;
				} // -----------------------------ȸ�� while end-----------------------
			case 2:// ������ 2
				admin: while (true) {
					osys.admin_main();// ������ ����ȭ��
					menu = scan.nextInt();
					scan.nextLine();
					switch (menu) {// 1.�������� 2. ȸ������ 3.���ǻ��� 4.������ ���� 5.�α׾ƿ� 0.�ý��� ����
					case 1:// ��������
						Book selected = null;//���� ����,������ ���� ��������
						osys.admin_bookmng();
						menu = scan.nextInt();
						scan.nextLine();
						bookmng: while (true) {// ���������޴� while
							switch (menu) {// 1.�����˻� 2.�����߰� 3.�������� 4.�������� 0.���� ȭ������
							case 1:// �����˻�
								osys.admin_search();
								menu = scan.nextInt();
								scan.nextLine();
								switch (menu) {// 1.���� 2.���� 3.���ǻ� 4.���� 5.�ε��� 6.ISBN 7.��ü ������� 0.����ȭ������
								case 1:// ����
									System.out.println("�˻��Ͻ� ������ �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 1));
									break;
								case 2:// ����
									System.out.println("�˻��Ͻ� ���ڸ� �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 2));
									break;
								case 3:// ���ǻ�
									System.out.println("�˻��Ͻ� ���ǻ縦 �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 3));
									break;
								case 4:// �о�
									System.out.println("�˻��Ͻ� �о߸� �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 4));
									break;
								case 5:// �ε���
									System.out.println("�˻��Ͻ� �ε����� �Է��ϼ���");
									osys.showBookList(bookDB.search(scan.nextLine(), 5));
									break;
								case 6:// ISBN
									osys.showBookList(bookDB.search(scan.nextLine(), 6));
									System.out.println("�˻��Ͻ� ISBN�� �Է��ϼ���");
									break;
								case 7:// ��ü �������
									System.out.println("��ü ���� ����Դϴ�.");
									bookDB.searchAll();
									bookDB.align();
									break;
								case 0:// ����ȭ������
									System.out.println("����ȭ������ ���ư��ϴ�.");
									continue admin;
								}
								break;
							case 2:// �����߰�
								osys.admin_addbook();
								bookDB.input();
								break;
							case 3:// ��������
								osys.admin_modifybook();
								selected = bookDB.adminsearch(bookDB);
								bookDB.update(selected);
								break;
							case 4:// ��������
								osys.admin_delbook();
								selected = bookDB.adminsearch(bookDB);
								bookDB.delete(selected);
								break;
							case 0:// ����ȭ��
								System.out.println("����ȭ������ ���ư��ϴ�.");
								break bookmng;
							}
						} // end while_bookmng
					case 2:// ȸ������
						osys.admin_membermng();
						menu = scan.nextInt();
						scan.nextLine();
						membermng: while (true) {// ȸ�������޴� while
							switch (menu) {// 1.ȸ���˻� 2.��üȸ����� 3.������Ʈ 0.����ȭ��
							case 1:// ȸ���˻�
								osys.admin_findmem();
								break;
							case 2:// ��üȸ�����
									// ��üȸ�� ��� �޼���
								break;
							case 3:// ������Ʈ
									// ������Ʈ ��� �޼���
								break;
							case 0:// ����ȭ��
								System.out.println("����ȭ������ ���ư��ϴ�.");
								break membermng;
							}// end switch_membermng
						}
					case 3:// ���ǻ���
							// ���ǻ��� ��� �޼���(db)
						System.out.println("1.�˻�	2.�亯	0.����ȭ��");
						menu = scan.nextInt();
						scan.nextLine();
						request: while (true) {// ȸ�������޴� while
							switch (menu) {
							case 1:// �˻�
								break;
							case 2:// �亯
								break;
							case 0:// ����ȭ��
								System.out.println("����ȭ������ ���ư��ϴ�.");
								break request;
							}// end switch
						} // end while_request
					case 4:// ������ ����
						osys.admin_admng();
						menu = scan.nextInt();
						scan.nextLine();
						admng: while (true) {// �����ڰ����޴� while
							switch (menu) {// 1.������ �˻� 2.��ü ������ ��� 3.�� ������ ��� 0.����ȭ��
							case 1:// ������ �˻�
								System.out.println("�˻��� ������ ���̵� Ȥ�� �̸��� �Է����ּ���.");
								String searchAdminId = scan.nextLine();
								adminDB.search(searchAdminId);// ������ �˻� �޼���
								break admng;
							case 2:// ��ü ������ ���
								adminDB.searchAll();// ��ü ������ ��� ��� �޼���
								break admng;
							case 3:// �� ������ ���
								osys.admin_newad();// y or n
								String menu2 = scan.nextLine();
								newadm: while (true) {
									if (menu2.equalsIgnoreCase("y")) {
										adminDB.input();// ������ �߰� �޼���
										break newadm;
									} else  {
										System.out.println("������ ����ȭ������ ���ư��ϴ�.");
										break admng;
									} 
								} // end while_newadm
							case 0:// ����ȭ��
								System.out.println("����ȭ������ ���ư��ϴ�.");
								break admng;
							}// end switch
						} // end while_request
					case 5:// �α׾ƿ�
							// �α׾ƿ� �޼���
						continue main;// �������� ������ �Ǻ�
					case 0:// ����
						System.out.println("���α׷��� �����մϴ�...");
						break main;
					}
					break;
				} // --------------------------------������ while end-------------------------
			}// end switch_login
		} // end while_main

	}// end main

}// end class