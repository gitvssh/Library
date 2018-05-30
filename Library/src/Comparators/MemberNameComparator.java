package Comparators;

import java.util.Comparator;
import libProject.Member;

public class MemberNameComparator implements Comparator<Member>{
	@Override
	public int compare(Member m1, Member m2) {
		// TODO Auto-generated method stub
		return m1.getName().compareTo(m2.getName());
	}
}
