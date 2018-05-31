package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookTitleComparator implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		return b1.getTitle().compareTo(b2.getTitle());
	}
}
