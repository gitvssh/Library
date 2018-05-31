package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookAuthorComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		return b1.getAuthor().compareTo(b2.getAuthor());
	}

}
