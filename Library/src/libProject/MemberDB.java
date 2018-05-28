package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Member;
import java.util.*;
public class MemberDB extends DB{
	List<Member> memberList;
	//...
	
	Scanner scanner = new Scanner(System.in);
	String id = "";
	String password = "";
	String name = "";
	String ssn = "";
	String tel = "";
	public MemberDB() {
		memberList = new ArrayList<>();
	}

	@Override
	List search(String str) {
		List<Member> searchList = new ArrayList<Member>();
		for(Member m:memberList) {
			if(m.name.contains(str)) searchList.add(m);
		}
		return searchList;
	}

	@Override
	void insert(Data data) {
		memberList.add((Member)data);
	}

	@Override
	void delete(Data data) {
		Member m = (Member)data;
		memberList.remove(m);
	}

	@Override
	void update(Data data) {
		Member m = (Member)data;
		System.out.println("������ ���Ͻô� �׸��� �Է����ּ���");
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch(menu) {
		case 1:
			System.out.println("�����Ͻ� ���̵� �Է����ּ���.");
			System.out.println("���̵� : "+m.getId());
			m.setId(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ���̵� : "+m.getId());
			break;
		case 2:
			System.out.println("�����Ͻ� ��й�ȣ�� �Է����ּ���.");
			m.setPassword(getPassword());
			System.out.println("��й�ȣ�� �ѹ� �� �Է����ּ���");
			String passright = scanner.nextLine();
			while(true) {
				if(passright.equals(m.getPassword())){
					System.out.println("��й�ȣ�� Ȯ���Ͽ����ϴ�.");
					break;
				}
				else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
			}
			break;
		case 3:
			System.out.println("�����Ͻ� �̸��� �Է����ּ���.");
			System.out.println("�̸� : "+m.getName());
			m.setName(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. �̸� : "+m.getName());
			break;
			
		case 4:
			System.out.println("�����Ͻ� ������ϸ� �Է����ּ���.");
			System.out.println("������� : "+m.getSsn());
			m.setSsn(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ������� : "+m.getSsn());
			break;
		case 5:
			System.out.println("�����Ͻ� ��ȭ��ȣ�� �Է����ּ���.");
			System.out.println("��ȭ��ȣ : "+m.getTel());
			m.setTel(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ��ȭ��ȣ : "+m.getTel());
			break;
		case 0:
			break;
		}
	}

	@Override
	List searchAll() {
		for(int i=0;i<memberList.size();i++) {
			System.out.println((Member)memberList.get(i));
		}
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}
Data input() {
	System.out.println("���̵� �Է����ּ���");
	id = scanner.nextLine();
	System.out.println("��й�ȣ�� �Է����ּ���");
	password = scanner.nextLine();
	System.out.println("��й�ȣ�� �ѹ� �� �Է����ּ���");
	String passright = scanner.nextLine();
	while(true) {
		if(passright.equals(password)){
			System.out.println("��й�ȣ�� Ȯ���Ͽ����ϴ�.");
			break;
		}
		else {
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
	return m;
}
}
