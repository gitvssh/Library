package Comparators;

import java.util.Comparator;

import libProject.Book;

public class BookTitleComparator implements Comparator<Book>{//책의 제목순대로 오름차순 정렬하는 클래스

	@Override
	public int compare(Book b1, Book b2) {
		return b1.getTitle().compareTo(b2.getTitle());
	}
}
