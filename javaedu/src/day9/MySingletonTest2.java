package day9;

class MySingleton2 {
	private static MySingleton2 obj = null;
	private MySingleton2() {		
	}
	static MySingleton2 getMy() {
		if(obj == null)
			obj = new MySingleton2();
		return obj;
	}
	void printMyName() {
		System.out.println("듀크");	
	}
	void printFavoriteFood() {
		System.out.println("갈비");	
	}
}
public class MySingletonTest2 {
	public static void main(String[] args) {
		//MYSingleton2 my = new MYSingleton2();
		MySingleton2 my = MySingleton2.getMy();
		my.printMyName();
		my.printFavoriteFood();
		System.out.println(my);                              //day9.MYSingleton2@5ccd43c2
		System.out.println(MySingleton2.getMy());   // day9.MYSingleton2@5ccd43c2
		System.out.println(MySingleton2.getMy());   //day9.MYSingleton2@5ccd43c2    
	}
}
