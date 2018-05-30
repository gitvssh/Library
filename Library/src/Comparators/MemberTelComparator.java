package Comparators;

import java.util.Comparator;

import libProject.Member;

public class MemberTelComparator implements Comparator<Member>{

	@Override
	public int compare(Member m1, Member m2) {
		return m1.getTel().compareTo(m2.getTel());
	}

}
