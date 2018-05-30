package Comparators;

import java.util.Comparator;

import libProject.Member;

public class MemberSsnComparator implements Comparator<Member> {

	@Override
	public int compare(Member m1, Member m2) {
		return m1.getSsn().compareTo(m2.getSsn());
	}

}
