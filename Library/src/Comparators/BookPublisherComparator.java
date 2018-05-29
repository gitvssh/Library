package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookPublisherComparator implements Comparator<Book> {	//책을 출판사 순으로 오름차순 정렬하는 클래스
	@Override
	public int compare(Book b1, Book b2) {
		return b1.getPublisher().compareTo(b2.getPublisher());
	}
}
