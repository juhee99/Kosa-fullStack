package day17;

@FunctionalInterface
interface MyFunctionalInterface1 {
	public void method1();
}

public class LambdaTest5 {
	public static void main(String[] args) {
		MyFunctionalInterface1 fi = () -> { // 매개변수 없으면 괄호 생략 불가
			String str = "method call1";
			System.out.println(str);
		};
		fi.method1();

		fi = () -> System.out.println("method call2");		
		fi.method1();
	}
}
