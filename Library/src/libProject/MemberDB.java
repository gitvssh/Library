package libProject;

import java.util.*;

import Comparators.*;

public class MemberDB extends DB {
	List<Member> memberList;
	// ...
	Osystem osys = new Osystem();

	Scanner scanner = new Scanner(System.in);
	String id = "";
	String password = "";
	String name = "";
	String ssn = "";
	String tel = "";
	boolean status;

	// ....
	public MemberDB() {
		memberList = new ArrayList<>();
		this.memberList.add(new Member("java111", "1234", "���ڹ�", "991120", "01042326814", false));
		this.memberList.add(new Member("java222", "1234", "���ڹ�", "900110", "01063127891", true));
		this.memberList.add(new Member("java333", "1234", "���ڹ�", "880106", "01023268214", true));
		this.memberList.add(new Member("java444", "1234", "���ڹ�", "000813", "01032123819", false));
	}

	@Override
	List search(String search) {
		System.out.println("����������������������������������������������������������������������������������������������������������������������������");
		System.out.printf("   %-8s | %-12s | %-13s | %-21s | %-10s  %n", "ȸ��ID", "�̸�", "�������", "��ȭ��ȣ", "����");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().contains(search) || memberList.get(i).getName().contains(search)) {
				System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4b  %n", memberList.get(i).id,
						memberList.get(i).name, memberList.get(i).ssn, memberList.get(i).tel,
						memberList.get(i).idstatus);
			}
		}
		System.out.println("����������������������������������������������������������������������������������������������������������������������������");
		return null;
	}

	List adminsearch(String id) {

		int count = 0;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				System.out.printf("[%s]���� ������ �ҷ��Խ��ϴ�. �����Ͻ� �׸��� �������ּ���. %n", memberList.get(i).getId());
				osys.member_modify();
				update(memberList.get(i));
				count++;
				if (!(count == 0)) {
					System.out.printf("[%s]���� ���������� �Ϸ�Ǿ����ϴ�.%n", memberList.get(i).getId());
				} else {
					break;
				}
			} else {
				System.out.println("�Է��Ͻ� ���̵� ������ �����ϴ�.");
				break;
			}
		}

		return null;
	}

	@Override
	List searchAll() {
		System.out.println("����������������������������������������������������������������������������������������������������������������������������");
		System.out.printf("   %-8s | %-12s | %-13s | %-21s | %-10s  %n", "ȸ��ID", "�̸�", "�������", "��ȭ��ȣ", "����");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������");

		for (int i = 0; i < memberList.size(); i++) {
			System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4b  %n", memberList.get(i).id, memberList.get(i).name,
					memberList.get(i).ssn, memberList.get(i).tel, memberList.get(i).idstatus);
			System.out.println("����������������������������������������������������������������������������������������������������������������������������");
		}
		System.out.printf("  ȸ���� �� %s �� �Դϴ�.%n", memberList.size());
		return null;
	}

	void input() { // ȸ������ �޼���
		System.out.println("���̵� �Է����ּ���. 0:�����޴��� �̵�");
		String id = scanner.nextLine();
		while (true) {
			System.out.println("��й�ȣ�� �Է����ּ���.");
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

		Member m = new Member(id, password, name, ssn, tel, status);
		memberList.add(m);
		System.out.println("ȸ�������� �����߽��ϴ�.");
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	void update(Data data) { // ȸ�� ���� ���� �޼���
		Member m = (Member) data;
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1:
			System.out.println("�����Ͻ� ���̵� �Է����ּ���.");
			System.out.println("���� ���̵� : " + m.getId());
			m.setId(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ������ ���̵� : " + "[" + m.getId() + "]");
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
			System.out.println("���� �̸� : " + m.getName());
			m.setName(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ������ �̸� : " + "[" + m.getName() + "]");
			break;

		case 4:
			System.out.println("�����Ͻ� ������ϸ� �Է����ּ���.");
			System.out.println("���� ������� : " + m.getSsn());
			m.setSsn(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ������ ������� : " + "[" + m.getSsn() + "]");
			break;
		case 5:
			System.out.println("�����Ͻ� ��ȭ��ȣ�� �Է����ּ���.");
			System.out.println("���� ��ȭ��ȣ : " + m.getTel());
			m.setTel(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ������ ��ȭ��ȣ : " + "[" + m.getTel() + "]");
			break;
		case 0:
			System.out.println("����ȭ������ �̵��մϴ�.");
			break;
		}
		return;
	}

	void blackMem() {
		int count = 0;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).status == true) {
				count++;
				System.out.println(memberList.get(i).id + "/" + memberList.get(i).name + "/" + memberList.get(i).ssn
						+ "/" + memberList.get(i).tel + "/" + memberList.get(i).idstatus);
			}
		}
		System.out.println("�� " + count + "���� ȸ���� ������Ʈ�� �ֽ��ϴ�.");

	}

	void blackList() {

		Osystem osys = new Osystem();
		System.out.println("1.���� 2.�������� 3.�������� 0.����ȭ��");
		System.out.println("�޴��� �������ּ���.");
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1:
			while (true) {
				System.out.println("1.���̵� 2.�̸� 3.������� 4.��ȭ��ȣ 5.���� 0.����ȭ��");
				System.out.println("������ ���ϴ� �׸��� �������ּ���.");
				int input = scanner.nextInt();
				scanner.nextLine();
				switch (input) {
				case 1: // ���̵�
					MemberIdComparator cId = new MemberIdComparator();
					Collections.sort(memberList, cId);
					osys.showMemberList(memberList);
					continue;
				case 2: // �̸�
					MemberNameComparator cName = new MemberNameComparator();
					Collections.sort(memberList, cName);
					osys.showMemberList(memberList);
					continue;
				case 3: // �������
					MemberSsnComparator cSsn = new MemberSsnComparator();
					Collections.sort(memberList, cSsn);
					osys.showMemberList(memberList);
					continue;
				case 4: // ��ȭ��ȣ
					MemberTelComparator cTel = new MemberTelComparator();
					Collections.sort(memberList, cTel);
					osys.showMemberList(memberList);
					continue;
				case 5: // ����
					MemberIdStatusComparator cIdStatus = new MemberIdStatusComparator();
					Collections.sort(memberList, cIdStatus);
					osys.showMemberList(memberList);
					continue;
				case 0:
					MemberIdComparator c = new MemberIdComparator();
					Collections.sort(memberList, c);
					return;
				default:
					System.out.println("�߸��� �Է��Դϴ�.");
					continue;
				}
			}
		case 2:
			System.out.println("�����Ϸ��� ������ ���̵� �Է����ּ���. 0.����ȭ��");
			id = scanner.nextLine();
			if (id.equals("0")) {
				System.out.println("����ȭ������ �̵��մϴ�");
				break;
			}
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).id.equals(id)) {
					memberList.get(i).blackstatus = true;
				}
			}
			break;
		case 3:
			System.out.println("�����Ϸ��� ������ ���̵� �Է����ּ���. 0.����ȭ��");
			id = scanner.nextLine();
			if (id.equals("0")) {
				System.out.println("����ȭ������ �̵��մϴ�");
				break;
			}
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).id.equals(id)) {
					memberList.get(i).blackstatus = false;
				}
			}
			break;
		case 0:
			System.out.println("����ȭ������ �̵��մϴ�.");
			break;
		}
	}

	// ..
	Member Login(String id, String password) { // �α��� �޼���
		Member loginMem = null;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				if (memberList.get(i).getPassword().equals(password)) {
					System.out.println(memberList.get(i).getId() + "���� �α��� �ϼ̽��ϴ�.");
					System.out.println("ȸ�� �޴��� �̵��մϴ�.");
					loginMem = memberList.get(i);

				} else {
					System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
					break;
				}
			}

		}
		return loginMem;
	}

	void MemInform(Data data) { // ȸ�� ���� ���
		Member m = (Member) data;
		System.out.println("���̵� : " + m.getId());
		System.out.println("�̸� : " + m.getName());
		System.out.println("������� : " + m.getSsn());
		System.out.println("��ȭ��ȣ : " + m.getTel());
		System.out.println("�������� : " + m.getIdstatus());
		System.out.println("0.�����޴��� �̵�");
		System.out.print(">>");
		int menu = scanner.nextInt();
		scanner.nextLine();
		if (menu == 0) {
			System.out.println("�����޴��� �̵��մϴ�");
		}
	}

	void FindId() { // ���̵� ã��
		System.out.println("�̸��� �Է����ּ���");
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {

				System.out.println("��ȭ��ȣ�� �Է����ּ���");
				tel = scanner.nextLine();
				if (memberList.get(i).getTel().equals(tel)) {
					System.out.println("������ ���̵�� :" + memberList.get(i).getId() + "�Դϴ�.");
					break;
				} else {
					System.out.println("�߸��� ��ȭ��ȣ �Դϴ�.");
					break;
				}
			}
		}
	}

	void FindPw() { // ��й�ȣ ã��
		System.out.println("�̸��� �Է����ּ���"); // ���̵� �Է�
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {
				System.out.println("���̵� �Է����ּ���"); // �̸��Է�
				id = scanner.nextLine();
				if (memberList.get(i).getId().equals(id)) {
					System.out.println("��ȭ��ȣ�� �Է����ּ���"); // ��ȭ��ȣ �Է�
					tel = scanner.nextLine();
					if (memberList.get(i).getTel().equals(tel)) {
						System.out.println("�ش� ��ȣ�� ��й�ȣ�� �����Ͽ����ϴ�.");
					} else {
						System.out.println("�߸��� ��ȭ��ȣ �Դϴ�.");
						break;
					}
				} else {
					System.out.println("�߸��� �̸� �Դϴ�.");
					break;
				}
			}
		}
	}

	@Override
	void align() {
		System.out.println("");
		return;
	}
}
