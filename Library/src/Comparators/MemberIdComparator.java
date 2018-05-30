package Comparators;

import java.util.Comparator;

import libProject.Member;

public class MemberIdComparator implements Comparator<Member> {

	@Override
	public int compare(Member m1, Member m2) {
		return m1.getId().compareTo(m2.getId());
	}

}
