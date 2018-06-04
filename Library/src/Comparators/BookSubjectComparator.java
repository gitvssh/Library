package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookSubjectComparator implements Comparator<Book> {
	public int compare(Book b1, Book b2) {
		return b1.getSubject().compareTo(b2.getSubject()); 
	}
}
