package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookISBNComparator implements Comparator<Book> {	//책을 ISBN 순으로 오름차순 정렬하는 클래스
	@Override
	public int compare(Book b1, Book b2) {
		if(b1.getIsbn() > b2.getIsbn()) return 1;
		else if(b1.getIsbn() < b2.getIsbn()) return -1;
		else return 0;
	}
}
