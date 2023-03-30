package day17.lamdalab;
import java.util.Random;

interface Drawable {
	 void draw();  // 자동으로 public
}

class Rect implements Drawable {
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}

class Circle implements Drawable {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}

class Diamond implements Drawable  {
	public void draw() {
		System.out.println("마름모를 그립니다.");
	}
}

public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random(); // 원하는 타입의 난수를 구하는 객체
		int num = rand.nextInt(3); //0~2사이 난수
		Drawable d = null;         //객체 초기화
		
		if(num == 0)
			d = () -> { System.out.println("사각형을 그립니다."); };
		else if(num == 1)
			d = () -> {System.out.println("원을 그립니다."); };
		else if(num == 2)
			d = () -> { System.out.println("마름모를 그립니다.");};
		
		output(d);
	}
	
	public static void output(Drawable d){
		System.out.println("전달된 객체의 클래스명 : "+
	                        d.getClass().getName());
		d.draw();
	}
}



