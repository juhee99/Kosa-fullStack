package day6;

public class Book {
	String title;
	String author;
	private int price;
	
	public  Book(){
		this("이것이 자바다","신용권,임경균",36000);
	}
	
	public Book(String title, String author, int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getBookInfo() {
		
		return String.format("제목: %-20s   저자 : %-10s    가격 : %,d", title, author, price);
		
	}
}
