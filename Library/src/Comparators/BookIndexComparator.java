package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookIndexComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		return b1.getIndex().compareTo(b2.getIndex());
	}

}
