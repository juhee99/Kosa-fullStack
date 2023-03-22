package day7;

class MyObject {
	
	void printName() {
		System.out.println("자바듀크");
	}
	
	//Overriding
	public String toString() {
		return "Object의 자식클래스인 MyObject 객체임";
	}
}
public class MyObjecTest {

	public static void main(String[] args) {
		MyObject my = new MyObject();
		System.out.println(my.toString());
		System.out.println(my);
		System.out.println("출력 : "+my);
		my.printName();

	}

}
