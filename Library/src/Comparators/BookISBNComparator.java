package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookISBNComparator implements Comparator<Book> {
	@Override
	public int compare(Book b1, Book b2) {
		return b1.getIsbn().compareTo(b2.getIsbn());
	}
}
