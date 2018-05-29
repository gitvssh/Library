package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDB extends DB {
	// 2018.05.28 18:10pm.
	List<Admin> adminList;

	AdminDB() {
		adminList = new ArrayList<>();
		Admin a = new Admin("admin1", "1234", "������", "921002", "01012341234");
		adminList.add(a);
	}

	void input() {

		Scanner sc = new Scanner(System.in);
		System.out.println("���ο� �����ڸ� ����մϴ�.");
		System.out.println();
		System.out.println("���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		System.out.println("�н����带 �Է��ϼ���.");
		String password = sc.nextLine();
		while (true) { // �н����� Ȯ���ϴ� ����
			System.out.println("�н����带 �ٽ� �ѹ� �Է��ϼ���.");
			String password2 = sc.nextLine();
			if (!(password.equals(password2))) {
				System.out.println("�н����尡 ��ġ���� �ʽ��ϴ�.");
				continue;
			} else {
				break;
			}
		}
		System.out.println("�̸��� �Է����ּ���.");
		String name = sc.nextLine();
		System.out.println("��������� �Է��ϼ���. ex)92��10��2�ϻ��Ͻ� -> '921002'");
		String ssn = sc.nextLine();
		System.out.println("��ȭ��ȣ�� �Է��Ͻÿ�. ������(-)�� �����Ͽ� �Է��ϼ���. ");
		String tel = sc.nextLine();
		Admin a = new Admin(id, password, name, ssn, tel);
		adminList.add(a);

		System.out.println("���������� �����ڰ� ����������ϴ�.");
	}

	Admin login(String id, String password) {
		// adminList.get(int i).g

		Admin loginAdm = null;

		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getId().equals(id) && adminList.get(i).getPassword().equals(password)) {
				System.out.printf("[%s] �������� �α��� �մϴ�.%n[%s]�� ȯ���մϴ�.", adminList.get(i).getId(),
						adminList.get(i).getName());
				loginAdm = adminList.get(i);
				break;
			}

		}
		return loginAdm;
	}

	@Override
	List search(String search) {
		System.out.println("������������������������������������������������������������������������");
		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getId().contains(search) || adminList.get(i).getName().contains(search)) {
				System.out.printf("���̵�: %-10s �̸�: %-4s  ��ȭ��ȣ: %11s %n", adminList.get(i).getId(),
						adminList.get(i).getName(),  adminList.get(i).getTel());
				System.out.println("������������������������������������������������������������������������");
				Scanner sc= new Scanner(System.in);
				System.out.println("��й�ȣ�� ���� �����Ͻðڽ��ϱ�?(Y/N)");
				String yes = sc.nextLine();
				if(yes.equals("y")) {
					System.out.println("��������� �Է����ּ���.");
					String birth = sc.nextLine();
					if(birth.equals(adminList.get(i).getSsn())){
						System.out.println("Ȯ�εǾ����ϴ�. ���ο� ��й�ȣ�� �������ּ���.");
						String newpw = sc.nextLine();
							System.out.println("��й�ȣ ������ �Ϸ�Ǿ����ϴ�.");
							adminList.get(i).setPassword(newpw);
							break;
					} else {
						System.out.println("��������� �ٸ��ϴ�.");
						break;
					}
				} else { System.out.println("�޴�����ȭ������ ���ư��ϴ�.");
					break;}
			}
		}
		
		return null;
	}

	void repassword(String ssn) {
		
	
	}
	
	@Override
	void delete(Data data) {
		// TODO Auto-generated method stub

	}

	@Override
	void update(Data data) {
		// TODO Auto-generated method stub

	}

	@Override
	List searchAll() {
		System.out.println("��������������������������������������������������������������������");
		System.out.println("�����ڸ� ��ü ��ȸ�մϴ�.	                                   ");
		for (int i = 0; i < adminList.size(); i++) {
			System.out.printf("���̵�: %-10s �̸�: %-4s  ��ȭ��ȣ: %11s %n", adminList.get(i).getId(),
					adminList.get(i).getName(), adminList.get(i).getTel());
		}
		System.out.println("��������������������������������������������������������������������");
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}

}