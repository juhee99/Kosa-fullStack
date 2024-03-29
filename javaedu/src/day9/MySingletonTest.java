package day9;

class MySingleton {
	private static MySingleton obj = new MySingleton();
	private MySingleton() {		
	}
	static MySingleton getMy() {
		return obj;
	}
	void printMyName() {
		System.out.println("유니코");	
	}
	void printFavoriteFood() {
		System.out.println("떡볶이");	
	}
}
public class MySingletonTest {
	public static void main(String[] args) {
		//MySingleton my = new MySingleton();
		MySingleton my = MySingleton.getMy();
		my.printMyName();
		my.printFavoriteFood();
		System.out.println(my);                              //day9.MySingleton@5ccd43c2
		System.out.println(MySingleton.getMy());   // day9.MySingleton@5ccd43c2
		System.out.println(MySingleton.getMy());   //day9.MySingleton@5ccd43c2    
	}
}
