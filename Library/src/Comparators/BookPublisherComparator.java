package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookPublisherComparator implements Comparator<Book> {
	@Override
	public int compare(Book b1, Book b2) {
		return b1.getPublisher().compareTo(b2.getPublisher());
	}
}
