package libProject;

import java.util.ArrayList;
import java.util.List;

public class MemberDB extends DB{
	List<Member> memberList;
	
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
		
	}

	@Override
	void update(Data data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	List searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}

}
