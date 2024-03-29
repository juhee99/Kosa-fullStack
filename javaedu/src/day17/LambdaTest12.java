package day17;

interface ActionExpression {
	void exec(Object... param);
}

interface FuncExpression<T> { // interface가 generic 타입
	T exec(Object... param);
}

public class LambdaTest12 {
	public static void test1(ActionExpression action) {
		action.exec("hello world");
	}

	public static void test2(FuncExpression<String> func) {
		String ret = func.exec("hello world");
		System.out.println(ret);
	}

	public static void main(String[] args) throws Exception {
		test1(new ActionExpression() {                            //anonymous inn
			public void exec(Object... data) {
				System.out.println("Test1 - " + data[0]);
			}
		});
		test2(new FuncExpression<String>() {
			public String exec(Object... data) {
				System.out.println(data[0]);
				return "OK1";
			}
		});

		test1((Object... data) -> System.out.println("test2 - " + data[0]));

		test2((Object... data) -> {
			System.out.println(data[0]);
			return "OK2";
		});
		
		test2( data -> {
			System.out.println(data[0]);
			return "OK3";
		});
	}
}
