package Comparators;

import java.util.Comparator;

import libProject.Member;

public class MemberIdStatusComparator implements Comparator<Member>{

	@Override
	public int compare(Member m1, Member m2) {
		return m1.getIdstatus().compareTo(m2.getIdstatus());
	}

}
