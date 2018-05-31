package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookRentCountComparator implements Comparator<Book>  {
	public int compare(Book b1, Book b2) {
		if(b1.getRentCount() > b2.getRentCount()) return 1;
		else if(b1.getRentCount() < b2.getRentCount()) return -1;
		else return 0;
	}
}
