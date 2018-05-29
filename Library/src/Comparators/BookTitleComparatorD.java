package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookTitleComparatorD implements Comparator<Book>{//책의 제목순대로 내림차순 정렬하는 클래스

	@Override
	public int compare(Book b1, Book b2) {
		return b2.getTitle().compareTo(b1.getTitle());
	}
}
