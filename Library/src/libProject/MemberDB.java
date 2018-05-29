package libProject;

import java.util.*;

public class MemberDB extends DB {
	List<Member> memberList;
	// ...

	Scanner scanner = new Scanner(System.in);
	String id = "";
	String password = "";
	String name = "";
	String ssn = "";
	String tel = "";

	public MemberDB() {
		memberList = new ArrayList<>();
		Member b = new Member("java111", "88030490", "���ڹ�", "991120", "01042326814");
		memberList.add(b);
	}

	@Override
	List<Member> search(String str) {
		List<Member> searchList = new ArrayList<Member>();
		for (Member m : memberList) {
			if (m.getName().contains(str))
				searchList.add(m);
		}
		return searchList;
	}

	void input() { // ȸ������ �޼���
		System.out.println("���̵� �Է����ּ���");
		id = scanner.nextLine();
		while (true) {
			System.out.println("��й�ȣ�� �Է����ּ���");
			password = scanner.nextLine();
			System.out.println("��й�ȣ�� �ѹ� �� �Է����ּ���");
			String passright = scanner.nextLine();
			if (passright.equals(password)) {
				System.out.println("��й�ȣ�� Ȯ���Ͽ����ϴ�.");
				break;
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
		}
		System.out.println("�̸��� �Է����ּ���.");
		name = scanner.nextLine();
		System.out.println("��������� �Է����ּ���.");
		ssn = scanner.nextLine();
		System.out.println("��ȭ��ȣ�� �Է����ּ���.");
		tel = scanner.nextLine();

		Member m = new Member(id, password, name, ssn, tel);
		memberList.add(m);
		System.out.println("ȸ�������� �����߽��ϴ�.");
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	void update(Data data) { // ȸ�� ���� ���� �޼���
		Member m = (Member)data;
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
			case 1:
				System.out.println("�����Ͻ� ���̵� �Է����ּ���.");
				System.out.println("���̵� : " + m.getId());
				m.setId(scanner.nextLine());
				System.out.println("�����Ǽ̽��ϴ�. ���̵� : " + m.getId());
				break;
			case 2:
				while (true) {
					System.out.println("�����Ͻ� ��й�ȣ�� �Է����ּ���.");
					m.setPassword(m.getPassword());
					System.out.println("��й�ȣ�� �ѹ� �� �Է����ּ���");
					String passright = scanner.nextLine();
					if (passright.equals(m.getPassword())) {
						System.out.println("��й�ȣ�� Ȯ���Ͽ����ϴ�.");
						break;
					} else {
						System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.");
						continue;
					}
				}
				break;
			case 3:
				System.out.println("�����Ͻ� �̸��� �Է����ּ���.");
				System.out.println("�̸� : " + m.getName());
				m.setName(scanner.nextLine());
				System.out.println("�����Ǽ̽��ϴ�. �̸� : " + m.getName());
				break;
				
			case 4:
				System.out.println("�����Ͻ� ������ϸ� �Է����ּ���.");
				System.out.println("������� : " + m.getSsn());
				m.setSsn(scanner.nextLine());
				System.out.println("�����Ǽ̽��ϴ�. ������� : " + m.getSsn());
				break;
			case 5:
				System.out.println("�����Ͻ� ��ȭ��ȣ�� �Է����ּ���.");
				System.out.println("��ȭ��ȣ : " + m.getTel());
				m.setTel(scanner.nextLine());
				System.out.println("�����Ǽ̽��ϴ�. ��ȭ��ȣ : " + m.getTel());
				break;
			case 0:
				System.out.println("�����޴��� �̵��մϴ�.");
				break;
			}
			return;
		}
		

	Member Login(String id, String password) { // �α��� �޼���
		Member loginMem = null;

			
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).getId().equals(id)) {
					if (memberList.get(i).getPassword().equals(password)) {
						System.out.println(memberList.get(i).getId() + "���� �α��� �ϼ̽��ϴ�.");
						System.out.println("ȸ�� �޴��� �̵��մϴ�.");
						loginMem = memberList.get(i);
						break;
					} else {
						System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						break;
					}
				} else {
					System.out.println("�������� �ʴ� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
			}
			return loginMem;
		}
	

	void FindId() {
		System.out.println("�̸��� �Է����ּ���");
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {
				System.out.println("��������� �Է����ּ���");
				ssn = scanner.nextLine();
				if (memberList.get(i).getSsn().equals(ssn)) {
					System.out.println("��ȭ��ȣ�� �Է����ּ���");
					tel = scanner.nextLine();
					if (memberList.get(i).getTel().equals(tel)) {
						System.out.println("������ ���̵�� :" + memberList.get(i).getId() + "�Դϴ�.");
					}else {
						System.out.println("�߸��� ��ȭ��ȣ �Դϴ�.");
					}
				}else {
					System.out.println("�߸��� ������� �Դϴ�.");
				}
			}else {
				System.out.println("�������� �ʴ� ȸ���Դϴ�.");
		}
		}
	}
void FindPw() {
	System.out.println("���̵� �Է����ּ���");
	id = scanner.nextLine();
	for (int i = 0; i < memberList.size(); i++) {
		if (memberList.get(i).getName().equals(name)) {
			System.out.println("�̸��� �Է����ּ���");
			ssn = scanner.nextLine();
			if (memberList.get(i).getSsn().equals(ssn)) {
				System.out.println("��ȭ��ȣ�� �Է����ּ���");
				tel = scanner.nextLine();
				if (memberList.get(i).getTel().equals(tel)) {
					System.out.println("�ش� ��ȣ�� ��й�ȣ�� �����Ͽ����ϴ�.");
				}else {
					System.out.println("�߸��� ��ȭ��ȣ �Դϴ�.");
				}
			}else {
				System.out.println("�߸��� �̸� �Դϴ�.");
			}
		}else {
			System.out.println("�������� �ʴ� ȸ���Դϴ�.");
	}
	}
}
	@Override
	List<Member> searchAll() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println((Member) memberList.get(i));
		}
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}
}
