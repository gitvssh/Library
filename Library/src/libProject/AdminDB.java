package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDB extends DB {

	List<Admin> adminList;

	Data input() {

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
		int ssn = sc.nextInt();
		sc.nextLine();
		System.out.println("��ȭ��ȣ�� �Է��Ͻÿ�. ������(-)�� �����Ͽ� �Է��ϼ���. ");
		int tel = sc.nextInt();
		sc.nextLine();
		Admin a = new Admin(id, password, name, ssn, tel);

		return a;
	}

	void insert(Admin admin) {
		adminList.add((Admin) admin);
	}

	@Override
	List search(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void insert(Data data) {
		// TODO Auto-generated method stub

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
		for (int i = 0; i < adminList.size(); i++) {
			System.out.println((Admin) adminList.get(i));
		}
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}

}
