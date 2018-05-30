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
		this.memberList.add(new Member("java111", "1234", "夢濠夥", "991120", "01042326814", false));
		this.memberList.add(new Member("java222", "1234", "梯濠夥", "900110", "01063127891", true));
		this.memberList.add(new Member("java333", "1234", "譆濠夥", "880106", "01023268214", true));
		this.memberList.add(new Member("java444", "1234", "檜濠夥", "000813", "01032123819", false));
	}

	@Override
	List search(String search) {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf("   %-8s | %-12s | %-13s | %-21s | %-10s  %n", "�蛾醼D", "檜葷", "儅喇錯橾", "瞪�食醽�", "鼻鷓");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().contains(search) || memberList.get(i).getName().contains(search)) {
				System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4b  %n", memberList.get(i).id,
						memberList.get(i).name, memberList.get(i).ssn, memberList.get(i).tel,
						memberList.get(i).idstatus);
			}
		}
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		return null;
	}
	
	List adminsearch(String id) {
		for(int i=0;i<memberList.size();i++) {
			if(memberList.get(i).getId().equals(id)) {
				osys.member_modify();
				
				update(memberList.get(i));
				System.out.printf("[%s]椒曖 薑爾熱薑檜 諫猿腎歷蝗棲棻.",memberList.get(i));
			}
		}
		
		
		return null;
	}

	@Override
	List searchAll() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf("   %-8s | %-12s | %-13s | %-21s | %-10s  %n", "�蛾醼D", "檜葷", "儅喇錯橾", "瞪�食醽�", "鼻鷓");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");

		for (int i = 0; i < memberList.size(); i++) {
			System.out.printf(" %-10s | %-10s | %-10s | %-14s | %-4b  %n", memberList.get(i).id, memberList.get(i).name,
					memberList.get(i).ssn, memberList.get(i).tel, memberList.get(i).idstatus);
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		}
		System.out.printf("  �蛾衋� 識 %s 貲 殮棲棻.%n", memberList.size());
		return null;
	}

	void input() { // �蛾灠㊣� 詭憮萄
		System.out.println("嬴檜蛤蒂 殮溘п輿撮蹂. 0:檜瞪詭景煎 檜翕");
		String id = scanner.nextLine();
		while (true) {
			System.out.println("綠塵廓�ㄧ� 殮溘п輿撮蹂.");
			password = scanner.nextLine();
			System.out.println("綠塵廓�ㄧ� и廓 渦 殮溘п輿撮蹂");
			String passright = scanner.nextLine();
			if (passright.equals(password)) {
				System.out.println("綠塵廓�ㄧ� �挫恉狤晾懂炴�.");
				break;
			} else {
				System.out.println("綠塵廓�ㄟ� ぎ溜蝗棲棻. 棻衛 殮溘п輿撮蹂.");
				continue;
			}
		}
		System.out.println("檜葷擊 殮溘п輿撮蹂.");
		name = scanner.nextLine();
		System.out.println("儅喇錯橾擊 殮溘п輿撮蹂.");
		ssn = scanner.nextLine();
		System.out.println("瞪�食醽ㄧ� 殮溘п輿撮蹂.");
		tel = scanner.nextLine();

		Member m = new Member(id, password, name, ssn, tel, status);
		memberList.add(m);
		System.out.println("�蛾灠㊣埬� 撩奢ц蝗棲棻.");
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	void update(Data data) { // �蛾� 薑爾 熱薑 詭憮萄
		Member m = (Member) data;
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1:
			System.out.println("熱薑ж褒 嬴檜蛤蒂 殮溘п輿撮蹂.");
			System.out.println("嬴檜蛤 : " + m.getId());
			m.setId(scanner.nextLine());
			System.out.println("熱薑腎樟蝗棲棻. 嬴檜蛤 : " + m.getId());
			break;
		case 2:
			while (true) {
				System.out.println("熱薑ж褒 綠塵廓�ㄧ� 殮溘п輿撮蹂.");
				m.setPassword(m.getPassword());
				System.out.println("綠塵廓�ㄧ� и廓 渦 殮溘п輿撮蹂");
				String passright = scanner.nextLine();
				if (passright.equals(m.getPassword())) {
					System.out.println("綠塵廓�ㄧ� �挫恉狤晾懂炴�.");
					break;
				} else {
					System.out.println("綠塵廓�ㄟ� ぎ溜蝗棲棻. 棻衛 殮溘п輿撮蹂.");
					continue;
				}
			}
			break;
		case 3:
			System.out.println("熱薑ж褒 檜葷擊 殮溘п輿撮蹂.");
			System.out.println("檜葷 : " + m.getName());
			m.setName(scanner.nextLine());
			System.out.println("熱薑腎樟蝗棲棻. 檜葷 : " + m.getName());
			break;

		case 4:
			System.out.println("熱薑ж褒 儅喇錯橾蒂 殮溘п輿撮蹂.");
			System.out.println("儅喇錯橾 : " + m.getSsn());
			m.setSsn(scanner.nextLine());
			System.out.println("熱薑腎樟蝗棲棻. 儅喇錯橾 : " + m.getSsn());
			break;
		case 5:
			System.out.println("熱薑ж褒 瞪�食醽ㄧ� 殮溘п輿撮蹂.");
			System.out.println("瞪�食醽� : " + m.getTel());
			m.setTel(scanner.nextLine());
			System.out.println("熱薑腎樟蝗棲棻. 瞪�食醽� : " + m.getTel());
			break;
		case 0:
			System.out.println("檜瞪�飛橉虞� 檜翕м棲棻.");
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
		System.out.println("識 " + count + "貲曖 �蛾衋� 綰楷葬蝶お縑 氈蝗棲棻.");

	}

	void blackList() {

		Osystem osys = new Osystem();
		System.out.println("1.薑溺 2.啗薑薑雖 3.啗薑犒掘 0.檜瞪�飛�");
		System.out.println("詭景蒂 摹鷗п輿撮蹂.");
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1:
			while (true) {
				System.out.println("1.嬴檜蛤 2.檜葷 3.儅喇錯橾 4.瞪�食醽� 5.鼻鷓 0.檜瞪�飛�");
				System.out.println("薑溺擊 錳ж朝 о跡擊 摹鷗п輿撮蹂.");
				int input = scanner.nextInt();
				scanner.nextLine();
				switch (input) {
				case 1: // 嬴檜蛤
					MemberIdComparator cId = new MemberIdComparator();
					Collections.sort(memberList, cId);
					osys.showMemberList(memberList);
					continue;
				case 2: // 檜葷
					MemberNameComparator cName = new MemberNameComparator();
					Collections.sort(memberList, cName);
					osys.showMemberList(memberList);
					continue;
				case 3: // 儅喇錯橾
					MemberSsnComparator cSsn = new MemberSsnComparator();
					Collections.sort(memberList, cSsn);
					osys.showMemberList(memberList);
					continue;
				case 4: // 瞪�食醽�
					MemberTelComparator cTel = new MemberTelComparator();
					Collections.sort(memberList, cTel);
					osys.showMemberList(memberList);
					continue;
				case 5: // 鼻鷓
					MemberIdStatusComparator cIdStatus = new MemberIdStatusComparator();
					Collections.sort(memberList, cIdStatus);
					osys.showMemberList(memberList);
					continue;
				case 0:
					MemberIdComparator c = new MemberIdComparator();
					Collections.sort(memberList, c);
					return;
				default:
					System.out.println("澀跤脹 殮溘殮棲棻.");
					continue;
				}
			}
		case 2:
			System.out.println("薑雖ж溥朝 啗薑曖 嬴檜蛤蒂 殮溘п輿撮蹂. 0.檜瞪�飛�");
			id = scanner.nextLine();
			if (id.equals("0")) {
				System.out.println("檜瞪�飛橉虞� 檜翕м棲棻");
				break;
			}
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).id.equals(id)) {
					memberList.get(i).blackstatus = true;
				}
			}
			break;
		case 3:
			System.out.println("犒掘ж溥朝 啗薑曖 嬴檜蛤蒂 殮溘п輿撮蹂. 0.檜瞪�飛�");
			id = scanner.nextLine();
			if (id.equals("0")) {
				System.out.println("檜瞪�飛橉虞� 檜翕м棲棻");
				break;
			}
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).id.equals(id)) {
					memberList.get(i).blackstatus = false;
				}
			}
			break;
		case 0:
			System.out.println("檜瞪�飛橉虞� 檜翕м棲棻.");
			break;
		}
	}

	// ..
	Member Login(String id, String password) { // 煎斜檣 詭憮萄
		Member loginMem = null;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				if (memberList.get(i).getPassword().equals(password)) {
					System.out.println(memberList.get(i).getId() + "椒檜 煎斜檣 ж樟蝗棲棻.");
					System.out.println("�蛾� 詭景煎 檜翕м棲棻.");
					loginMem = memberList.get(i);

				} else {
					System.out.println("綠塵廓�ㄧ� 澀跤 殮溘ж樟蝗棲棻. 棻衛 殮溘п輿撮蹂.");
					break;
				}
			}

		}
		return loginMem;
	}

	void MemInform(Data data) { // �蛾� 薑爾 轎溘
		Member m = (Member) data;
		System.out.println("嬴檜蛤 : " + m.getId());
		System.out.println("檜葷 : " + m.getName());
		System.out.println("儅喇錯橾 : " + m.getSsn());
		System.out.println("瞪�食醽� : " + m.getTel());
		System.out.println("啗薑鼻鷓 : " + m.getIdstatus());
		System.out.println("0.檜瞪詭景煎 檜翕");
		System.out.print(">>");
		int menu = scanner.nextInt();
		scanner.nextLine();
		if (menu == 0) {
			System.out.println("檜瞪詭景煎 檜翕м棲棻");
		}
	}

	void FindId() { // 嬴檜蛤 瓊晦
		System.out.println("檜葷擊 殮溘п輿撮蹂");
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {

				System.out.println("瞪�食醽ㄧ� 殮溘п輿撮蹂");
				tel = scanner.nextLine();
				if (memberList.get(i).getTel().equals(tel)) {
					System.out.println("敝ж曖 嬴檜蛤朝 :" + memberList.get(i).getId() + "殮棲棻.");
					break;
				} else {
					System.out.println("澀跤脹 瞪�食醽� 殮棲棻.");
					break;
				}
			}
		}
	}

	void FindPw() { // 綠塵廓�� 瓊晦
		System.out.println("檜葷蒂 殮溘п輿撮蹂"); // 嬴檜蛤 殮溘
		name = scanner.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(name)) {
				System.out.println("嬴檜蛤蒂 殮溘п輿撮蹂"); // 檜葷殮溘
				id = scanner.nextLine();
				if (memberList.get(i).getId().equals(id)) {
					System.out.println("瞪�食醽ㄧ� 殮溘п輿撮蹂"); // 瞪�食醽� 殮溘
					tel = scanner.nextLine();
					if (memberList.get(i).getTel().equals(tel)) {
						System.out.println("п渡 廓�ㄦ� 綠塵廓�ㄧ� 瞪歎ж艘蝗棲棻.");
					} else {
						System.out.println("澀跤脹 瞪�食醽� 殮棲棻.");
						break;
					}
				} else {
					System.out.println("澀跤脹 檜葷 殮棲棻.");
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
