package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookTitleComparatorD implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		return b2.getTitle().compareTo(b1.getTitle());
	}
}
