package day1;

public class VarTest1 {
	public static void main(String[] args) {
		int number1;  //l-value 사용 가능 ,r-value는 사용 불가능
		//System.out.println(number1); //에러
		int number2 = 123;
		System.out.println(number2);
		number1 = 10;
		System.out.println(number1);		
		System.out.println(number2+number1);
		System.out.println(number2-number1);
		System.out.println(number2*number1);
		System.out.println(number2/number1);
		System.out.println("number1 : "+number1); // 문자열 결합
	}
}
