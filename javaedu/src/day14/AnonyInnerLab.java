package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import day6.Book;

public class AnonyInnerLab {

	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<>();

		bookList.add(new Book("자바의 정석", "남궁성", 27000));
		bookList.add(new Book("챗GPT", "반병현", 11700));
		bookList.add(new Book("스타트 스프링 부트", "남가람", 27000));
		bookList.add(new Book("Doit! 자바프로그래밍", "박은중", 22500));
		bookList.add(new Book());

		for (Book b : bookList) {
			System.out.println(b.getBookInfo());
		}

		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book o1, Book o2) {
				return o1.getPrice() - o2.getPrice();
			}
		});

		System.out.println("[소팅 후]");
		for (Book b : bookList) {
			System.out.println(b.getBookInfo());
		}
	}
}
