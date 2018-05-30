package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookSubjectComparator implements Comparator<Book> {
	public int compare(Book b1, Book b2) {
		if(b1.getSubject() > b2.getSubject()) return 1;
		else if(b1.getSubject() < b2.getSubject()) return -1;
		else return 0;
	}
}
