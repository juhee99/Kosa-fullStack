package day6;

public class BookTest {
	public static void main(String[] args) {
		Book [] books = new Book[5];
		
		books[0] = new Book("자바의 정석","남궁성", 27000);
		books[1] = new Book("챗GPT","반병현", 11700);
		books[2] = new Book("스타트 스프링 부트","남가람", 27000);
		books[3] = new Book("Doit! 자바프로그래밍","박은중", 22500);
		books[4] = new Book(); 
		
		for(Book obj : books) {
			System.out.println(obj.getBookInfo());
		}		
	}
}
